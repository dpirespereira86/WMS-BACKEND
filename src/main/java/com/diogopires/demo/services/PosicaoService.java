package com.diogopires.demo.services;


import java.util.List;

import java.util.stream.Collectors;


import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.domain.Produto;
import com.diogopires.demo.dto.PostPosicaoDTO;
import com.diogopires.demo.repository.PosicaoRepository;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PosicaoService {
  
  @Autowired
  private PosicaoRepository repo;
  
  @Autowired
  private ProdutoService produtoService;

  @Autowired
  private EstoqueService estoqueService;

  @Autowired
  private RuaService ruaService;

  @Autowired
  private PredioService predioService;

  @Autowired
  private NivelService nivelService;

  public Integer quantidadeProduto(Posicao pos, Produto produto) {
    Integer x = 0;
    
    for(Produto prod : pos.getProdutos()){
      if(prod.getId().equals(produto.getId())){
         x = x+ 1;
      }
    }
    
    return x;
 }

 public void removeProduto(Posicao pos, Produto produto, Double quantidade) {

    for(int i = 0; i < quantidade.intValue() ; i = i + 1 ){
      pos.getProdutos().remove(produto);

    }

    repo.save(pos);
  }

  public void addProduto(Posicao pos, Produto produto, Double quantidade) {

    for(int i = 0; i < quantidade.intValue() ; i = i + 1 ){
      pos.getProdutos().add(produto);
    }

    repo.save(pos);
  }

  public void sumQuantPeso(Posicao posicao, Double quantidade, Double peso){
    posicao.setQuantidade(posicao.getQuantidade() + quantidade);
    posicao.setPeso(peso + posicao.getPeso());

    repo.save(posicao);
  }

  public void removeQuantPeso(Posicao posicao, Double quantidade, Double peso){
    posicao.setQuantidade(posicao.getQuantidade() - quantidade);
    posicao.setPeso(peso - posicao.getPeso());

    repo.save(posicao);
  }
  
  public List<Posicao> findAll(Integer empresa){
    List<Posicao> posicoes = repo.findAll().stream()
    .filter(p -> p.getEstoque().getEmpresa().getId().equals(empresa))
    .collect(Collectors.toList());
    return posicoes;
  }
  
  public List<Posicao> ProductFindAllPosition(Integer empresa,Integer id){
   List<Produto> prod = produtoService.findOne(empresa, id);
   return prod.get(0).getPosicoes();
  }

  public List<Posicao> StockFindAllPosition(Integer empresa,Integer id){
    List<Posicao> posicoes = repo.findByEstoque(estoqueService.findOne(empresa, id).get(0));
    return posicoes;
  }

  public void validaNome(String nome,Integer empresa){
    List<Posicao> posicoes = findAll(empresa);
    for(Posicao p : posicoes){
      if(p.getNome().equalsIgnoreCase(nome)){
        throw new ObjectNotFoundException("Posição já existe !!");
      }
    }
  }

  public void validaOrdem(Estoque estoque,Integer ordem){
    for(Posicao p : estoque.getPosicoes()){
      if(p.getOrdem() == ordem){
        throw new ObjectNotFoundException("Ordem já existe para este estoque !!");
      }
    }
  }
  
  public Posicao insert(PostPosicaoDTO obj, Integer empresa){
    //busca o estoque 
    Estoque estoque = estoqueService.findOne(empresa,obj.getEstoque()).get(0);
    //Cria o objeto posição 
    Posicao posicao = new Posicao(
     null, 
     estoque,
     ruaService.findOne(obj.getRua()),
     predioService.findOne(obj.getPredio()),
     nivelService.findOne(obj.getNivel()),
     (Double) obj.getCapacidade(),
     obj.getOrdem());
    //Verifica se já existe uma posição igual
    validaNome(posicao.getNome(),empresa);
    //valida ordem
    validaOrdem(estoque,obj.getOrdem());
    //Adiciona a capacidade ao estoque
    estoque.setCapacidade(estoque.getCapacidade() + posicao.getCapacidade());
    //Salva o objeto posição
    return repo.save(posicao);
  }
}


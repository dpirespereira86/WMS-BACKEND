package com.diogopires.demo.services;


import java.util.List;

import java.util.stream.Collectors;

import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.domain.Nivel;
import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.domain.Predio;
import com.diogopires.demo.domain.Produto;
import com.diogopires.demo.domain.Rua;
import com.diogopires.demo.repository.PosicaoRepository;

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
  
  public Posicao insert(Posicao obj, Integer id){
    List<Estoque> estoque = estoqueService.findOne(id,obj.getEstoque().getId());
    Rua rua = ruaService.findOne(obj.getRua().getId());
    Predio predio = predioService.findOne(obj.getPredio().getId());
    Nivel nivel = nivelService.findOne(obj.getNivel().getId());
    obj.setId(null);
    obj.setNome(estoque.get(0).getNome() + "-" + rua.getNome() + predio.getNome() + nivel.getNome());
    obj.setPeso(0.00);
    obj.setQuantidade(0.00);
    return repo.save(obj);
  }
}


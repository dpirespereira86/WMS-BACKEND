package com.diogopires.demo.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.domain.ItemMovimentacao;
import com.diogopires.demo.domain.ItemPosicao;
import com.diogopires.demo.domain.Movimentacao;
import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.domain.Produto;
import com.diogopires.demo.repository.EmpresaRepository;
import com.diogopires.demo.repository.EstoqueRepository;
import com.diogopires.demo.repository.ItemMovimentacaoRepository;
import com.diogopires.demo.repository.ItemPosicaoRepository;
import com.diogopires.demo.repository.MovimentacaoRepository;
import com.diogopires.demo.repository.PosicaoRepository;
import com.diogopires.demo.repository.ProdutoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovimentacaoService {
  
  @Autowired
  private MovimentacaoRepository repo;

  @Autowired
  private EmpresaRepository empRepo;
  
  @Autowired
  private ItemMovimentacaoRepository itemRepo;
  
  @Autowired
  private ProdutoRepository produtoRepo;

  @Autowired
  private ProdutoService produtoServi;

  @Autowired
  private EstoqueRepository estoqueRepo;

  @Autowired
  private PosicaoRepository posicaoRepo;

  @Autowired
  private PosicaoService posicaoService;

  @Autowired
  private EstoqueService estoqueService;


  // @Autowired
  // private ItemMovimentacaoService itemMovimentacaoService;
  @Autowired
  private ItemPosicaoRepository itemPosicaoRepo;

  public List<Movimentacao> findAll(Integer empresa){
     List<Movimentacao> obj = repo.findAll();
     List<Movimentacao> mov = new ArrayList<>();
     for(Movimentacao x : obj){
        if(x.getEmpresa().getId().equals(empresa)){
          mov.addAll(Arrays.asList(x));
        }
     }
     return mov;
  }

  public Movimentacao entradaInsert(Movimentacao obj, Integer empresa){
    Optional<Posicao> pos = posicaoRepo.findById(obj.getPosicao().getId());
    Optional<Estoque> est = estoqueRepo.findById(pos.get().getEstoque().getId());

    if(produtoServi.validaCompany(empresa, obj.getItens()) == true && est.get().getId() == empresa)
     {
      obj.setId(null);
      obj.setInstante(new Date());
      obj.setEmpresa(empRepo.findById(empresa).get());
      repo.save(obj);

      for(ItemMovimentacao im : obj.getItens()){

        Optional<Produto> prod = produtoRepo.findById(im.getProduto().getId());

        switch (obj.getOperacao().toString()) {
          case "ENTRADA":
            // Integer codigo = itemMovimentacaoService.lastCod();
            //Trata item Movimentacão------------
            Random gerador = new Random();
            im.setMovimentacao(obj);
            im.setDescricaoProduto(prod.get().getDescricao());
            Integer codigo = (obj.getId()) * gerador.nextInt(1000);
            im.setCodigoInterno(prod.get().getCodigoBarra() + "-" + codigo.toString());
            im.setPosicao(pos.get());

            
            for(int i = 0 ; i < im.getQuantidade().intValue();i = i+1){
              Integer codigoOne = (obj.getId()) + gerador.nextInt(1000);
              ItemPosicao itemPosicao = new ItemPosicao();
              itemPosicao.setCodInterno(prod.get().getCodigoBarra() + "-" + codigoOne + obj.getId());
              itemPosicao.setDescricaoProduto(prod.get().getDescricao());
              itemPosicao.setPosicao(pos.get());
              itemPosicao.setPeso(prod.get().getPeso());
              itemPosicao.setQuantidade(1.00);
              itemPosicao.setId(null);
              itemPosicaoRepo.save(itemPosicao);

            }
            
            
            
            //Trata a Posição----------------------
            posicaoService.addProduto(pos.get(), prod.get(),im.getQuantidade());
            posicaoService.sumQuantPeso(pos.get(), im.getQuantidade(), im.getPeso());
            //Trata a Estoque-----------------------
            estoqueService.sumQuantPeso(est.get(), im.getQuantidade(), im.getPeso());
            //Trata a Produto-----------------------
            produtoServi.sumQuantPeso(prod.get(), im.getQuantidade(), im.getPeso());
            //Trata o Item Posicao-------------------
           
            System.out.println("-------------------PASSEI AQUI MOVI---------------------");
           
            break;              
          case "SAIDA":
            
            if(posicaoService.quantidadeProduto(pos.get(), prod.get()) >= im.getQuantidade()){
              //Trata item Movimentacão------------
              im.setMovimentacao(obj);
              im.setDescricaoProduto(prod.get().getDescricao());
              // im.setCodigoInterno(Integer.parseInt(prod.get().getCodigoBarra()));
              //Trata a Produto-----------------------
              produtoServi.removeQuantPeso(prod.get(), im.getQuantidade(),im.getPeso());
              //Trata a Posição----------------------
              posicaoService.removeProduto(pos.get(), prod.get(),im.getQuantidade());
              posicaoService.removeQuantPeso(pos.get(), im.getQuantidade(), im.getPeso());
              //Trata a Estoque-----------------------
              estoqueService.removeQuantPeso(est.get(), im.getQuantidade(), im.getPeso());
             
            }
            break;
          default:
            break;
        }
      }
      itemRepo.saveAll(obj.getItens());
      return obj;
    }
    else
    {
      return null;
    }
      
    
  }
  
}

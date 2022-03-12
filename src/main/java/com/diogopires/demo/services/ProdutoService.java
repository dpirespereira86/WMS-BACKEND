package com.diogopires.demo.services;




import java.util.List;
import java.util.stream.Collectors;


import com.diogopires.demo.domain.ItemMovimentacao;
import com.diogopires.demo.domain.Produto;
import com.diogopires.demo.repository.ProdutoRepository;
import com.diogopires.demo.services.exceptions.DataIntegrityException;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutoRepository repo;
  
  @Autowired
  private EmpresaService serviceEmp;

  public Boolean validaCompany(Integer empresa, List<ItemMovimentacao> itens) {
    Integer x = 0;
    Integer count = 0;
    for(ItemMovimentacao im : itens){
      Integer emp = repo.findById(im.getProduto().
      getId()).get().getEmpresa().getId();
      count = count + 1;
      if (emp == empresa ){
        x = x + 1;
      }
    }
     return x == count ? true : false;
  }

  public void sumQuantPeso(Produto produto, Double quantidade, Double peso){
    produto.setQuantidade(produto.getQuantidade() + quantidade);
    produto.setPeso(peso + produto.getPeso());

    repo.save(produto);
  }

  public void removeQuantPeso(Produto produto, Double quantidade, Double peso){
    produto.setQuantidade(produto.getQuantidade() - quantidade);
    produto.setPeso(peso - produto.getPeso());

    repo.save(produto);
  }
  
  public List<Produto> findAll(Integer empresa){
    List<Produto> produto = repo.findAll().stream().
    filter(p-> p.getEmpresa().getId().equals(empresa))
    .collect(Collectors.toList());
    return produto;
  }

  public List<Produto> findOne(Integer empresa, Integer id){
    List<Produto> produto = repo.findAll().stream().
    filter(p-> p.getEmpresa().getId().equals(empresa) && 
    p.getId().equals(id))
    .collect(Collectors.toList());
    if(produto.isEmpty()){
      throw new ObjectNotFoundException("Produto"  + " não existe!!");
    }
    return produto;
  }

  public Produto insert(Integer empresa, Produto obj){
    obj.setId(null);
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    List<Produto> prod = findAll(empresa);
    for(Produto x : prod){
      if(x.getCodigoBarra().contentEquals(obj.getCodigoBarra())){
        throw new ObjectNotFoundException("Produto com mesmo código");
      }
    }
    return repo.save(obj);
    
  }

  public Produto update(Produto obj, Integer empresa){
    findOne(empresa, obj.getId());
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    return repo.save(obj);
    
  }

  public void delete(Integer empresa,Integer id){
    findOne(empresa,id);
    try{
      repo.delete(repo.findById(id).get());
    }
    catch (DataIntegrityException e) {
      throw new DataIntegrityException("Não é possível excluir esta rua!");
    }
  }

}


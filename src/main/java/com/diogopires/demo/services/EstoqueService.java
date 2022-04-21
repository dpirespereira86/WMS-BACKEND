package com.diogopires.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.repository.EmpresaRepository;
import com.diogopires.demo.repository.EstoqueRepository;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
  
  @Autowired
  private EstoqueRepository repo;

  @Autowired
  private EmpresaService empresaServico;

  @Autowired
  private EmpresaRepository repoEmpresa;

  public Boolean validaEstoque(Integer empresa, Integer idEstoque) {
    Optional<Estoque> est =  repo.findById(idEstoque);
     return est.get().getEmpresa().getId() == empresa ? true : false;
  }

  public void sumQuantPeso(Estoque estoque, Double quantidade, Double peso){
    estoque.setQuantidade(estoque.getQuantidade() + quantidade);
    estoque.setPeso(peso + estoque.getPeso());

    repo.save(estoque);
  }

  public void removeQuantPeso(Estoque estoque, Double quantidade, Double peso){
    estoque.setQuantidade(estoque.getQuantidade() - quantidade);
    estoque.setPeso(peso - estoque.getPeso());

    repo.save(estoque);
  }
  
  public List<Estoque> findAll(Integer empresa){
    List<Estoque> estoques = repo.findByEmpresa(repoEmpresa.findById(empresa).get());
    if(estoques.isEmpty()){
      throw new ObjectNotFoundException("Estoque não existe!!");
    }
    return estoques;
  }

  public List<Estoque> findOne(Integer empresa,Integer id){
    List<Estoque> estoques = repo.findAll().stream()
    .filter(p -> p.getEmpresa().getId().equals(empresa) && 
    p.getId().equals(id))
    .collect(Collectors.toList());
    if(estoques.isEmpty()){
      throw new ObjectNotFoundException("Estoque " + id + " não existe!!");
    }
    return estoques;
  }
  //Cria um novo estoque no banco de dados
  public Estoque insert(Estoque obj,Integer empresa){
    //TODO :Resolver o envio da menssagem de validação.
    if(repo.findByNome(obj.getNome().toUpperCase()) != null  && repo.findByNome(obj.getNome()).getEmpresa().getId() == empresa){
      throw new ObjectNotFoundException("O nome de estoque já existe!!");
    }
    obj.setId(null);
    obj.setEmpresa(empresaServico.buscar(empresa).get());
    obj.setPeso(0.00);
    obj.setQuantidade(0.00);
    obj.setCapacidade(0.00);
    obj.setNome(obj.getNome().toUpperCase());
    return repo.save(obj);
  }
}


package com.diogopires.demo.services;


import com.diogopires.demo.domain.Nivel;
import com.diogopires.demo.repository.NivelRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.diogopires.demo.services.exceptions.DataIntegrityException;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;



@Service
public class NivelService {
  
  @Autowired
  private NivelRepository repo;
  
  @Autowired
  private EmpresaService serviceEmp;

  public Nivel findOne(Integer id){
    Optional<Nivel> Nivel = repo.findById(id);
    return Nivel.get() ;
  }

  public List<Nivel> findAll(Integer empresa){
     List<Nivel> Nivel = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)).collect(Collectors.toList());
     if(Nivel.isEmpty()){
      throw new ObjectNotFoundException("Não existe Nivel cadastrada nesta empresa!!");
    }
     return Nivel;
  }

  public List<Nivel> findOneTo(Integer empresa, Integer id){
    List<Nivel> Nivel = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)
     && p.getId().equals(id)).collect(Collectors.toList());
     if(Nivel.isEmpty()){
       throw new ObjectNotFoundException("Nivel " + id + " não existe nesta empresa!!");
     }
    return Nivel ;
  }

  public Page<Nivel> findPage(Integer empresa,Integer page,Integer linesPerPage, String orderBy,String direction){
    PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
    Page<Nivel> x = new PageImpl<>(findAll(empresa),pageRequest,findAll(empresa).size());
    return x;
  }
    

  public Nivel insert(Integer empresa, Nivel obj){
    obj.setId(null);
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    List<Nivel> prod = findAll(empresa);
    for(Nivel x : prod){
      if(x.getNome().contentEquals(obj.getNome())){
        throw new ObjectNotFoundException("Nome de Nivel já existe");
      }
    }
    return repo.save(obj);
    
  }

  public Nivel update(Nivel obj, Integer empresa){
    findOneTo(empresa, obj.getId());
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    return repo.save(obj);
    
  }

  public void delete(Integer empresa,Integer id){
    findOneTo(empresa,id);
    try{
      repo.delete(findOne(id));
    }
    catch (DataIntegrityException e) {
      throw new DataIntegrityException("Não é possível excluir este Nivel!");
    }
  }
}

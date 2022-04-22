package com.diogopires.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Rua;
import com.diogopires.demo.repository.RuaRepository;
import com.diogopires.demo.services.exceptions.DataIntegrityException;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;



@Service
public class RuaService {
  
  @Autowired
  private RuaRepository repo;
  
  @Autowired
  private EmpresaService serviceEmp;

  public Rua findOne(Integer id){
    Optional<Rua> rua = repo.findById(id);
    return rua.get() ;
  }

  public List<Rua> findAll(Integer empresa){
     List<Rua> rua = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)).collect(Collectors.toList());
     if(rua.isEmpty()){
      throw new ObjectNotFoundException("Não existe rua cadastrada nesta empresa!!");
    }
     return rua;
  }

  public List<Rua> findOneTo(Integer empresa, Integer id){
    List<Rua> rua = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)
     && p.getId().equals(id)).collect(Collectors.toList());
     if(rua.isEmpty()){
       throw new ObjectNotFoundException("Rua " + id + " não existe nesta empresa!!");
     }
    return rua ;
  }

  public Page<Rua> findPage(Integer empresa,Integer page,Integer linesPerPage, String orderBy,String direction){
    PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
    Page<Rua> x = new PageImpl<>(findAll(empresa),pageRequest,findAll(empresa).size());
    return x;
  }
    

  public Rua insert(Integer empresa, Rua obj){
    obj.setId(null);
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    List<Rua> prod = findAll(empresa);
    for(Rua x : prod){
      if(x.getNome().equalsIgnoreCase(obj.getNome())){
        throw new ObjectNotFoundException("Nome da rua já existe");
      }
    }
    return repo.save(obj);
    
  }

  public Rua update(Rua obj, Integer empresa){
    findOneTo(empresa, obj.getId());
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    return repo.save(obj);
    
  }

  public void delete(Integer empresa,Integer id){
    findOneTo(empresa,id);
    try{
      repo.delete(findOne(id));
    }
    catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não é possível excluir esta rua!");
    }
  }
}

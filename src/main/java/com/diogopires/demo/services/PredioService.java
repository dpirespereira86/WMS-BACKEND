package com.diogopires.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Predio;
import com.diogopires.demo.repository.PredioRepository;
import com.diogopires.demo.services.exceptions.DataIntegrityException;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;



@Service
public class PredioService {
  
  @Autowired
  private PredioRepository repo;
  
  @Autowired
  private EmpresaService serviceEmp;

  public Predio findOne(Integer id){
    Optional<Predio> Predio = repo.findById(id);
    return Predio.get() ;
  }

  public List<Predio> findAll(Integer empresa){
     List<Predio> Predio = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)).collect(Collectors.toList());
     if(Predio.isEmpty()){
      throw new ObjectNotFoundException("Não existe Predio cadastrada nesta empresa!!");
    }
     return Predio;
  }

  public List<Predio> findOneTo(Integer empresa, Integer id){
    List<Predio> Predio = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)
     && p.getId().equals(id)).collect(Collectors.toList());
     if(Predio.isEmpty()){
       throw new ObjectNotFoundException("Predio " + id + " não existe nesta empresa!!");
     }
    return Predio ;
  }

  public Page<Predio> findPage(Integer empresa,Integer page,Integer linesPerPage, String orderBy,String direction){
    PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
    Page<Predio> x = new PageImpl<>(findAll(empresa),pageRequest,findAll(empresa).size());
    return x;
  }
    

  public Predio insert(Integer empresa, Predio obj){
    obj.setId(null);
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    List<Predio> prod = findAll(empresa);
    for(Predio x : prod){
      if(x.getNome().equalsIgnoreCase(obj.getNome())){
        throw new ObjectNotFoundException("Nome de Predio já existe");
      }
    }
    return repo.save(obj);
    
  }

  public Predio update(Predio obj, Integer empresa){
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
      throw new DataIntegrityException("Não é possível excluir este Predio!");
    }
  }
}

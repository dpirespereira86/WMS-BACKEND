package com.diogopires.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Fornecedor;
import com.diogopires.demo.repository.FornecedorRepository;
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
public class FornecedorService {

  @Autowired
  private FornecedorRepository repo;
  
  @Autowired
  private EmpresaService serviceEmp;

  public Fornecedor findOne(Integer id){
    Optional<Fornecedor> Fornecedor = repo.findById(id);
    return Fornecedor.get() ;
  }

  public List<Fornecedor> findAll(Integer empresa){
     List<Fornecedor> fornecedor = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)).collect(Collectors.toList());
     if(fornecedor.isEmpty()){
      throw new ObjectNotFoundException("Não existe Fornecedor cadastrada nesta empresa!!");
    }
     return fornecedor;
  }

  public List<Fornecedor> findOneTo(Integer empresa, Integer id){
    List<Fornecedor> fornecedor = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)
     && p.getId().equals(id)).collect(Collectors.toList());
     if(fornecedor.isEmpty()){
       throw new ObjectNotFoundException("Fornecedor " + id + " não existe nesta empresa!!");
     }
    return fornecedor ;
  }

  public Page<Fornecedor> findPage(Integer empresa,Integer page,Integer linesPerPage, String orderBy,String direction){
    PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
    Page<Fornecedor> x = new PageImpl<>(findAll(empresa),pageRequest,findAll(empresa).size());
    return x;
  }
    

  public Fornecedor insert(Integer empresa, Fornecedor obj){
    obj.setId(null);
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    return repo.save(obj);
    
  }

  public Fornecedor update(Fornecedor obj, Integer empresa){
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
      throw new DataIntegrityException("Não é possível excluir esta Fornecedor!");
    }
  }
  
}

package com.diogopires.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.PedidoCompra;
import com.diogopires.demo.repository.PedidoCompraRepository;
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
public class PedidoCompraService {

  @Autowired
  private PedidoCompraRepository repo;

  @Autowired
  private EmpresaService serviceEmp;

  public PedidoCompra findOne(Integer id){
    Optional<PedidoCompra> PedidoCompra = repo.findById(id);
    return PedidoCompra.get() ;
  }

  public List<PedidoCompra> findAll(Integer empresa){
     List<PedidoCompra> PedidoCompra = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)).collect(Collectors.toList());
     if(PedidoCompra.isEmpty()){
      throw new ObjectNotFoundException("Não existe Pedido de Compra cadastrada nesta empresa!!");
    }
     return PedidoCompra;
  }

  public List<PedidoCompra> findOneTo(Integer empresa, Integer id){
    List<PedidoCompra> PedidoCompra = repo.findAll().stream().filter(p -> p.getEmpresa().getId().equals(empresa)
     && p.getId().equals(id)).collect(Collectors.toList());
     if(PedidoCompra.isEmpty()){
       throw new ObjectNotFoundException("PedidoCompra " + id + " não existe nesta empresa!!");
     }
    return PedidoCompra ;
  }

  public Page<PedidoCompra> findPage(Integer empresa,Integer page,Integer linesPerPage, String orderBy,String direction){
    PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
    Page<PedidoCompra> x = new PageImpl<>(findAll(empresa),pageRequest,findAll(empresa).size());
    return x;
  }
    

  public PedidoCompra insert(Integer empresa, PedidoCompra obj){
    obj.setId(null);
    obj.setEmpresa(serviceEmp.buscar(empresa).get());
    obj.setInstante(new Date());
    return repo.save(obj);
    
  }

  public PedidoCompra update(PedidoCompra obj, Integer empresa){
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
      throw new DataIntegrityException("Não é possível excluir esta PedidoCompra!");
    }
  }
}

package com.diogopires.demo.services;




import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Fornecedor;
import com.diogopires.demo.domain.ItemMovimentacao;
import com.diogopires.demo.domain.Produto;
// import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.dto.PostProdutoDTO;
import com.diogopires.demo.dto.ProdutoDTO;
import com.diogopires.demo.repository.FornecedorRepository;
import com.diogopires.demo.repository.ProdutoRepository;
import com.diogopires.demo.security.UserSS;
import com.diogopires.demo.services.exceptions.AuthorizationException;
import com.diogopires.demo.services.exceptions.DataIntegrityException;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutoRepository repo;
  
  @Autowired
  private EmpresaService serviceEmp;

  @Autowired
  private FornecedorService serviceForn;
  
  @Autowired
  private S3Service s3Service;
  
  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private FornecedorRepository fornecedorRepo;

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

  public Produto insert(Integer empresa, PostProdutoDTO obj){

    List<Produto> produto = findAll(empresa);
    for(Produto x : produto){
      if(x.getCodigoBarra().contentEquals(obj.getCodigoBarra())){
        throw new ObjectNotFoundException("Produto com mesmo código");
      }
    }

    System.out.print("olha eu aqui ");

    Produto prod = new Produto(null,
    obj.getCodigoBarra(),
    obj.getSku(),
    obj.getDescricao(),
    (Double) obj.getComprimento(),
    (Double) obj.getLargura(),
    (Double) obj.getAltura(),
    (Double) obj.getPeso(),
    (Double) obj.getUltimoPrecoCompra(),
    obj.getUnidade(),
    (Double) obj.getEstoqueMinimo(),
    (Double) obj.getEstoqueMaximo(),
    (Double) obj.getQuantidade(),
    obj.getPrazoEntrega(),
    serviceEmp.buscar(empresa).get(),
    serviceForn.findOne(obj.getFornecedor()));

    
    prod.setDataCriacao();

    return repo.save(prod);
    
  }

  public Produto update(ProdutoDTO obj, Integer empresa){
    findOne(empresa, obj.getId());
    System.out.println("Fornecedor: "+ obj.getFornecedor());
    Fornecedor forn = fornecedorRepo.findByRazaoSocial(obj.getFornecedor());
    if(forn == null){
      throw new ObjectNotFoundException("Não foi encontrado fornecedor");
    }
    Produto prod = new Produto(obj.getId(),
    obj.getCodigoBarra(),
    obj.getSku(),
    obj.getDescricao(),
    (Double) obj.getComprimento(),
    (Double) obj.getLargura(),
    (Double) obj.getAltura(),
    (Double) obj.getPeso(),
    (Double) obj.getUltimoPrecoCompra(),
    obj.getUnidade(),
    (Double) obj.getEstoqueMinimo(),
    (Double) obj.getEstoqueMaximo(),
    (Double) obj.getQuantidade(),
    obj.getPrazoEntrega(),
    serviceEmp.buscar(empresa).get(),
    forn);
    prod.setDataAtualizacao();
    return repo.save(prod);
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

  public List<Produto> lastProduct(Integer empresa){
     Integer y = 0;
     List<Produto> prod = findAll(empresa);
     for(Produto p : prod){
       Integer x = p.getId();
       if( x > y ){
         y = x;
       }
     }
     return findOne(empresa,y);
  }

  public URI uploadProfilePicture(MultipartFile multipartFile,Integer id){
    UserSS user = UserService.authenticated();
    if(user == null){
      throw new AuthorizationException("Acesso Negado");
    }

    try{
      Produto prod = repo.getById(id);
      URI uri = s3Service.uploadFile(multipartFile);
      prod.setImageUrl(uri.toString());
      repo.save(prod);
      return uri;
    }
    catch (ObjectNotFoundException e) {
      throw new ObjectNotFoundException("Id: " + id + " Não foi encontrado");
    }
  }

}


package com.diogopires.demo.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.diogopires.demo.domain.Empresa;
import com.diogopires.demo.domain.EnderecoEmpresa;
import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.domain.Fornecedor;
import com.diogopires.demo.domain.ItemMovimentacao;
import com.diogopires.demo.domain.ItemPedidoCompra;
import com.diogopires.demo.domain.ItemPosicao;
import com.diogopires.demo.domain.Movimentacao;
import com.diogopires.demo.domain.Nivel;
import com.diogopires.demo.domain.PedidoCompra;
import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.domain.Predio;
import com.diogopires.demo.domain.Produto;
import com.diogopires.demo.domain.Rua;
import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.domain.enums.Origem;
import com.diogopires.demo.domain.enums.Perfil;
import com.diogopires.demo.domain.enums.StatusCompra;
import com.diogopires.demo.domain.enums.TipoMovimentacao;
import com.diogopires.demo.repository.EmpresaRepository;
import com.diogopires.demo.repository.EnderecoEmpresaRepository;
import com.diogopires.demo.repository.EstoqueRepository;
import com.diogopires.demo.repository.FornecedorRepository;
import com.diogopires.demo.repository.ItemMovimentacaoRepository;
import com.diogopires.demo.repository.ItemPedidoCompraRepository;
import com.diogopires.demo.repository.ItemPosicaoRepository;
import com.diogopires.demo.repository.MovimentacaoRepository;
import com.diogopires.demo.repository.NivelRepository;
import com.diogopires.demo.repository.PedidoCompraRepository;
import com.diogopires.demo.repository.PosicaoRepository;
import com.diogopires.demo.repository.PredioRepository;
import com.diogopires.demo.repository.ProdutoRepository;
import com.diogopires.demo.repository.RuaRepository;
import com.diogopires.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBService {

	@Autowired
  private BCryptPasswordEncoder be;

  @Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
  
	@Autowired
	private ProdutoRepository produtoRepository;
  
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

  @Autowired
	private ItemMovimentacaoRepository itemMovimentacaoRepository;
  
	@Autowired
	private EnderecoEmpresaRepository enderecoEmpresaRepository;

	@Autowired
	private RuaRepository ruaRepository;

	@Autowired
	private PredioRepository predioRepository;

	@Autowired
	private NivelRepository nivelRepository;

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Autowired
	private PosicaoRepository posicaoRepository;
  
	@Autowired
	private ItemPosicaoRepository itemPosicaoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private PedidoCompraRepository pedidoCompraRepository;

	@Autowired
	private ItemPedidoCompraRepository itemPedidoCompraRepository;

  
  public void instanteTestDatabase() throws ParseException{
      
    Empresa emp1 = new Empresa(null,"Steel Rocha","20.000.000/0001-00");
		Empresa emp2 = new Empresa(null,"ELohim Design","20.000.000/0001-20");

		empresaRepository.saveAll(Arrays.asList(emp1,emp2));

		Usuario user1 = new Usuario(null, "dpirespereira86@gmail.com", "ADM","Diogo Pires", emp1,be.encode("2345678"));
    user1.addPerfil(Perfil.ADMIN);

		Usuario user2 = new Usuario(null, "dpirespereira86@outlook.com.br", "PRO","Eduardo Saraiva", emp2,be.encode("98765432"));
    user2.addPerfil(Perfil.ADMIN);

		Usuario user3 = new Usuario(null, "camila86@gmail.com", "ADM","Camila Pires", emp1,be.encode("123456789"));
   

		Usuario user4 = new Usuario(null, "sandro86@outlook.com.br", "PRO","Sandro Saraiva", emp2,be.encode("98765432"));
    

		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3,user4));

		Fornecedor fonr1 = new Fornecedor(null, "Steel Rocha","20.000.000/0001-00",emp1,"dpirespereira86@outlook.com");
		Fornecedor fonr2 = new Fornecedor(null, "ELohim Design","20.000.000/0001-20",emp2,"dpirespereira86@outlook.com");
		Fornecedor fonr3 = new Fornecedor(null, "ELohim Design","20.000.000/0001-20",emp1,"dpirespereira86@outlook.com");


		fornecedorRepository.saveAll(Arrays.asList(fonr1,fonr2,fonr3));

		Produto prod1 = new Produto(null, "123654789","236598875", "Balcão refrigerado", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60,emp1,fonr1);
		Produto prod2 = new Produto(null, "123654790","369852147", "Balcão Estufa", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60,emp2,fonr2);
		Produto prod3 = new Produto(null, "123654791","123654789" ,"Balcão Seco", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60, emp1,fonr1);
		Produto prod4 = new Produto(null, "123654792","852741963", "Vitrine Refrigerada", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60, emp2,fonr2);
		Produto prod5 = new Produto(null, "123654793","789654321", "Vitrine Estufa", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60,emp1,fonr1);
		Produto prod6 = new Produto(null, "123654794","753159846","Vitrine Seca", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60,emp2,fonr2);
		Produto prod7 = new Produto(null, "123654795","951357268", "Mesa Self Service", 1.00, 0.60, 1.80, 10.50, 50.60, "und", 500.00, 1000.00, 0.00, 60,emp1,fonr1);

		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7));

		Rua rua1 = new Rua(null,"A",emp1);
		Rua rua2 = new Rua(null,"B",emp1);
		Rua rua3 = new Rua(null,"C",emp1);
		Rua rua4 = new Rua(null,"A",emp2);
		Rua rua5 = new Rua(null,"B",emp2);
		Rua rua6 = new Rua(null,"C",emp2);

    ruaRepository.saveAll(Arrays.asList(rua1,rua2,rua3,rua4,rua5,rua6));

		Predio pred1 = new Predio(null, "A", emp1);
		Predio pred2 = new Predio(null, "B", emp1);
		Predio pred3 = new Predio(null, "C", emp1);
		Predio pred4 = new Predio(null, "A", emp2);
		Predio pred5 = new Predio(null, "B", emp2);
		Predio pred6 = new Predio(null, "C", emp2);
		Predio pred7 = new Predio(null, "D", emp2);

    predioRepository.saveAll(Arrays.asList(pred1,pred2,pred3,pred4,pred5,pred6,pred7));

    Nivel niv1 = new Nivel(null, "1", emp1);
		Nivel niv2 = new Nivel(null, "2", emp1);
		Nivel niv3 = new Nivel(null, "3", emp1);
		Nivel niv4 = new Nivel(null, "1", emp2);
		Nivel niv5 = new Nivel(null, "2", emp2);
		Nivel niv6 = new Nivel(null, "3", emp2);
		Nivel niv7 = new Nivel(null, "4", emp2);

		nivelRepository.saveAll(Arrays.asList(niv1,niv2,niv3,niv4,niv5,niv6,niv7));

		Estoque est1 = new Estoque(null, "Principal", emp1);
		Estoque est2 = new Estoque(null, "Secundário", emp1);
		Estoque est3 = new Estoque(null, "Principal", emp2);

    estoqueRepository.saveAll(Arrays.asList(est1,est2,est3));

		Posicao pos1 =  new Posicao(null, est1, rua1, pred1, niv1);
		Posicao pos2 =  new Posicao(null, est1, rua1, pred1, niv2);
		Posicao pos3 =  new Posicao(null, est1, rua2, pred1, niv1);
		Posicao pos4 =  new Posicao(null, est1, rua2, pred2, niv2);
		Posicao pos5 =  new Posicao(null, est2, rua2, pred2, niv2);
		Posicao pos6 =  new Posicao(null, est3, rua1, pred1, niv1);
		Posicao pos7 =  new Posicao(null, est3, rua1, pred1, niv2);
		Posicao pos8 =  new Posicao(null, est3, rua1, pred1, niv3);

		pos1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3,prod4));
		pos2.getProdutos().addAll(Arrays.asList(prod2,prod4,prod6));
		pos3.getProdutos().addAll(Arrays.asList(prod5,prod7));


		posicaoRepository.saveAll(Arrays.asList(pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8));

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    Movimentacao mov1 = new Movimentacao(null,sdf.parse("30/05/2021 12:00"),TipoMovimentacao.ENTRADA,emp1,pos1);
		Movimentacao mov2 = new Movimentacao(null,sdf.parse("30/05/2021 12:00"),TipoMovimentacao.ENTRADA,emp2,pos2);
		Movimentacao mov3 = new Movimentacao(null,sdf.parse("30/05/2021 12:00"),TipoMovimentacao.ENTRADA,emp1,pos3);

		movimentacaoRepository.saveAll(Arrays.asList(mov1,mov2,mov3));

		ItemMovimentacao itmo1 = new ItemMovimentacao(mov1, prod1,"1", 1.00, 5.00);
		ItemMovimentacao itmo2 = new ItemMovimentacao(mov1, prod2,"2", 2.00, 5.00);
		ItemMovimentacao itmo3 = new ItemMovimentacao(mov1, prod3,"3", 3.00, 5.00);
		ItemMovimentacao itmo4 = new ItemMovimentacao(mov1, prod4,"4", 4.00, 5.00);
		ItemMovimentacao itmo5 = new ItemMovimentacao(mov1, prod3,"5", 1.00, 5.00);
    ItemMovimentacao itmo6 = new ItemMovimentacao(mov2, prod2,"6", 1.00, 5.00);
		ItemMovimentacao itmo7 = new ItemMovimentacao(mov2, prod4,"7", 1.00, 5.00);
		ItemMovimentacao itmo8 = new ItemMovimentacao(mov2, prod6,"8", 1.00, 5.00);
		ItemMovimentacao itmo9 = new ItemMovimentacao(mov3, prod5,"9", 1.00, 5.00);
		ItemMovimentacao itmo10 = new ItemMovimentacao(mov3, prod7,"10", 1.00, 5.00);


		itemMovimentacaoRepository.saveAll(Arrays.asList(itmo1,itmo2,itmo3,itmo4,itmo5,itmo6,itmo7,itmo8,itmo9,itmo10));

		ItemPosicao ip1 = new ItemPosicao(null, prod1.getCodigoBarra(), prod1.getDescricao(),1.00, 1.00, pos1);
		ItemPosicao ip2 = new ItemPosicao(null, prod2.getCodigoBarra(), prod2.getDescricao(),1.00, 1.00, pos1);
		ItemPosicao ip3 = new ItemPosicao(null, prod3.getCodigoBarra(), prod3.getDescricao(),1.00, 1.00, pos1);
		ItemPosicao ip4 = new ItemPosicao(null, prod4.getCodigoBarra(), prod4.getDescricao(),1.00, 1.00, pos1);
		ItemPosicao ip5 = new ItemPosicao(null, prod3.getCodigoBarra(), prod3.getDescricao(),1.00, 1.00, pos1);
		ItemPosicao ip6 = new ItemPosicao(null, prod2.getCodigoBarra(), prod2.getDescricao(),1.00, 1.00, pos2);
		ItemPosicao ip7 = new ItemPosicao(null, prod4.getCodigoBarra(), prod4.getDescricao(),1.00, 1.00, pos2);
		ItemPosicao ip8 = new ItemPosicao(null, prod6.getCodigoBarra(), prod6.getDescricao(),1.00, 1.00, pos2);
		ItemPosicao ip9 = new ItemPosicao(null, prod5.getCodigoBarra(), prod5.getDescricao(),1.00, 1.00, pos3);
		ItemPosicao ip10 = new ItemPosicao(null, prod7.getCodigoBarra(), prod7.getDescricao(),1.00, 1.00, pos3);

		itemPosicaoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4,ip5,ip6,ip7,ip8,ip9,ip10));

		EnderecoEmpresa end1 = new EnderecoEmpresa(null, "Rua Cel. Francisco Lima", "120", "S/N", "Gradim" ,"24430-280",emp1);
		EnderecoEmpresa end2 = new EnderecoEmpresa(null, "Rua Oscar Maldonado", "700", "S/N", "Paraiso" ,"2426-700",emp2);

    enderecoEmpresaRepository.saveAll(Arrays.asList(end1,end2));

		PedidoCompra pdc1 = new PedidoCompra(null, sdf.parse("30/05/2021 12:00"), Origem.MANUAL, emp1, StatusCompra.COTAR,fonr1);

    pedidoCompraRepository.saveAll(Arrays.asList(pdc1));

		ItemPedidoCompra ipc = new ItemPedidoCompra(prod1, pdc1, 50.00, 50.00, 5.00, 4.50);

		itemPedidoCompraRepository.saveAll(Arrays.asList(ipc));
	}
}

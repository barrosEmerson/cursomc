package com.barrostech.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.barrostech.mc.domain.Categoria;
import com.barrostech.mc.domain.Cidade;
import com.barrostech.mc.domain.Cliente;
import com.barrostech.mc.domain.Endereco;
import com.barrostech.mc.domain.Estado;
import com.barrostech.mc.domain.Produto;
import com.barrostech.mc.domain.enums.TipoCliente;
import com.barrostech.mc.repositories.CategoriaRepository;
import com.barrostech.mc.repositories.CidadeRepository;
import com.barrostech.mc.repositories.ClienteRepository;
import com.barrostech.mc.repositories.EnderecoRepository;
import com.barrostech.mc.repositories.EstadoRepository;
import com.barrostech.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2  = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "321345562", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("234354646","987675646"));
		
		Endereco e1 = new Endereco(null, "Rua Benedito Cardoso de Barros", "267", "Casa", "Agua Fria", "07752-170", cli1, c1);
		Endereco e2 = new Endereco(null, "Deovair Crus de Oliveira", "239", "Comércio", "Jordanésia", "07750-170", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList( e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));

		
	}
	
	
	
}

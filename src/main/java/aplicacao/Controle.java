package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sistema.*;

public class Controle {
	
	ClienteDao cliente = new ClienteDao();
	ProdutoDao produto = new ProdutoDao();
	 int opcao1 = 22;
	 int opcao2 = 22;
	
	
	public static void main(String[] args) {
		
		
		Controle inicio = new Controle();
		inicio.menuInicial();
		

	}
	
	public void menuInicial() {
		Scanner scnMenu = new Scanner(System.in);
		
		do{
			
			System.out.println("O que deseja fazer?");
			System.out.println("1-Gerenciar Clientes");
			System.out.println("2-Gerenciar Produtos");
			System.out.println("0-Sair");
			try {
				opcao1 = scnMenu.nextInt();
				if (opcao1 == 1) {
					menuClientes();
				} else if (opcao1 == 2) {
					menuProdutos();
				}
				else if(opcao1 == 0) {
					System.exit(0);
				}
			} catch (Exception ex) {
				System.out.println("Opção inválida");
				System.out.println(ex);
			}
		}
		while (true);
	}
	
	//clientes
	private void menuClientes() {
		Scanner scnCli = new Scanner(System.in);
		do {
			
			System.out.println("O que deseja fazer?");
			System.out.println("1-Cadastrar novo cliente");
			System.out.println("2-Alterar dados de um cliente");
			System.out.println("3-Pesquisar um cliente por cpf");
			System.out.println("4-Exibir todos clientes");
			System.out.println("5-Excluir um cliente");
			System.out.println("9-Retornar ao menu anterior");
			System.out.println("0-Sair");
			try {
				
				opcao2 = scnCli.nextInt();
				if (opcao2 == 1 && opcao1 == 1) {
					cadastrarCliente();
					
				} else if (opcao2 == 2 && opcao1 == 1) {
					alterarCliente();
					
				}
				else if (opcao2 == 3 && opcao1 == 1) {
					pesquisaEspecificoCliente();
				}
				else if (opcao2 == 4 && opcao1 == 1) {
					pesquisaTodosCliente();
				}
				else if (opcao2 == 5 && opcao1 == 1) {
					excluirCliente();
				}
				else if (opcao2 == 9 && opcao1 == 1) {
					menuInicial();
				}
				else if(opcao2 == 0 && opcao1 == 1) {
					System.exit(0);
				}
			} catch (Exception ex) {
				System.out.println(ex);
				System.out.println("Opção inválida");
			}
		}
		while(true);
	}
	
	
	private void cadastrarCliente(){
		Scanner scnCad = new Scanner(System.in);
		System.out.println("Digite o nome do cliente");
		String nome = scnCad.nextLine();
		
		System.out.println("Digite o cpf do cliente");
		String cpf = scnCad.next();
		
		System.out.println("Digite o telefone do cliente");
		int telefone = scnCad.nextInt();
		
		System.out.println("Digite o endereço do cliente");
		scnCad.nextLine();
		String endereco = scnCad.nextLine();
		
		Cliente cli = new Cliente(cpf, nome, telefone, endereco);
		cliente.inserirNovo(cli);
	}
	private void excluirCliente() {
		Scanner scnDel = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente");
		String cpf = scnDel.next();
		cliente.excluirCliente(cpf);
	}
	private void pesquisaEspecificoCliente() {
		Scanner scnPesq = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente");
		String cpf = scnPesq.next();
		Cliente cli = cliente.pesquisa(cpf);
		System.out.println(cli);
	}
	private void pesquisaTodosCliente() {
		
		List<Cliente> listaClientes = cliente.listarTodos(Cliente.class);
		System.out.println(listaClientes);
	}
	private void alterarCliente() {
		Scanner scnAlt = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente");
		String cpf = scnAlt.next();
		
		Cliente cli = cliente.pesquisa(cpf);
		if(cli == null) {
		}
		else {
			System.out.println("O que deseja alterar?");
			System.out.println("1-Nome");
			System.out.println("2-Telefone");
			System.out.println("3-Endereço");
			
			int opc = scnAlt.nextInt();
			if(opc == 1) {
				System.out.println("Digite o novo nome");
				scnAlt.nextLine();
				String nome = scnAlt.nextLine();
				
				cli.setNome(nome);
			
				cliente.alterar(cli);
				
			}
			else if(opc == 2) {
				System.out.println("Digite o novo telefone");
				int telefone = scnAlt.nextInt();
				cli.setFone(telefone);
				cliente.alterar(cli);
			}
			else if(opc == 3) {
				System.out.println("Digite o novo endereço");
				scnAlt.nextLine();
				String endereco = scnAlt.nextLine();
				cli.setEndereco(endereco);
				cliente.alterar(cli);
			}
		}
	}
	//Produto
	//menu produtos
	
		private void menuProdutos() {
			Scanner scnMenuP = new Scanner(System.in);
		
			do  {
				System.out.println("O que deseja fazer?");
				System.out.println("1-Cadastrar novo produto");
				System.out.println("2-Alterar dados de um produto");
				System.out.println("3-Pesquisar um cliente por codigo");
				System.out.println("4-Exibir todos produtos");
				System.out.println("5-Excluir um produto");
				System.out.println("9-Retornar ao menu anterior");
				System.out.println("0-Sair");
				try {
					opcao2 = scnMenuP.nextInt();
					if (opcao2 == 1 && opcao1 == 2) {
						cadastrarProduto();
					} else if (opcao2 == 2 && opcao1 == 2) {
						alterarProduto();
					}
					else if (opcao2 == 3 && opcao1 == 2) {
						pesquisaEspecificoProduto();
					}
					else if (opcao2 == 4 && opcao1 == 2) {
						pesquisaTodosProdutos();
					}
					else if (opcao2 == 5 && opcao1 == 2) {
						excluirProduto();
					}
					else if (opcao2 == 9 && opcao1 == 2) {
						menuInicial();
					}
					else if(opcao2 == 0 && opcao1 ==2) {
						System.exit(0);
					}
				} catch (Exception ex) {
					System.out.println("Opção inválida");
					
				}
			}
			while(true);
		}
		
	private void cadastrarProduto(){
		Scanner scnCadp = new Scanner(System.in);
		System.out.println("Digite o código do produto");
		Integer codigo = scnCadp.nextInt();
		
		System.out.println("Digite o nome do produto");
		scnCadp.nextLine();
		String nome = scnCadp.nextLine();
		
		System.out.println("Digite o preço do produto");
		double preco = scnCadp.nextDouble();
		
		Produto prod = new Produto(codigo, nome, preco);
		produto.inserirNovo(prod);
	}
	private void excluirProduto() {
		Scanner scnDelp = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente");
		Integer codigo = scnDelp.nextInt();
		produto.excluirProduto(codigo);
	}
	private void pesquisaEspecificoProduto() {
		Scanner scnPesq = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente");
		Integer codigo = scnPesq.nextInt();
		Produto prod = produto.pesquisa(codigo);
		System.out.println(prod);
	}
	private void pesquisaTodosProdutos() {
	
		List<Produto> listaProdutos = produto.listarTodos(Produto.class);
		System.out.println(listaProdutos);
	}
	private void alterarProduto() {
		Scanner scnAltP = new Scanner(System.in);
		System.out.println("Digite o codigo do produto");
		Integer codigo = scnAltP.nextInt();
		Produto prod = produto.pesquisa(codigo);
		if(prod == null) {
		}
		else {
			
			System.out.println("O que deseja alterar?");
			System.out.println("1-Codigo");
			System.out.println("2-Nome");
			System.out.println("3-Preço");
			int opc = scnAltP.nextInt();
			if(opc == 1) {
				scnAltP.reset();
				System.out.println("Digite o novo codigo");
				int cod = scnAltP.nextInt();
				prod.setCodigo(cod);
				produto.alterar(prod);
			}
			else if(opc == 2) {
				System.out.println("Digite o novo nome");
				scnAltP.nextLine();
				String nome = scnAltP.nextLine();
				prod.setNome(nome);;
				produto.alterar(prod);
			}
			else if(opc == 3) {
				System.out.println("Digite o novo preço");
				scnAltP.nextLine();
				Double preco = scnAltP.nextDouble();
				prod.setPreco(preco);
				produto.alterar(prod);
			}
		}
	}
	
	
}

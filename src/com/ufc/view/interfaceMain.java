package com.ufc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ufc.controller.ClienteController;
import com.ufc.controller.FuncionarioController;
import com.ufc.controller.MaquinaController;
import com.ufc.controller.ProdutoController;
import com.ufc.controller.ServicoController;
import com.ufc.controller.AtendimentoController;
import com.ufc.controller.AvaliacaoController;
import com.ufc.controller.QueryController;

import com.ufc.entity.Cliente;
import com.ufc.entity.Funcionario;
import com.ufc.entity.Maquina;
import com.ufc.entity.Produto;
import com.ufc.entity.Servico;
import com.ufc.entity.Atendimento;
import com.ufc.entity.Avaliacao;
import com.ufc.entity.Recibo;

public class interfaceMain {
	
	Scanner scanner = new Scanner(System.in);
	ClienteController clienteC = new ClienteController();
	FuncionarioController funcionarioC = new FuncionarioController();
	MaquinaController maquinaC = new MaquinaController();
	ProdutoController produtoC = new ProdutoController();
	ServicoController servicoC = new ServicoController();
	AtendimentoController AtendimentoC = new AtendimentoController();
	AvaliacaoController AvaliacaoC = new AvaliacaoController();
	QueryController queryC = new QueryController();
	
	public void start() throws SQLException{
		boolean loop = true;
		while(loop) {
			System.out.println("----------MENU BIBLIOTECA----------");
			System.out.println("Digite o nº da opção desejada");
			System.out.println("---------------CRUD---------------");
			System.out.println("0. Sair");
			System.out.println("1. Cadastrar");
			System.out.println("2. Excluir");
			System.out.println("3. Buscar");
			System.out.println("4. Listar");
			System.out.println("-------------CONSULTAS------------");
			System.out.println("5. Listar produtos ativos por preco");
			System.out.println("6. Listar recibos");
			System.out.println("7. Consultar salários dos funcionários");
			
			String op = scanner.nextLine();
			
			if(op.matches("^[0-9]{1,}")) {
				if(op.equals("0")) {
					System.out.println("Até breve!");
					loop = false;
				}
				else if(op.equals("1")) {
					System.out.println("----------CRUD-CADASTRAR----------");
					System.out.println("Digite o nº da opção desejada");	
					System.out.println("1. Cliente");
					System.out.println("2. Funcionário");
					System.out.println("3. Máquina");
					System.out.println("4. Produto");
					System.out.println("5. Serviço");
					System.out.println("6. Atendimento");
					System.out.println("7. Avaliação");

					op = scanner.nextLine();
					if(op.equals("1"))
						registerCliente();
					else if(op.equals("2")) {
						registerFuncionario();
					}
					else if(op.equals("3")) {
						registerMaquina();
					}
					else if(op.equals("4")) {
						registerProduto();
					}
					else if(op.equals("5")) {
						//registerServico();
					}
					else if(op.equals("6")) {
						//registerAtendimento();
					}
					else if(op.equals("7")) {
						//registerAvaliacao();
					}
				}
				else if(op.equals("2")) {
					System.out.println("------------CRUD-EXCLUIR-----------");
					System.out.println("Digite o nº da opção desejada");	
					System.out.println("1. Cliente");
					System.out.println("2. Funcionário");
					System.out.println("3. Máquina");
					System.out.println("4. Produto");
					System.out.println("5. Serviço");
					System.out.println("6. Atendimento");
					System.out.println("7. Avaliação");

					op = scanner.nextLine();
					if(op.equals("1"))
						deleteCliente();
					else if(op.equals("2")) {
						;
					}
					else if(op.equals("3")) {
						;
					}
					else if(op.equals("4")) {
						;
					}
					else if(op.equals("5")) {
						;
					}
					else if(op.equals("6")) {
						;
					}
					else if(op.equals("7")) {
						;
					}
				}
				else if(op.equals("3")) {
					System.out.println("-------------CRUD-BUSCAR------------");
					System.out.println("Digite o nº da opção desejada");	
					System.out.println("1. Cliente");
					System.out.println("2. Funcionário");
					System.out.println("3. Máquina");
					System.out.println("4. Produto");
					System.out.println("5. Serviço");
					System.out.println("6. Atendimento");
					System.out.println("7. Avaliação");

					op = scanner.nextLine();
					if(op.equals("1"))
						searchClienteByCpf();
					else if(op.equals("2")) {
						;
					}
					else if(op.equals("3")) {
						;
					}
					else if(op.equals("4")) {
						;
					}
					else if(op.equals("5")) {
						;
					}
					else if(op.equals("6")) {
						;
					}
					else if(op.equals("7")) {
						;
					}
				}
				else if(op.equals("4")) {
					System.out.println("-------------CRUD-LISTAR------------");
					System.out.println("Digite o nº da opção desejada");	
					System.out.println("1. Cliente");
					System.out.println("2. Funcionário");
					System.out.println("3. Máquina");
					System.out.println("4. Produto");
					System.out.println("5. Serviço");
					System.out.println("6. Atendimento");
					System.out.println("7. Avaliação");

					op = scanner.nextLine();
					if(op.equals("1"))
						listAllClientes();
					else if(op.equals("2")) {
						;
					}
					else if(op.equals("3")) {
						;
					}
					else if(op.equals("4")) {
						;
					}
					else if(op.equals("5")) {
						;
					}
					else if(op.equals("6")) {
						;
					}
					else if(op.equals("7")) {
						;
					}					
				}
				else if(op.equals("5"))
					listProdAtivByPreco();
				else if(op.equals("6"))
					listRecibos();
				else if(op.equals("7"))
					listSalariosFunc();
			} else {
				System.out.println("Digite um número válido! Tente novamente...");
			}
		}	
	}

	private void registerCliente() throws SQLException{
		System.out.println("######### Registrar Cliente #########");
		
		//cpf
		System.out.println("Por favor, digite o cpf...");
		String cpf = scanner.nextLine();
		if (cpf.equals("")) {
			System.out.println("CPF em branco!");
			return;
		} else if (!cpf.matches("^[0-9]{11}")) {
			System.out.println("O CPF digitado é inválido");
			return;
		}
		
		//nome
		System.out.println("Por favor, digite o nome do cliente...");
		String nome = scanner.nextLine();
		if (nome.equals("")) {
			System.out.println("Nome em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O nome do autor é invalido!");
			return;
		}
		
		//tel_res
		System.out.println("Por favor, digite o telefone residencial...");
		String tel_res = scanner.nextLine();
		if (tel_res.equals("")) {
			System.out.println("telefone em branco!");
			return;
		} else if (!tel_res.matches("^[0-9]{1,}")) {
			System.out.println("O telefone digitado é inválido");
			return;
		}
		Long tel_resL = Long.parseLong(tel_res);
		
		//tel_com
		System.out.println("Por favor, digite o telefone comercial...");
		String tel_com = scanner.nextLine();
		if (tel_res.equals("")) {
			System.out.println("telefone em branco!");
			return;
		} else if (!tel_res.matches("^[0-9]{1,}")) {
			System.out.println("O telefone digitado é inválido");
			return;
		}
		Long tel_comL = Long.parseLong(tel_com);
		
		//logradouro
		System.out.println("Por favor, digite o logradouro...");
		String logra = scanner.nextLine();
		if (logra.equals("")) {
			System.out.println("Logradouro em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O logradouro invalido!");
			return;
		}
		
		//cep
		System.out.println("Por favor, digite o cep...");
		String cep = scanner.nextLine();
		if (cep.equals("")) {
			System.out.println("CEP em branco!");
			return;
		} else if (!cpf.matches("^[0-9]{1,}") && (cep.length() > 9 || cep.length() < 9)) {
			System.out.println("O CPF digitado é inválido");
			return;
		}
		Long cepL = Long.parseLong(cep);
		
		//num_end
		System.out.println("Por favor, digite o numero do domicilio...");
		String num_end = scanner.nextLine();
		if (cep.equals("")) {
			System.out.println("numero em branco!");
			return;
		} else if (!cpf.matches("^[0-9]{1,}")) {
			System.out.println("O numero digitado é inválido");
			return;
		}
		Long num_endL = Long.parseLong(num_end);
		
		//bairro
		System.out.println("Por favor, digite o Bairro...");
		String bairro = scanner.nextLine();
		if (bairro.equals("")) {
			System.out.println("Bairro em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O Bairr invalido!");
			return;
		}
		
		boolean data = clienteC.addCliente(cpf, nome, tel_resL, tel_comL,
				logra, cepL, num_endL, bairro);
		
		if (data) {
			System.out.println("Cliente cadastrado com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
		
	}

	private void deleteCliente() {
		System.out.println("######### Deletar Cliente #########");
		System.out.println("Por favor, digite o CPF do cliente que deseja deletar...");
		
		String cpf = scanner.nextLine();
		
		while(!cpf.matches("^[0-9]{11}")) {
			System.out.println("Digite um CPF valido!");
			cpf = scanner.nextLine();
		}
		
		boolean data = clienteC.delCliente(cpf);
		if (data) {
			System.out.println("Cliente deletado!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}

	private void searchClienteByCpf() {
		System.out.println("######### Procurar Cliente por CPF #########");
		System.out.println("Por favor, digite o CPF do Cliente que deseja procurar...");
		
		String cpf = scanner.nextLine();
		
		if (cpf.equals("")) {
			System.out.println("CPF em branco!");
		} else if (!cpf.matches("^[0-9]{1,}")) {
			System.out.println("CPF invalido!");
			return;
		}
		
		Cliente cli = clienteC.searchClienteByCpf(cpf);
		
		if (cli == null) {
			System.out.println("Usuario nao encontrado!");
		} else {
			System.out.println(
				"CPF: " + cli.getCpf() + "\n" +
				"NOME: " + cli.getNome() + "\n" +
				"TEL RESIDENCIAL " + cli.getTel_residencial() + "\n" +
				"TEL COMERCIAL " + cli.getTel_comercial() + "\n" +
				"LOGRADOURO " + cli.getLogradouro() + "\n" +
				"CEP " + cli.getCep() + "\n" +
				"Nº " + cli.getNum_endereco() + "\n" + 
				"BAIRRO " + cli.getBairro()
			);
		}
	}
	
	private void listAllClientes() {
		System.out.println("######### Clientes cadastrados #########");
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		
		clienteList = clienteC.getClientesList();
		
		for(int i = 0; i < clienteList.size(); i++) {
			System.out.println(
				"CPF: " + clienteList.get(i).getCpf() + "\n" +
				" NOME: " + clienteList.get(i).getNome() + "\n" +
				" TEL RESIDENCIAL " + clienteList.get(i).getTel_residencial() + "\n" +
				" TEL COMERCIAL " + clienteList.get(i).getTel_comercial() + "\n" +
				" LOGRADOURO " + clienteList.get(i).getLogradouro() + "\n" +
				" CEP " + clienteList.get(i).getCep() + "\n" +
				" Nº " + clienteList.get(i).getNum_endereco() + "\n" +
				" BAIRRO " + clienteList.get(i).getBairro()
			);
		}
	}
	
	private void registerFuncionario() throws SQLException{
		System.out.println("######### Registrar Funcionário #########");
		
		//cpf
		System.out.println("Por favor, digite o cpf...");
		String cpf = scanner.nextLine();
		if (cpf.equals("")) {
			System.out.println("CPF em branco!");
			return;
		} else if (!cpf.matches("^[0-9]{11}")) {
			System.out.println("O CPF digitado é inválido");
			return;
		}
		
		//nome
		System.out.println("Por favor, digite o nome do Funcionario...");
		String nome = scanner.nextLine();
		if (nome.equals("")) {
			System.out.println("Nome em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O nome do autor é invalido!");
			return;
		}
		
		//tel_res
		System.out.println("Por favor, digite o telefone residencial...");
		String tel_res = scanner.nextLine();
		if (tel_res.equals("")) {
			System.out.println("telefone em branco!");
			return;
		} else if (!tel_res.matches("^[0-9]{1,}")) {
			System.out.println("O telefone digitado é inválido");
			return;
		}
		Long tel_resL = Long.parseLong(tel_res);
		
		//tel_com
		System.out.println("Por favor, digite o telefone comercial...");
		String tel_com = scanner.nextLine();
		if (tel_res.equals("")) {
			System.out.println("telefone em branco!");
			return;
		} else if (!tel_res.matches("^[0-9]{1,}")) {
			System.out.println("O telefone digitado é inválido");
			return;
		}
		Long tel_comL = Long.parseLong(tel_com);
		
		//logradouro
		System.out.println("Por favor, digite o logradouro...");
		String logra = scanner.nextLine();
		if (logra.equals("")) {
			System.out.println("Logradouro em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O logradouro invalido!");
			return;
		}
		
		//cep
		System.out.println("Por favor, digite o cep...");
		String cep = scanner.nextLine();
		if (cep.equals("")) {
			System.out.println("CEP em branco!");
			return;
		} else if (!cpf.matches("^[0-9]{1,}") && (cep.length() > 9 || cep.length() < 9)) {
			System.out.println("O CPF digitado é inválido");
			return;
		}
		Long cepL = Long.parseLong(cep);
		
		//num_end
		System.out.println("Por favor, digite o numero do domicilio...");
		String num_end = scanner.nextLine();
		if (cep.equals("")) {
			System.out.println("numero em branco!");
			return;
		} else if (!cpf.matches("^[0-9]{1,}")) {
			System.out.println("O numero digitado é inválido");
			return;
		}
		Long num_endL = Long.parseLong(num_end);
		
		//bairro
		System.out.println("Por favor, digite o Bairro...");
		String bairro = scanner.nextLine();
		if (bairro.equals("")) {
			System.out.println("Bairro em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O Bairr invalido!");
			return;
		}
		//salario
		System.out.println("Por favor, digite o Salário...");
		String salario = scanner.nextLine();
		
		if (bairro.equals("")) {
			System.out.println("Salário em branco!");
			return;
		} else if (!salario.matches("^[0-9]{1,}")){
			System.out.println("O salario invalido!");
			return;
		}
		
		Float salF = Float.parseFloat(salario);
		
		boolean data = funcionarioC.addFuncionario(cpf, nome, tel_resL, tel_comL,
				logra, cepL, num_endL, bairro, salF);
		
		if (data) {
			System.out.println("Funcionario cadastrado com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void registerMaquina() {
		//id
		System.out.println("Por favor, digite o Id");
		String id = scanner.nextLine();
		if (id.equals("")) {
			System.out.println("Id em branco!");
			return;
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("O Id digitado é inválido");
			return;
		}
		Integer idI = Integer.parseInt(id);
		
		//nome
		System.out.println("Por favor, digite o nome do modelo da máquina...");
		String nome = scanner.nextLine();
		if (nome.equals("")) {
			System.out.println("Nome em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O nome do autor é invalido!");
			return;
		}
		
		//status
		System.out.println("Por favor, digite o Status da máquina...");
		String status = scanner.nextLine();
		if (status.equals("!(true|false)")) {
			System.out.println("As opções são 'true' ou 'false'");
			return;
		}
		Boolean statusB = Boolean.parseBoolean(status);
		
		boolean data = maquinaC.addMaquina(idI, nome, statusB);
		
		if (data) {
			System.out.println("Maquina cadastrada com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void registerProduto() {
		//id
		System.out.println("Por favor, digite o Id");
		String id = scanner.nextLine();
		if (id.equals("")) {
			System.out.println("Id em branco!");
			return;
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("O Id digitado é inválido");
			return;
		}
		Integer idI = Integer.parseInt(id);
		
		//nome
		System.out.println("Por favor, digite o nome do Produto...");
		String nome = scanner.nextLine();
		if (nome.equals("")) {
			System.out.println("Nome em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O nome digitado é invalido!");
			return;
		}
		
		//id
		System.out.println("Por favor, digite a Quantidade");
		String qtd = scanner.nextLine();
		if (qtd.equals("")) {
			System.out.println("Quantidade em branco!");
			return;
		} else if (!qtd.matches("^[0-9]{1,}")) {
			System.out.println("O valor digitado é inválido, use numeros naturais");
			return;
		}
		Integer qtdI = Integer.parseInt(qtd);
		
		boolean data = produtoC.addProduto(idI, nome, qtdI);
		
		if (data) {
			System.out.println("Produto cadastrado com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}	
	private void listProdAtivByPreco() {
		System.out.println("######### Servicos Ativos Por Preço #########");
		ArrayList<Servico> servicoList = new ArrayList<Servico>();
		
		servicoList = servicoC.getServicosList();
		
		for(int i = 0; i < servicoList.size(); i++) {
			System.out.println(
				"ID: " + servicoList.get(i).getId() + "\n" + 
				" NOME: " + servicoList.get(i).getNome() + "\n" +
				" PREÇO: " + servicoList.get(i).getPreco() + "\n" +
				" STATUS: " + servicoList.get(i).isStatus()
			);
		}
	}

	private void listRecibos() {
		System.out.println("######### Lista de Recibos #########");
		ArrayList<Recibo> reciboList = new ArrayList<Recibo>();
		
		reciboList = queryC.getRecibos();
		
		System.out.println(reciboList.size());
		
		for(int i = 0; i < reciboList.size(); i++) {
			System.out.println(
				"ID: " + reciboList.get(i).getAtendId() + "\n" + 
				" FUNCIONARIO: " + reciboList.get(i).getFuncNome() + "\n" +
				" CLIENTE: " + reciboList.get(i).getCliNome() + "\n" +
				" VALOR TOTAL: " + reciboList.get(i).getValTotal()
			);
		}
	}
	
	private void listSalariosFunc() {
		System.out.println("######### Salario dos Funcionários #########");
		ArrayList<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		
		funcionarioList = funcionarioC.getFuncionarioList();
		
		for(int i = 0; i < funcionarioList.size(); i++) {
			System.out.println(
				"CPF: " + funcionarioList.get(i).getCpf() + "\n" +
				" NOME: " + funcionarioList.get(i).getNome() + "\n" +
				" SALARIO: " + funcionarioList.get(i).getSalario()
			);
		}
	}
}
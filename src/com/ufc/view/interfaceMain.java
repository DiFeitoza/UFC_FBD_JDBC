package com.ufc.view;

import java.sql.SQLException;
import java.sql.Timestamp;
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
	AtendimentoController atendimentoC = new AtendimentoController();
	AvaliacaoController avaliacaoC = new AvaliacaoController();
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
						registerServico();
					}
					else if(op.equals("6")) {
						registerAtendimento();
					}
					else if(op.equals("7")) {
						registerAvaliacao();
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
						deleteFuncionario();
					}
					else if(op.equals("3")) {
						deleteMaquina();
					}
					else if(op.equals("4")) {
						deleteProduto();
					}
					else if(op.equals("5")) {
						deleteServico();
					}
					else if(op.equals("6")) {
						deleteAtendimento();
					}
					else if(op.equals("7")) {
						deleteAvaliacao();
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
						searchFuncionarioByCpf();
					}
					else if(op.equals("3")) {
						searchMaquinaById();
					}
					else if(op.equals("4")) {
						searchProdutoById();
					}
					else if(op.equals("5")) {
						searchServicoById();
					}
					else if(op.equals("6")) {
						searchAtendimentoById();
					}
					else if(op.equals("7")) {
						searchAvaliacaoById();
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
						listAllCliente();
					else if(op.equals("2")) {
						listAllFuncionario();
					}
					else if(op.equals("3")) {
						listAllMaquina();
					}
					else if(op.equals("4")) {
						listAllProduto();
					}
					else if(op.equals("5")) {
						listAllServico();
					}
					else if(op.equals("6")) {
						listAllAtendimento();
					}
					else if(op.equals("7")) {
						listAllAvaliacao();
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
	
	private void registerServico() {
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
		System.out.println("Por favor, digite o nome do Serviço...");
		String nome = scanner.nextLine();
		if (nome.equals("")) {
			System.out.println("Nome em branco!");
			return;
		} else if (!nome.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O nome do autor é invalido!");
			return;
		}
		
		//status
		System.out.println("Por favor, digite o status da serviço...");
		String status = scanner.nextLine();
		if (status.equals("!(true|false)")) {
			System.out.println("As opções são 'true' ou 'false'");
			return;
		}
		Boolean statusB = Boolean.parseBoolean(status);
		
		//preco
		System.out.println("Por favor, digite o preço do serviço...");
		String preco = scanner.nextLine();
		
		if (preco.equals("")) {
			System.out.println("Preço em branco!");
			return;
		} else if (!preco.matches("^[0-9]{1,}")){
			System.out.println("O digite um valor valido!");
			return;
		}
		
		Float precoF = Float.parseFloat(preco);
		
		boolean data = servicoC.addServico(idI, nome, statusB, precoF);
		
		if (data) {
			System.out.println("Serviço cadastrado com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}

	private void registerAtendimento() {
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
		
		//cpfCli
		System.out.println("Por favor, digite o cpf...");
		String cpfCli = scanner.nextLine();
		if (cpfCli.equals("")) {
			System.out.println("CPF em branco!");
			return;
		} else if (!cpfCli.matches("^[0-9]{11}")) {
			System.out.println("O CPF digitado é inválido");
			return;
		}
		
		//cpfFunc
		System.out.println("Por favor, digite o cpf...");
		String cpfFunc = scanner.nextLine();
		if (cpfFunc.equals("")) {
			System.out.println("CPF em branco!");
			return;
		} else if (!cpfFunc.matches("^[0-9]{11}")) {
			System.out.println("O CPF digitado é inválido");
			return;
		}
		
		//timeBegin
		Timestamp timeBegin = new Timestamp(System.currentTimeMillis());
		
		//timeEnd
		Timestamp timeEnd = new Timestamp(System.currentTimeMillis()+2);
				
		//preco
		System.out.println("Por favor, digite o preço do Atendimento...");
		String preco = scanner.nextLine();
		
		if (preco.equals("")) {
			System.out.println("Preço em branco!");
			return;
		} else if (!preco.matches("^[0-9]{1,}")){
			System.out.println("O digite um valor valido!");
			return;
		}
		
		Float precoF = Float.parseFloat(preco);
		
		//idMaq
		System.out.println("Por favor, digite o id da Atendimento");
		String idMaq = scanner.nextLine();
		if (idMaq.equals("")) {
			System.out.println("idMaq em branco!");
			return;
		} else if (!idMaq.matches("^[0-9]{1,}")) {
			System.out.println("O idMaq digitado é inválido");
			return;
		}
		Integer idMaqI = Integer.parseInt(idMaq);
		
		//idServ
		System.out.println("Por favor, digite o id do Atendimento");
		String idServ = scanner.nextLine();
		if (idServ.equals("")) {
			System.out.println("idServ em branco!");
			return;
		} else if (!idServ.matches("^[0-9]{1,}")) {
			System.out.println("O idServ digitado é inválido");
			return;
		}
		Integer idServI = Integer.parseInt(idServ);
		
		boolean data = atendimentoC.addAtendimento(idI, cpfCli, cpfFunc, timeBegin, timeEnd, precoF, idMaqI, idServI);
		
		if (data) {
			System.out.println("Atendimento cadastrado com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void registerAvaliacao() {
		//id
		System.out.println("Por favor, digite o id da Avaliação");
		String id = scanner.nextLine();
		if (id.equals("")) {
			System.out.println("Id em branco!");
			return;
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("O Id digitado é inválido");
			return;
		}
		Integer idI = Integer.parseInt(id);

		//idAtend
		System.out.println("Por favor, digite o id do Atendimento");
		String idAtend = scanner.nextLine();
		if (idAtend.equals("")) {
			System.out.println("id do Atendimento em branco!");
			return;
		} else if (!idAtend.matches("^[0-9]{1,}")) {
			System.out.println("O idAtend digitado é inválido");
			return;
		}
		Integer idAtendI = Integer.parseInt(id);		
		
		//coment
		System.out.println("Por favor, digite um Comentário de até 60 caracteres...");
		String coment = scanner.nextLine();
		if (coment.equals("")) {
			System.out.println("comentario em branco!");
			return;
		} else if (!coment.matches("[a-zA-Z Ã�Ã‚ÃƒÃ€Ã‡Ã‰ÃŠÃ�Ã“Ã”Ã•ÃšÃœÃ¡Ã¢Ã£Ã Ã§Ã©ÃªÃ­Ã³Ã´ÃµÃºÃ¼]*")){
			System.out.println("O comentario digitado é invalido!");
			return;
		}
		
		//notaFunc
		System.out.println("Por favor, digite uma Nota de 0 a 10 para o Funcionário");
		String notaFunc = scanner.nextLine();
		if (notaFunc.equals("")) {
			System.out.println("nota em branco!");
			return;
		}

		Integer notaFuncI = Integer.parseInt(notaFunc);

		if (notaFuncI < 0 || notaFuncI > 10) {
			System.out.println("A nota digitada digitado é inválida, deve ser de 0 a 10");
			return;
		}
		
		//notaServ
		System.out.println("Por favor, digite uma Nota de 0 a 10 para o Serviço");
		String notaServ = scanner.nextLine();
		if (notaServ.equals("")) {
			System.out.println("nota em branco!");
			return;
		}

		Integer notaServI = Integer.parseInt(notaServ);

		if (notaServI < 0 || notaServI > 10) {
			System.out.println("A nota digitada digitado é inválida, deve ser de 0 a 10");
			return;
		}

		//notaMaq
		System.out.println("Por favor, digite uma Nota de 0 a 10 para a Máquina");
		String notaMaq = scanner.nextLine();
		if (notaMaq.equals("")) {
			System.out.println("nota em branco!");
			return;
		}

		Integer notaMaqI = Integer.parseInt(notaMaq);

		if (notaMaqI < 0 || notaMaqI > 10) {
			System.out.println("A nota digitada digitado é inválida, deve ser de 0 a 10");
			return;
		}
		
		boolean data = avaliacaoC.addAvaliacao(idI, idAtendI, coment, notaFuncI, notaServI, notaMaqI);
		
		if (data) {
			System.out.println("Avaliacao cadastrada com sucesso!");
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
	
	private void deleteFuncionario() {
		System.out.println("######### Deletar Funcionári #########");
		System.out.println("Por favor, digite o CPF do Funcionário que deseja deletar...");
		
		String cpf = scanner.nextLine();
		
		while(!cpf.matches("^[0-9]{11}")) {
			System.out.println("Digite um CPF valido!");
			cpf = scanner.nextLine();
		}
		
		boolean data = funcionarioC.delFuncionario(cpf);
		if (data) {
			System.out.println("Funcionário deletado!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void deleteMaquina() {
		System.out.println("######### Deletar Máquina #########");
		System.out.println("Por favor, digite o ID da Máquina que deseja deletar...");
		
		String id = scanner.nextLine();
		
		while(!id.matches("^[0-9]{1,}")) {
			System.out.println("Digite um id válido!");
			id = scanner.nextLine();
		}
		
		Integer idI = Integer.parseInt(id);
		boolean data = maquinaC.delMaquina(idI);
		
		if (data) {
			System.out.println("Máquina deletada!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void deleteProduto() {
		System.out.println("######### Deletar Produto #########");
		System.out.println("Por favor, digite o ID do Produto que deseja deletar...");
		
		String id = scanner.nextLine();
		
		while(!id.matches("^[0-9]{1,}")) {
			System.out.println("Digite um id válido!");
			id = scanner.nextLine();
		}
		
		Integer idI = Integer.parseInt(id);
		boolean data = produtoC.delProduto(idI);
		
		if (data) {
			System.out.println("Produto deletado!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void deleteServico() {
		System.out.println("######### Deletar Servico #########");
		System.out.println("Por favor, digite o ID do Servico que deseja deletar...");
		
		String id = scanner.nextLine();
		
		while(!id.matches("^[0-9]{1,}")) {
			System.out.println("Digite um id válido!");
			id = scanner.nextLine();
		}
		
		Integer idI = Integer.parseInt(id);
		boolean data = servicoC.delServico(idI);
		
		if (data) {
			System.out.println("Servico deletado!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void deleteAtendimento() {
		System.out.println("######### Deletar Atendimento #########");
		System.out.println("Por favor, digite o ID do Atendimento que deseja deletar...");
		
		String id = scanner.nextLine();
		
		while(!id.matches("^[0-9]{1,}")) {
			System.out.println("Digite um id válido!");
			id = scanner.nextLine();
		}
		
		Integer idI = Integer.parseInt(id);
		boolean data = atendimentoC.delAtendimento(idI);
		
		if (data) {
			System.out.println("Atendimento deletado!");
		} else {
			System.out.println("Ocorreu algum erro, tente novamente!");
		}
	}
	
	private void deleteAvaliacao() {
		System.out.println("######### Deletar Avaliação #########");
		System.out.println("Por favor, digite o ID da Avaliação que deseja deletar...");
		
		String id = scanner.nextLine();
		
		while(!id.matches("^[0-9]{1,}")) {
			System.out.println("Digite um id válido!");
			id = scanner.nextLine();
		}
		
		Integer idI = Integer.parseInt(id);
		boolean data = avaliacaoC.delAvaliacao(idI);
		
		if (data) {
			System.out.println("Avaliação deletada!");
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
		} else if (!cpf.matches("^[0-9]{11}")) {
			System.out.println("CPF invalido! Digite 11 dígitos");
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
	
	private void searchFuncionarioByCpf() {
		System.out.println("######### Procurar Funcionario por CPF #########");
		System.out.println("Por favor, digite o CPF do Funcionario que deseja procurar...");
		
		String cpf = scanner.nextLine();
		
		if (cpf.equals("")) {
			System.out.println("CPF em branco!");
		} else if (!cpf.matches("^[0-9]{11}")) {
			System.out.println("CPF invalido! Digite 11 dígitos");
			return;
		}
		
		Funcionario func = funcionarioC.searchFuncionarioByCpf(cpf);
		
		if (func == null) {
			System.out.println("Usuario nao encontrado!");
		} else {
			System.out.println(
				"CPF: " + func.getCpf() + "\n" +
				"NOME: " + func.getNome() + "\n" +
				"TEL RESIDENCIAL " + func.getTel_residencial() + "\n" +
				"TEL COMERCIAL " + func.getTel_comercial() + "\n" +
				"LOGRADOURO " + func.getLogradouro() + "\n" +
				"CEP " + func.getCep() + "\n" +
				"Nº " + func.getNum_endereco() + "\n" + 
				"BAIRRO " + func.getBairro() + "\n" +
				"SALARIO " + func.getSalario()
			);
		}
	}
	
	private void searchMaquinaById() {
		System.out.println("######### Procurar Máquina por Id #########");
		System.out.println("Por favor, digite o Id da Máquina que deseja procurar...");
		
		String id = scanner.nextLine();
		
		if (id.equals("")) {
			System.out.println("id em branco!");
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("id inválido!");
			return;
		}
		
		Integer idI = Integer.parseInt(id);
		
		Maquina maq = maquinaC.searchMaquinaById(idI);
		
		if (maq == null) {
			System.out.println("Máquina não encontrada!");
		} else {
			System.out.println(
				"ID: " + maq.getId() + "\n" +
				"NOME: " + maq.getNome() + "\n" +
				"STATUS " + maq.isStatus()
			);
		}
	}

	private void searchProdutoById() {
		System.out.println("######### Procurar Produto por Id #########");
		System.out.println("Por favor, digite o Id do Produto que deseja procurar...");
		
		String id = scanner.nextLine();
		
		if (id.equals("")) {
			System.out.println("id em branco!");
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("id inválido!");
			return;
		}
		
		Integer idI = Integer.parseInt(id);
		
		Produto prod = produtoC.searchProdutoById(idI);
		
		if (prod == null) {
			System.out.println("Produto não encontrado!");
		} else {
			System.out.println(
				"ID: " + prod.getId() + "\n" +
				"NOME: " + prod.getNome() + "\n" +
				"QTD: " + prod.getQtd()
			);
		}
	}

	private void searchServicoById() {
		System.out.println("######### Procurar Serviço por Id #########");
		System.out.println("Por favor, digite o Id do Serviço que deseja procurar...");
		
		String id = scanner.nextLine();
		
		if (id.equals("")) {
			System.out.println("id em branco!");
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("id inválido!");
			return;
		}
		
		Integer idI = Integer.parseInt(id);
		
		Servico serv = servicoC.searchServicoById(idI);
		
		if (serv == null) {
			System.out.println("Serviço não encontrado!");
		} else {
			System.out.println(
				"ID: " + serv.getId() + "\n" +
				"NOME: " + serv.getNome() + "\n" +
				"STATUS: " + serv.isStatus() + "\n" +
				"PREÇO: " + serv.getPreco()
			);
		}
	}

	private void searchAtendimentoById() {
		System.out.println("######### Procurar Atendimento por Id #########");
		System.out.println("Por favor, digite o Id do Atendimento que deseja procurar...");
		
		String id = scanner.nextLine();
		
		if (id.equals("")) {
			System.out.println("id em branco!");
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("id inválido!");
			return;
		}
		
		Integer idI = Integer.parseInt(id);
		
		Atendimento atend = atendimentoC.searchAtendimentoById(idI);
		
		if (atend == null) {
			System.out.println("Atendimento não encontrado!");
		} else {
			System.out.println(
				"ID: " + atend.getId() + "\n" +
				"CPF_CLIENTE: " + atend.getCpfCli() + "\n" +
				"CPF_FUNCINÁRIO: " + atend.getCpfFunc() + "\n" +
				"TIME_INI: " + atend.getTimeBeg() + "\n" +
				"TIME_FIM: " + atend.getTimeEnd() + "\n" +
				"ID_SERVIÇO: " + atend.getIdServ() + "\n" +
				"ID_MÁQUINA: " + atend.getIdMaq()
			);
		}
	}	

	private void searchAvaliacaoById() {
		System.out.println("######### Procurar Avaliação por Id #########");
		System.out.println("Por favor, digite o Id da Avaliação que deseja procurar...");
		
		String id = scanner.nextLine();
		
		if (id.equals("")) {
			System.out.println("id em branco!");
		} else if (!id.matches("^[0-9]{1,}")) {
			System.out.println("id inválido!");
			return;
		}
		
		Integer idI = Integer.parseInt(id);
		
		Avaliacao ava = avaliacaoC.searchAvaliacaoById(idI);
		
		if (ava == null) {
			System.out.println("Avaliação não encontrada!");
		} else {
			System.out.println(
				"ID: " + ava.getId() + "\n" +
				"ID_ATENDIMENTO: " + ava.getIdAtend() + "\n" +
				"COMENTÁRIO: " + ava.getComent() + "\n" +
				"NOTA_FUNCIONÁRIO: " + ava.getNotaFunc() + "\n" +
				"NOTA_SERVIÇO: " + ava.getNotaServ() + "\n" +
				"NOTA_MÁQUINA: " + ava.getNotaMaq()
			);
		}
	}	
	
	private void listAllCliente() {
		System.out.println("######### Clientes cadastrados #########");
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		
		clienteList = clienteC.getClienteList();
		
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
	
	private void listAllFuncionario() {
		System.out.println("######### Funcionários Cadastrados #########");
		ArrayList<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		
		funcionarioList = funcionarioC.getFuncionarioList();
		
		for(int i = 0; i < funcionarioList.size(); i++) {
			System.out.println(
				"CPF: " + funcionarioList.get(i).getCpf() + "\n" +
				" NOME: " + funcionarioList.get(i).getNome() + "\n" +
				" TEL RESIDENCIAL: " + funcionarioList.get(i).getTel_residencial() + "\n" +
				" TEL COMERCIAL: " + funcionarioList.get(i).getTel_comercial() + "\n" +
				" LOGRADOURO: " + funcionarioList.get(i).getLogradouro() + "\n" +
				" CEP: " + funcionarioList.get(i).getCep() + "\n" +
				" Nº: " + funcionarioList.get(i).getNum_endereco() + "\n" +
				" BAIRRO: " + funcionarioList.get(i).getBairro() + "\n" +
				" SALÁRIO: " + funcionarioList.get(i).getSalario()
			);
		}
	}
	
	private void listAllMaquina() {
		System.out.println("######### Máquinas Cadastradas #########");
		ArrayList<Maquina> maquinaList = new ArrayList<Maquina>();
		
		maquinaList = maquinaC.getMaquinaList();
		
		for(int i = 0; i < maquinaList.size(); i++) {
			System.out.println(
				"ID: " + maquinaList.get(i).getId() + "\n" +
				" NOME: " + maquinaList.get(i).getNome() + "\n" +
				" STATUS: " + maquinaList.get(i).isStatus()
			);
		}
	}
	
	private void listAllProduto() {
		System.out.println("######### Produtos Cadastrados #########");
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		produtoList = produtoC.getProdutoList();
		
		for(int i = 0; i < produtoList.size(); i++) {
			System.out.println(
				"ID: " + produtoList.get(i).getId() + "\n" +
				" NOME: " + produtoList.get(i).getNome() + "\n" +
				" QTD: " + produtoList.get(i).getQtd()
			);
		}
	}
	
	private void listAllServico() {
		System.out.println("######### Servicos Cadastrados #########");
		ArrayList<Servico> servicoList = new ArrayList<Servico>();
		
		servicoList = servicoC.getServicoList();
		
		for(int i = 0; i < servicoList.size(); i++) {
			System.out.println(
				"ID: " + servicoList.get(i).getId() + "\n" +
				" NOME: " + servicoList.get(i).getNome() + "\n" +
				" STATUS: " + servicoList.get(i).isStatus() + "\n" +
				" PREÇO: " + servicoList.get(i).getPreco()
			);
		}
	}
	
	private void listAllAtendimento() {
		System.out.println("######### Atendimentos Cadastrados #########");
		ArrayList<Atendimento> atendimentoList = new ArrayList<Atendimento>();
		
		atendimentoList = atendimentoC.getAtendimentoList();
		
		for(int i = 0; i < atendimentoList.size(); i++) {
			System.out.println(
				"ID: " + atendimentoList.get(i).getId() + "\n" +
				" CPF_CLIENTE: " + atendimentoList.get(i).getCpfCli() + "\n" +
				" CPF_FUNCINÁRIO: " + atendimentoList.get(i).getCpfFunc() + "\n" +
				" TIME_INI: " + atendimentoList.get(i).getTimeBeg() + "\n" +
				" TIME_FIM: " + atendimentoList.get(i).getTimeEnd() + "\n" +
				" ID_SERVIÇO: " + atendimentoList.get(i).getIdServ() + "\n" +
				" ID_MÁQUINA: " + atendimentoList.get(i).getIdMaq()
			);
		}
	}
	
	private void listAllAvaliacao() {
		System.out.println("######### Avaliacões Cadastradas #########");
		ArrayList<Avaliacao> avaliacaoList = new ArrayList<Avaliacao>();
		
		avaliacaoList = avaliacaoC.getAvaliacaoList();
		
		for(int i = 0; i < avaliacaoList.size(); i++) {
			System.out.println(
				"ID: " + avaliacaoList.get(i).getId() + "\n" +
				" ID_ATENDIMENTO: " + avaliacaoList.get(i).getIdAtend() + "\n" +
				" COMENTÁRIO: " + avaliacaoList.get(i).getComent() + "\n" +
				" NOTA_FUNCIONÁRIO: " + avaliacaoList.get(i).getNotaFunc() + "\n" +
				" NOTA_SERVIÇO: " + avaliacaoList.get(i).getNotaServ() + "\n" +
				" NOTA_MÁQUINA: " + avaliacaoList.get(i).getNotaMaq()
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
	
	private void listProdAtivByPreco() {
		System.out.println("######### Servicos Ativos Por Preço #########");
		ArrayList<Servico> ServicoList = new ArrayList<Servico>();
		
		ServicoList = servicoC.getServicoList();
		
		for(int i = 0; i < ServicoList.size(); i++) {
			System.out.println(
				"ID: " + ServicoList.get(i).getId() + "\n" + 
				" NOME: " + ServicoList.get(i).getNome() + "\n" +
				" PREÇO: " + ServicoList.get(i).getPreco() + "\n" +
				" STATUS: " + ServicoList.get(i).isStatus()
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
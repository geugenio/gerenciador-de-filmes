import java.util.List;
import java.util.Scanner;

import DAO.ContatoDAO;
import entity.Contato;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			boolean programa = true;
			while(programa) {
				inicializador();
				int opc = -1;
				
				try {
					System.out.println("Insira, com base no número(1 a 5), a operação desejada: ");
					opc = Integer.parseInt(sc.nextLine());
				} catch(Exception e) {
					System.out.println("Erro! Tente novamente");
					continue; //continua o loop
				}

				switch (opc) {
				case 1: {//CRIAÇÃO DE CONTATO
					System.out.println("Insira o nome completo: ");
					String completeName = sc.nextLine();

					System.out.println("Insira o telefone: ");
					String phone = sc.nextLine();
					
					System.out.println("Insira o E-mail: ");
					String email = sc.nextLine();
					
					try {
						Contato ctt = new Contato(completeName, phone, email);
						new ContatoDAO().cadastrarContato(ctt);
						System.out.println("Contato criado!");
					}catch(Exception e) {
						System.err.println("Erro ao criar contato: " + e.getMessage());
					}
					
					
					
					break;
				}
				case 2:{//SELEÇÃO DE CONTATO VIA ID
					System.out.print("Insira o ID do contato a abrir: ");
					int cttId = sc.nextInt();
					sc.nextLine();
					Contato ctt = new ContatoDAO().selecaoContato(cttId);
					if (ctt!=null) {
						System.out.println(ctt);
					} else {
						System.out.println("Erro! Contato de ID " + cttId + ", não encontrado, tente novamente.");
					}
					
					break;
				}
				
				case 3:{//ABRIR LISTA DE CONTATOS
					
					List<Contato> cttLista = new ContatoDAO().listaContatos();
					if(!cttLista.isEmpty()) {
						System.out.println("---------------------");
						System.out.println("LISTA DE CONTATOS");
						System.out.println("---------------------");
						for (Contato contato : cttLista) {
							
							System.out.println(contato);
							System.out.println("------------------");
						}
					} else {
						System.out.println("Você não possui contatos! os Adicione para listá-los aqui.");
					}

					
					break;
				}
				case 4:{//Atualização de contato
					System.out.print("Insira o ID do contato: ");
					int cttId = sc.nextInt();
					sc.nextLine();
					Contato ctt = new ContatoDAO().selecaoContato(cttId);
					if(ctt!=null) {
						ctt.setId(cttId);
						System.out.print("Insira o novo nome completo: ");
						ctt.setNomeCompleto(sc.nextLine());
						
						System.out.print("Insira o novo telefone: ");
						ctt.setTelefone(sc.nextLine());
						
						System.out.print("Insira o novo E-mail: ");
						ctt.setEmail(sc.nextLine());
						
						try {
							System.out.println("Mudando contato...");
							
							int atualizacao = new ContatoDAO().atualizarContato(cttId, ctt);
							if (atualizacao > 0) {
							    System.out.println("Contato atualizado com sucesso!");
							} else {
							    System.out.println("Nenhum contato foi atualizado. Verifique o ID fornecido.");
							}
						} catch(Exception e ) {
							e.printStackTrace();
						}
						
					} else {
						System.out.println("Erro! Contato de ID " + cttId + ", não encontrado, tente novamente.");
					}
					break;
				}
				case 5:{ //REMOÇÃO DE CONTATO
					System.out.print("Insira o ID do contato: ");
					int cttId = sc.nextInt();
					sc.nextLine();
					
					
					try {
						System.out.println("removendo contato...");
						
						int atualizacao = new ContatoDAO().removerContato(cttId);
						if (atualizacao > 0) {
						    System.out.println("Contato removido com sucesso!");
						} else {
						    System.out.println("Não foi possível remover o contato. Verifique o ID fornecido.");
						}
					} catch(Exception e ) {
						e.printStackTrace();
					}
					
					break;
				}
				case 6:{
					programa = false;
					break;
				}
				default:
					System.err.println("Opção inválida! Tente novamente;");
					break;
				}
				
			}

		}finally {
			sc.close();
			System.out.println("FIM DO PROGRAMA");
		}
	}
	
	
	public static void inicializador() {
		System.out.println("+-----------------------------+");
		System.out.println("|   GERENCIADOR DE CONTATOS   |");
		System.out.println("+---+-------------------------+");
		System.out.println("| 1 | Adicionar novo contato  |");
		System.out.println("+---+-------------------------+");
		System.out.println("| 2 | Abrir contato (ID)      |");
		System.out.println("+---+-------------------------+");
		System.out.println("| 3 | Abrir lista de contatos |");
		System.out.println("+---+-------------------------+");
		System.out.println("| 4 | Atualizar contato (ID)  |");
		System.out.println("+---+-------------------------+");
		System.out.println("| 5 | Excluir Contato (ID)    |");
		System.out.println("+---+-------------------------+");
		System.out.println("| 6 | Finalizar sistema       |");
		System.out.println("+---+-------------------------+");
	}
}




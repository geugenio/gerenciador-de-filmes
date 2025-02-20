import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Contato> contacts = new ArrayList<Contato>();
	private static int idGenerator = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		inicializador();
		
		while(true) {
			inicializador();
			int opc = 0;
			try {
				System.out.println("Insira, com base no número(1 a 5), a operação desejada: ");
				opc = Integer.parseInt(sc.nextLine());
			} catch(Exception e) {
				System.out.println("Erro! Tente novamente");
			}

			switch (opc) {
			case 1: {
				System.out.println("Insira o nome completo: ");
				String completeName = sc.nextLine();

				System.out.println("Insira o telefone: ");
				String phone = sc.nextLine();
				
				System.out.println("Insira o E-mail: ");
				String email = sc.nextLine();
				
				try {
					Contato ctt = new Contato(completeName, phone, email, idGenerator);
					contacts.add(ctt);
					idGenerator++;
				}catch(Exception e) {
					System.err.println("ERRO");
					break;
				}
				System.out.println("Contato criado!");
				break;
			}
			case 2:{
				System.out.print("Insira o ID do contato a abrir: ");
				int cttId = sc.nextInt();
				sc.nextLine();
				Contato cttReturned = searchContatoById(cttId);
				
				if(cttReturned !=null) {
					System.out.println(searchContatoById(cttId));
				} else {
					System.out.println("Erro ao identificar o contato de ID " + cttId + ", tente novamente.");
				}
				break;
			}
			
			case 3:{
				for (Contato ctt :contacts) {
					System.out.println(ctt);
				}
				break;
			}
			case 4:{
				System.out.print("Insira o ID do contato: ");
				int cttId = sc.nextInt();
				sc.nextLine();
				
				Contato cttReturned = searchContatoById(cttId);
				if(cttReturned !=null) {
					System.out.println("Contato de " + cttReturned.getNome() + " achado. Agora:");
					System.out.print("Insira o novo nome completo: ");
					String completeName = sc.nextLine();
					
					System.out.print("Insira o novo telefone: ");
					String phone = sc.nextLine();
					
					System.out.print("Insira o novo E-mail: ");
					String email = sc.nextLine();
			        for (Contato contatoUn : contacts) {
			            if (contatoUn.getId() == cttId) {
			                contatoUn.setEmail(email);
			                contatoUn.setNomeCompleto(completeName);
			                contatoUn.setTelefone(phone);
			            }
			        }
					
				} else {
					System.out.println("Erro! Contato de ID " + cttId + ", não encontrado, tente novamente.");
				}
				System.out.println("Mudando contato...");
				break;
			}
			case 5:{
				System.out.print("Insira o ID do contato: ");
				int cttId = sc.nextInt();
				sc.nextLine();
				
				Contato cttReturned = searchContatoById(cttId);
				if(cttReturned!= null) {
					contacts.remove(cttReturned);
					System.out.println("Contato removido com sucesso!");
				} else {
					System.out.println("Erro! Contato de ID " + cttId + ", não encontrado, tente novamente.");
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opc);
			}
			sc.close();
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
	}
	
    public static Contato searchContatoById(int id) {
        for (Contato contatoUn : contacts) {
            if (contatoUn.getId() == id) {
                return contatoUn;
            }
        }
        return null;
    }
}




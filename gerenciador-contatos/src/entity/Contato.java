package entity;
public class Contato {
	private int id;
	private String nomeCompleto;
	private String nome;
	private String telefone;
	private String email;
	
	
	public Contato(String nomeCompleto, String telefone, String email) {
		this.setNomeCompleto(nomeCompleto);
		this.telefone = telefone;
		this.email = email;
	}
	
	
	public Contato() {
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		this.nome = nomeCompleto.split(" ")[0];
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Contato " + this. getNome() + ":\n" + "Nome completo:" + this.getNomeCompleto() + "\nTelefone: " + this.getTelefone() + "\nE-mail: " + this.getEmail();
	}




}

package model;

import java.io.Serializable;


public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	int id;
	String nome,email,senha,cidade, cidade2;
	
	public Cliente()
	{}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCidade2() {
		return cidade2;
	}

	public void setCidade2(String cidade2) {
		this.cidade2 = cidade2;
	}

	public String getCidade() {
		return cidade;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + "]";
	}
	
}

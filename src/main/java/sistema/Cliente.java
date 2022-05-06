package sistema;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	String cpf;
	String nome;
	int fone;
	String endereco;
	
	Cliente(){}

	public Cliente(String cpf, String nome, int fone, String endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", fone=" + fone + ", endereco=" + endereco + "]";
	};
		
	
	
	
	
	
}

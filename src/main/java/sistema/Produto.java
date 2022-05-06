package sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	
	 Integer codigo;
	 String nome;
	 Double preco;
	 Produto(){}
	public Produto( Integer codigo, String nome, Double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	};
	 
	
}

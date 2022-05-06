package aplicacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sistema.Cliente;
import sistema.Produto;

public class ClienteDao {
	Cliente cli  = null;
	JPAUtil jpa = new JPAUtil();
	
	
	
	
	public void inserirNovo(Cliente c) {
		EntityManager em = jpa.getEntityManager();
		Cliente alt = em.find(Cliente.class, c.getCpf());
		 if(alt != null){
		      
		      System.out.println("Cliente já registrado");
		    }
		    else{
		      em.getTransaction().begin(); 
		      em.persist(c);
		      em.getTransaction().commit();
		      System.out.println("Cliente registrado com sucesso.");  
		    }
		
		
	}
	
	public void alterar(Cliente c) {
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
        System.out.println("Dados atualizados");
		
		
	}
	
	public void excluirCliente(String cpf) {
		EntityManager em = jpa.getEntityManager();;
		Cliente c = em.find(Cliente.class, cpf);
		if(c!= null){
			  em.getTransaction().begin(); 
		      em.remove(c);
		      em.getTransaction().commit();
		      System.out.println("Cliente excluído.");
		    }
		    else{
		      System.out.println("Cliente não encontrado."); 
		    }
	
		
	}
	
	public Cliente pesquisa(String cpf) {
		EntityManager em = jpa.getEntityManager();;
		Cliente c = em.find(Cliente.class, cpf);
		
		if(c!= null){
			  
			  return c;
			
		    }
		    else{
		      System.out.println("Cliente não encontrado."); 
		    
		      return null;
		    }
		 
	}
	
	
	public <Cliente>List<Cliente> listarTodos(Class<Cliente> tipo) {
		EntityManager em = jpa.getEntityManager();;
	    return em.createQuery("FROM " + tipo.getSimpleName(), tipo).getResultList();
	}
	
	public void encerrarConexao (EntityManager em) {
		 em.close();
		 jpa.closeConnection();
	}

	
	
		

}

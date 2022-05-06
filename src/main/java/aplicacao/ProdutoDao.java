package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import sistema.Produto;

public class ProdutoDao {
	Produto produ  = null;
	JPAUtil jpa = new JPAUtil();
	
	
	public void inserirNovo(Produto p) {
		EntityManager em = jpa.getEntityManager();
		Produto alt = em.find(Produto.class, p.getCodigo());
		 if(alt != null){
		      
		      System.out.println("Produto já registrado");
		    }
		    else{
		      em.getTransaction().begin(); 
		      em.persist(p);
		      em.getTransaction().commit();
		      System.out.println("Produto registrado com sucesso.");  
		    }
		
		
	}
	
	public void alterar(Produto p) {
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
        System.out.println("Dados atualizados");
		
		
	}
	
	public void excluirProduto(Integer codigo) {
		EntityManager em = jpa.getEntityManager();
		Produto p = em.find(Produto.class, codigo);
		if(p!= null){
			  em.getTransaction().begin(); 
		      em.remove(p);
		      em.getTransaction().commit();
		      System.out.println("Produto excluído.");
		    }
		    else{
		      System.out.println("Produto não encontrado."); 
		    }
		
		
	}
	
	public Produto pesquisa(Integer codigo) {
		EntityManager em = jpa.getEntityManager();
		Produto p = em.find(Produto.class, codigo);
		if(p!= null){
			  return p;
		    }
		    else{
		      System.out.println("Produto não encontrado."); 
		      return null;
		    }
		 
	}
	
	public  List<Produto> pesquisaTodos(){
		EntityManager em = jpa.getEntityManager();
		Query query = em.createQuery("select  from basedadosforum.cliente");
		List<Produto> produtos = query.getResultList();
		
		return produtos;
	}
	
	
	public <Produto>List<Produto> listarTodos(Class<Produto> tipo) {
		EntityManager em = jpa.getEntityManager();
	    return em.createQuery("FROM " + tipo.getSimpleName(), tipo).getResultList();
	}
	
	
	
	public void encerrarConexao (EntityManager em) {
		 em.close();
		 jpa.closeConnection();
	}

	
}

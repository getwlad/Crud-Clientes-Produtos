package aplicacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	

	    private static final EntityManagerFactory FACTORY  =
	            Persistence.createEntityManagerFactory("suabasedados");
	;

	    public static EntityManager getEntityManager() {
	        return FACTORY.createEntityManager();
	    }
	    public void closeConnection () {
	    	this.FACTORY.close();
	    }
	
}

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.biblio.Livre;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.title='Guerre et paix'", Livre.class);
		Livre l = query.getResultList().get(0);
		System.out.println(l.getTitle()+" de "+l.getAuthor());
	}

}

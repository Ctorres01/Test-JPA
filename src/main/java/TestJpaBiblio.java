import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import dev.biblio.Emprunt;
import dev.biblio.Livre;

public class TestJpaBiblio {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_jpa_biblio");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		/*Récupération d'un lire à partir de son titre
		TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.title='Guerre et paix'", Livre.class);
		Livre l = query.getResultList().get(0);
		System.out.println(l.getTitle()+" de "+l.getAuthor());*/
		
		
		//Récupération des livres à partir d'un emprunt
		TypedQuery<Emprunt> query2 = em.createQuery("SELECT e FROM Emprunt e WHERE e.id =:id", Emprunt.class).setParameter("id", 2L);
		for(Livre livre : query2.getResultList().get(0).getLivres()) {
			System.out.println(livre.getTitle()+" de "+livre.getAuthor());
		}
		
		//Récupération des emprunts à partir d'un client
		TypedQuery<Emprunt> query3 = em.createQuery("SELECT e FROM Emprunt e WHERE e.client.id =:id", Emprunt.class).setParameter("id", 1L);
		for(Emprunt emprunt : query3.getResultList()) {
			System.out.println("Emprunt numéro "+emprunt.getId() + " datant du "+ emprunt.getBeginningDate()+" au nom de "+emprunt.getClient().getLastName());
		}
		
		em.close();
		entityManagerFactory.close();
	}

}

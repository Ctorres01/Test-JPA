import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.banque.Adresse;
import dev.banque.AssuranceVie;
import dev.banque.Banque;
import dev.banque.Client;
import dev.banque.Compte;
import dev.banque.LivretA;
import dev.banque.Operation;
import dev.banque.Virement;

public class TestJpaBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test_jpa_banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		//Début de la transaction
		et.begin();
		
		Banque banque = new Banque("CIC");
		em.persist(banque);
		
		Adresse adresse = new Adresse(15, "rue du lila", 75000, "Paris");
		Client c1 = new Client("Torres", "Corentin", LocalDate.of(1996,05,26), banque, adresse);
		em.persist(c1);
		
		Client c2 = new Client("Flaco", "Joe", LocalDate.of(1996,05,26), banque, adresse);
		em.persist(c2);
		
		Compte compte = new Compte("FR76 59885351482677", 25000);
		compte.getClients().add(c1);
		compte.getClients().add(c2);
		em.persist(compte);
		
		
		
		AssuranceVie assuranceVie = new AssuranceVie("FR45 45435434353", 2000, 5.4, LocalDate.of(2022, 11, 25));
		em.persist(assuranceVie);
		c1.getComptes().add(assuranceVie);
		
		LivretA livretA = new LivretA("FR69 45464846844313513", 2000, 2.4);
		em.persist(livretA);
		c1.getComptes().add(livretA);
		
		Virement virement = new Virement(LocalDateTime.now(), 350, "Remboursement", compte, "Jésus Christ");
		em.persist(virement);
		
		Operation operation = new Operation(LocalDateTime.now(), 350, "Remboursement", compte);
		em.persist(operation);
		
		
		//Fin de la transaction
		et.commit();
		em.close();
		entityManagerFactory.close();
	}

}

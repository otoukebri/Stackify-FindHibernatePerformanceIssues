package org.thoughts.on.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.thoughts.on.java.model.Order;
import org.thoughts.on.java.model.OrderItem;

public class TestOrder {

	Logger log = Logger.getLogger(this.getClass().getName());

	private EntityManagerFactory emf;

	@Before
	public void init() {
		emf = Persistence.createEntityManagerFactory("my-persistence-unit");
	}

	@After
	public void close() {
		emf.close();
	}

	@Test
	public void testLoadOrder() {
		log.info("... testPersist ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Order o = em.createQuery("SELECT o FROM Order o WHERE id = 1", Order.class).getSingleResult();
		log.info(o);

		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testN1Select() {
		log.info("... testN1Select ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
		for (Order o : orders) {
			log.info("Order: "+o.getId() + "Num items: "+o.getItems().size());
		}

		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testJoinFetch() {
		log.info("... testJoinFetch ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Order> orders = em.createQuery("SELECT DISTINCT o FROM Order o JOIN FETCH o.items", Order.class).getResultList();
		for (Order o : orders) {
			log.info("Order: "+o.getId() + " Num items: "+o.getItems().size());
		}

		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testNativeQuery() {
		log.info("... testNativeQuery ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Order o = (Order) em.createNativeQuery("SELECT * FROM purchase_order o WHERE id = 1", Order.class).getSingleResult();
		log.info(o);

		em.getTransaction().commit();
		em.close();
	}
}

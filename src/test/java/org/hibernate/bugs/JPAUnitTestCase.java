package org.hibernate.bugs;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.bugs.test.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	private void addEmptyEmbeddedClass(HasEmbeddedClass hasEmbeddedClass) {
		hasEmbeddedClass.setEmbeddedClass(new EmbeddedClass());
	}

	@Test
	public void discriminatorColumnSuperClassTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		HasEmbeddedClass hasEmbeddedClass = new DiscriminatorChild();
		addEmptyEmbeddedClass(hasEmbeddedClass);

		HasEmbeddedClass merged = entityManager.merge(hasEmbeddedClass);

		entityManager.getTransaction().commit();
		entityManager.close();

		assertNotNull(merged.getEmbeddedClass());
		assertNotNull(merged.getEmbeddedClass().getDate());
	}

	@Test
	public void mappedSuperClassTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		HasEmbeddedClass hasEmbeddedClass = new MappedSuperclassChild();
		addEmptyEmbeddedClass(hasEmbeddedClass);

		HasEmbeddedClass merged = entityManager.merge(hasEmbeddedClass);

		entityManager.getTransaction().commit();
		entityManager.close();

		assertNotNull(merged.getEmbeddedClass());
		assertNotNull(merged.getEmbeddedClass().getDate());
	}

	@Test
	public void normalClassTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		HasEmbeddedClass hasEmbeddedClass = new NormalClass();
		addEmptyEmbeddedClass(hasEmbeddedClass);

		HasEmbeddedClass merged = entityManager.merge(hasEmbeddedClass);

		entityManager.getTransaction().commit();
		entityManager.close();

		assertNotNull(merged.getEmbeddedClass());
		assertNotNull(merged.getEmbeddedClass().getDate());
	}
}

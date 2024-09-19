package com.ex.us.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ex.us.entity.Url;

@Repository
public class UrlRepository {

	private EntityManagerFactory factory;

	private UrlRepository(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void saveUrl(Url url) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(url);
		transaction.commit();

		manager.close();
	}

	public List<Url> getAllUrls() {
		EntityManager manager = factory.createEntityManager();

		TypedQuery<Url> query = manager.createQuery("FROM Url", Url.class);
		List<Url> list = query.getResultList();
		manager.close();

		return list;
	}

	public String findActualUrlByShortUrl(String shortUrl) {
		EntityManager manager = factory.createEntityManager();

		Url url = manager.find(Url.class, shortUrl);
		String actualUrl = url.getActualUrl();

		manager.close();

		return actualUrl;
	}

	public void deleteActualUrlByShortUrl(String shortUrl) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.remove(manager.find(Url.class, shortUrl));
		transaction.commit();

		manager.close();

	}

}

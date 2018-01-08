package com.org.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sesionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable te) {
			System.out.println("Initial SessionFactory creation failed." + te);
			throw new ExceptionInInitializerError(te);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sesionFactory;
	}
}

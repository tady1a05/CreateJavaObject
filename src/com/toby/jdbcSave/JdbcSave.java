package com.toby.jdbcSave;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Student;

public class JdbcSave {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent1 = new Student("DD123","Cheung","hang@gmail.com");
			Student tempStudent2 = new Student("KK123","Cheung","hang@gmail.com");

			session.beginTransaction();
			
			session.save(tempStudent1);
			
			session.save(tempStudent2);

			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
		
	}

}

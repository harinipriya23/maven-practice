package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;


public class Main {


	public static void main(String[] args) {
		
		Subjects sb1 = new Subjects();
		sb1.setEnglish(97);
		sb1.setMaths(78);
		sb1.setScience(64);


		Student s1 = new Student();
		s1.setId(2);
		s1.setName("Dora");
		s1.setSubject(sb1);


		Configuration config = new Configuration();
		config.addAnnotatedClass(main.Student.class);
		config.configure("hibernate.cfg.xml");


		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		/*
		 * transaction is needed only while manipulating the data.. not used while
		 * fetching the data
		 */
		Transaction transaction = session.beginTransaction();
		/*
		 * CRUD operations - create(persist,save), read(find, get), update(merge,
		 * update), delete(remove, delete) -object must be directly passed or fetch the
		 * particular data then delete
		 */
//		session.persist(s1); // create
		Student s2 = session.find(Student.class, 2); // read
		session.merge(s1);
//		session.remove(s2); // delete
		transaction.commit();
  
		session.close();
		factory.close();

		System.out.println(s1);
		System.out.println(s2);
	}
}

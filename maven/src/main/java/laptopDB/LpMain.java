package laptopDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LpMain {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.addAnnotatedClass(laptopDB.Laptop.class);
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Laptop l1 = new Laptop();
		l1.setId(1);
		l1.setBrand("Dell");
		l1.setModel("XPS 13 Plus");
		l1.setRam(16);

		Laptop l2 = new Laptop();
		l2.setId(2);
		l2.setBrand("Apple");
		l2.setModel("MacBook Air M2");
		l2.setRam(8);

		Laptop l3 = new Laptop();
		l3.setId(3);
		l3.setBrand("HP");
		l3.setModel("Spectre x360 14");
		l3.setRam(16);

		Laptop l4 = new Laptop();
		l4.setId(4);
		l4.setBrand("Microsoft");
		l4.setModel("Surface Laptop 5");
		l4.setRam(16);
		
//		session.persist(l1);
//		session.persist(l2);
		session.persist(l4);

		transaction.commit();

		session.close();
		factory.close();
	}

}

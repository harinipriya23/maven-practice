package laptopDB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LpMain {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.addAnnotatedClass(laptopDB.Laptop.class);
		config.configure("hibernate.cfg.xml");

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		String HQL = "from Laptop where ram = ?1";

		Query query = session.createQuery(HQL);
		query.setParameter(1,8);
		List<Laptop> res = query.getResultList();
		

		transaction.commit();
		System.out.println(res);
		session.close();
		factory.close();
	}

}

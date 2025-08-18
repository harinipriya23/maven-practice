package studentDB;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

public class StMain {

	public static void main(String[] args) {

		Subjects sb1 = new Subjects();
		sb1.setId(101);
		sb1.setEnglish(96);
		sb1.setMaths(88);
		sb1.setScience(93);

		Subjects sb2 = new Subjects();
		sb2.setId(102);
		sb2.setEnglish(95);
		sb2.setMaths(99);
		sb2.setScience(88);

		Subjects sb3 = new Subjects();
		sb3.setId(103);
		sb3.setEnglish(85);
		sb3.setMaths(69);
		sb3.setScience(78);

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Jackie chan");

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Dora");

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Shin chan");

		s1.setSubjects(Arrays.asList(sb1, sb2));
		s2.setSubjects(Arrays.asList(sb2, sb3));
		s3.setSubjects(Arrays.asList(sb3, sb1));

		sb1.setStudent(Arrays.asList(s1, s3));
		sb2.setStudent(Arrays.asList(s1, s2));
		sb3.setStudent(Arrays.asList(s3, s2));

		Configuration config = new Configuration();
		config.addAnnotatedClass(studentDB.Student.class);
		config.addAnnotatedClass(studentDB.Subjects.class);
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

		
		  session.persist(sb1); session.persist(sb2); session.persist(sb3);
		  session.persist(s1); // create session.persist(s2); session.persist(s3);
		  
//		  Subjects s2 = session.find(Subjects.class, 107); // read session.merge(s1);
		  session.remove(s2); // delete
		 

		transaction.commit();

		session.close();
		factory.close();

		System.out.println(s1);
	}
}

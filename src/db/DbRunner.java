package db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class DbRunner {
	static {
		System.setProperty("log4j.configurationFile", "resources/configuration.xml");
	}
	public static void main(String[] args) {
		// docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres -v pgdata:/var/lib/postgresql/data postgres:9.4

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		DbProfile profile = new DbProfile();

		profile.setName("prateek");
		profile.setJob("dev");

		session.save(profile);
		session.getTransaction().commit();
		
		 Criteria criteria = session.createCriteria(DbProfile.class);
         List<DbProfile> profiles = criteria.list();
         System.out.println(profiles);
         
         HibernateUtil.shutdown();
	}

}

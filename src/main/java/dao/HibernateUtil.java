package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory sessionFactory;

    public static SessionFactory getsessionFactory()
    {
        if(sessionFactory==null)
        {
            try {
                Configuration config = new Configuration();

                config.configure();
                sessionFactory = config.buildSessionFactory();
                System.out.println("good");
            }
            catch(HibernateException e){System.out.println(e.getMessage());sessionFactory=null;}
        }

        return sessionFactory;
    }

}

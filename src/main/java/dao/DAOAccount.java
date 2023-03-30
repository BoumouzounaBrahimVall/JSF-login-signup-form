package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOAccount {
    public boolean create( Account Em) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getsessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(Em);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e);
            return false;

        }
    }

    public Account getAccount(String username){
        Transaction tr=null;
        Session session=null;
        try{
            session=HibernateUtil.getsessionFactory().openSession();
            tr=session.beginTransaction();
            Account account=session.get(Account.class,username);
            tr.commit();
            session.close();
            return account;
        }catch (Exception e){
            tr.rollback();
            session.close();
            return null;
        }
    }
}

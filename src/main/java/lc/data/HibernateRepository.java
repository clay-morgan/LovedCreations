package lc.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateRepository
{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }

    public Session session()
    {
        return sessionFactory.getCurrentSession();
    }
}

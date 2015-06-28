package lc.data;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CreationDAO extends HibernateRepository
{
    public List<Creation> selectAllCreations()
    {
        return session().createQuery( "FROM lc.data.Creation" ).list();
    }

    public void create( Creation creation )
    {
        session().save( creation );
    }

    public Creation selectCreationById( int id )
    {
        Criteria criteria = session().createCriteria( Creation.class );
        criteria.add( Restrictions.idEq( id ) );
        return ( Creation )criteria.uniqueResult();
    }

    public void update( Creation creation )
    {
        session().update( creation );
    }

    public void delete( Creation creation )
    {
        session().delete( creation );
    }
}

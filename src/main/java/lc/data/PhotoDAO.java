package lc.data;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PhotoDAO extends HibernateRepository
{
    public List<Photo> selectPhotosByCreationId( int id )
    {
        Criteria criteria = session().createCriteria( Photo.class );
        criteria.setFetchMode( "creation", FetchMode.JOIN );
        criteria.createAlias( "creation", "c" );
        criteria.add( Restrictions.eq( "c.id", id ) );
        return criteria.list();
    }

    public Photo selectMainPhotoByCreationId( int id )
    {
        Criteria criteria = session().createCriteria( Photo.class );
        criteria.setFetchMode( "creation", FetchMode.JOIN );
        criteria.createAlias( "creation", "c" );
        criteria.add( Restrictions.eq( "c.id", id ) );
        criteria.add( Restrictions.eq( "main", true ) );
        return ( Photo )criteria.uniqueResult();
    }

    public Photo selectPhotoById( int id )
    {
        Criteria criteria = session().createCriteria( Photo.class );
        criteria.add( Restrictions.idEq( id ) );
        return ( Photo )criteria.uniqueResult();
    }

    public void create( Photo photo )
    {
        session().save( photo );
    }

    public void update( Photo photo )
    {
        session().update( photo );
    }

    public void delete( Photo photo )
    {
        session().delete( photo );
    }
}

package lc.service;

import lc.data.Creation;
import lc.data.CreationDAO;
import lc.data.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service( "creationService" )
public class CreationService
{
    private CreationDAO creationDao;

    @Autowired
    public void setCreationDao( CreationDAO creationDao )
    {
        this.creationDao = creationDao;
    }

    public List<Creation> getCreations()
    {
        return creationDao.selectAllCreations();
    }

    public void create( Creation creation )
    {
        creationDao.create( creation );
    }

    public Creation getCreationById( int id )
    {
        return creationDao.selectCreationById( id );
    }

    public void save( Creation creation )
    {
        creationDao.update( creation );
    }

    public void delete( Creation creation )
    {
        creationDao.delete( creation );
    }

}

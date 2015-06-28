package lc.service;

import lc.data.Photo;
import lc.data.PhotoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( value = "photoService" )
public class PhotoService
{
    private PhotoDAO photoDAO;

    @Autowired
    public void setPhotoDAO( PhotoDAO photoDAO )
    {
        this.photoDAO = photoDAO;
    }

    public List<Photo> getPhotosForCreation( int creationId )
    {
        return photoDAO.selectPhotosByCreationId( creationId );
    }

    public boolean hasPhotos( int creationId )
    {
        List<Photo> photos = photoDAO.selectPhotosByCreationId( creationId );
        return !photos.isEmpty();
    }

    public void delete( Photo photo )
    {
        photoDAO.delete( photo );
    }

    public void create( Photo photo )
    {
        photoDAO.create( photo );
    }

    public void setAsMainPhoto( Photo photo )
    {
        Photo previousMainPhoto = photoDAO.selectMainPhotoByCreationId( photo.getCreation().getId() );
        if( previousMainPhoto.getId() != photo.getId() )
        {
            photo.setMain( true );
            photoDAO.update( photo );

            previousMainPhoto.setMain( false );
            photoDAO.update( previousMainPhoto );
        }
    }

    public Photo getMainPhotoByCreationId( int creationId )
    {
        return photoDAO.selectMainPhotoByCreationId( creationId );
    }

    public Photo getPhotoById( int id )
    {
        return photoDAO.selectPhotoById( id );
    }

}

package lc.controller;

import lc.data.Photo;
import lc.service.PhotoService;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class PhotoController
{
    private static final int THUMB_DIMENSION = 180;
    private static final int PHOTO_DIMENSION = 1000;

    private PhotoService photoService;

    @Autowired
    public void setPhotoService( PhotoService photoService )
    {
        this.photoService = photoService;
    }

    @RequestMapping( "/addPhoto/{creationId}" )
    public String showAddPhoto( Model model, @PathVariable String creationId )
    {
        model.addAttribute( "creation", creationId );

        return "addPhoto";
    }


    @RequestMapping( value = "/addPhotoSubmit", method = RequestMethod.POST )
    public ModelAndView processAddPhoto( @RequestParam("creation") String creation, @RequestParam("file") MultipartFile file ) throws IOException
    {
        Photo photo = new Photo();
        photo.setOriginalData( file.getBytes() );
        photo.setImageData( getResizedImageData( file, PHOTO_DIMENSION ) );
        photo.setThumbData( getResizedImageData( file, THUMB_DIMENSION ) );
        photo.getCreation().setId( Integer.parseInt( creation ) );
        if( !photoService.hasPhotos( photo.getCreation().getId() ) )
        {
            photo.setMain( true );
        }
        else
        {
            photo.setMain( false );
        }
        photoService.create( photo );

        return new ModelAndView( "redirect:/creation/" + creation );
    }


    @RequestMapping( value = "/image/{photoId}" )
    public void showPhoto( HttpServletResponse response, @PathVariable String photoId ) throws IOException
    {
        Photo photo = photoService.getPhotoById( Integer.parseInt( photoId ) );

        response.setContentType( "image/jpeg" );
        ByteArrayInputStream in = new ByteArrayInputStream( photo.getImageData() );
        IOUtils.copy( in, response.getOutputStream() );
    }


    @RequestMapping( value = "/original/{photoId}" )
    public void showOriginal( HttpServletResponse response, @PathVariable String photoId ) throws IOException
    {
        Photo photo = photoService.getPhotoById( Integer.parseInt( photoId ) );

        response.setContentType( "image/jpeg" );
        ByteArrayInputStream in = new ByteArrayInputStream( photo.getOriginalData() );
        IOUtils.copy( in, response.getOutputStream() );
    }


    @RequestMapping( value = "/thumb/{photoId}" )
    public void showThumb( HttpServletResponse response, @PathVariable String photoId ) throws IOException
    {
        Photo photo = photoService.getPhotoById( Integer.parseInt( photoId ) );

        response.setContentType( "image/jpeg" );
        ByteArrayInputStream in = new ByteArrayInputStream( photo.getThumbData() );
        IOUtils.copy( in, response.getOutputStream() );
    }


    /**
     * get image data, given extension, image file, and size
     */
    private static byte[] getResizedImageData( MultipartFile imageFile, int imageSize ) throws IOException
    {
        InputStream in = new ByteArrayInputStream( imageFile.getBytes() );
        BufferedImage inputImage = ImageIO.read( in );
        BufferedImage outputImg = Scalr.resize( inputImage, imageSize );

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write( outputImg, "jpg", buffer );
        return buffer.toByteArray();
    }

}

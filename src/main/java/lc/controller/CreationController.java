package lc.controller;

import lc.data.Creation;
import lc.data.Photo;
import lc.service.CreationService;
import lc.service.PhotoService;
import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class CreationController
{

    private PhotoService photoService;

    private CreationService creationService;

    @Autowired
    public void setPhotoService( PhotoService photoService )
    {
        this.photoService = photoService;
    }

    @Autowired
    public void setCreationService( CreationService creationService )
    {
        this.creationService = creationService;
    }

    @RequestMapping( "addCreation" )
    public String showAddCreation( Model model )
    {
        model.addAttribute( "creation", new Creation() );     // corresponds to the "commandName" attribute (from spring tags form taglib)
        return "addCreation";
    }

    @RequestMapping( "addCreationSubmit" )
    public String processAddCreation( Model model, @Valid Creation creation, BindingResult bindingResult )
    {
        if ( bindingResult.hasErrors() )
        {
            return "addCreation";
        }

        creation.setCreateDate( new Date() );
        creationService.create( creation );
        return "redirectHome";
    }


    @RequestMapping( "editCreation/{id}" )
    public String showEditCreation( Model model, @PathVariable String id )
    {
        Creation creation = creationService.getCreationById( Integer.parseInt( id ) );
        model.addAttribute( "creation", creation );

        return "editCreation";
    }


    @RequestMapping( "editCreationSubmit" )
    public String processEditCreation( @Valid Creation creation, BindingResult bindingResult )
    {
        if ( bindingResult.hasErrors() )
        {
            return "editCreation";
        }

        creationService.save( creation );

        return "redirectHome";
    }


    @RequestMapping( "deleteCreation/{id}" )
    public String deleteCreation( @PathVariable String id )
    {
        Creation creation = creationService.getCreationById( Integer.parseInt( id ) );
        creationService.delete( creation );

        return "redirectHome";
    }


    @RequestMapping( "creation/{id}" )
    public String viewCreation( Model model, @PathVariable String id, @RequestParam( value="showPhoto", required = false ) String showImageId )
    {
        Creation creation = creationService.getCreationById( Integer.parseInt( id ) );
        model.addAttribute( "creation", creation );

        List<Photo> photos = photoService.getPhotosForCreation( creation.getId() );
        model.addAttribute( "photos", photos );

        if( showImageId == null )
        {
            Photo mainPhoto = photoService.getMainPhotoByCreationId( creation.getId() );
            if( mainPhoto != null )
            {
                model.addAttribute( "showPhoto", mainPhoto );
            }
        }
        else
        {
            Photo showPhoto = photoService.getPhotoById( Integer.parseInt( showImageId) );
            model.addAttribute( "showPhoto", showPhoto );
        }


        return "viewCreation";
    }
}


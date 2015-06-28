package lc.controller;

import lc.data.Creation;
import lc.service.CreationService;
import lc.service.PhotoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController
{
    private static Logger logger = Logger.getLogger( HomeController.class );

    private CreationService creationService;

    @Autowired
    public void setCreationService( CreationService creationService )
    {
        this.creationService = creationService;
    }

    @RequestMapping( "/" )
    public String displayHome( Model model )
    {
        logger.info( "Showing home page" );

        List<Creation> creations = creationService.getCreations();
        model.addAttribute( "creations", creations );

        return "home";
    }

    @RequestMapping( "/redirectHome" )
    public String redirectHome()
    {
        return "redirectHome";
    }
}

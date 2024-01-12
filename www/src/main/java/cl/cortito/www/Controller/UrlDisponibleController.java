package cl.cortito.www.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cortito.www.Service.ShortUrlService;
import cl.cortito.www.Service.UrlDisponibleService;
import java.util.List;

import cl.cortito.www.Model.UrlDisponible; // Import UrlDisponible model
import cl.cortito.www.Repository.UsuarioRepository;



@RestController
@RequestMapping("/urldisponible")
public class UrlDisponibleController {
    @Autowired
    UrlDisponibleService urlDisponibleService;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ShortUrlService shortUrlService;

    //Obtener todas las UrlDisponible.
    @GetMapping
    public List<UrlDisponible> getAllUrlDisponible(){
        return urlDisponibleService.getAllUrlDisponible();
    }

}

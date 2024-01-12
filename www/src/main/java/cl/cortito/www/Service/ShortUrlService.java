package cl.cortito.www.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cortito.www.Model.ShortUrl;
import cl.cortito.www.Model.UrlDisponible;
import cl.cortito.www.Model.Usuario;
import cl.cortito.www.Repository.ShortUrlRepository;
import cl.cortito.www.Repository.UsuarioRepository;

@Service
public class ShortUrlService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UrlDisponibleService urlDisponibleService;
    @Autowired
    ShortUrlRepository shortUrlRepository;


    // Create short url 
    public String createShortUrl(String longUrl, String correo){
         //get user by correo
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        // get  UrlDisponible
        UrlDisponible urlDisponible= urlDisponibleService.getFirstUrlDisponible();
        // object shorturl
        ShortUrl  newShortUrl = new ShortUrl();
        // set long url
        newShortUrl.setLongUrl(longUrl);
        // set persona
        newShortUrl.setPersona(usuario.getPersona());
        // set url disponible
        newShortUrl.setUrlDisponible(urlDisponible);
        // save short url
        newShortUrl= shortUrlRepository.save(newShortUrl);
        // update UrlDisponible  to set disponible false
        urlDisponible.setDisponible(false);
        // save url disponible
        urlDisponibleService.save(urlDisponible);
        return longUrl;
    }
    
}

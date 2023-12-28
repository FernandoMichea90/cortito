package cl.cortito.www.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.cortito.www.Service.UrlDisponibleService;
import java.util.List;
import cl.cortito.www.Model.UrlDisponible; // Import UrlDisponible model



@RestController
@RequestMapping("/urldisponible")
public class UrlDisponibleController {
    @Autowired
    UrlDisponibleService urlDisponibleService;

    //Obtener todas las UrlDisponible.
    @GetMapping
    public List<UrlDisponible> getAllUrlDisponible(){
        return urlDisponibleService.getAllUrlDisponible();
    }

}

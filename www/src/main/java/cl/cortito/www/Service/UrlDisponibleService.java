package cl.cortito.www.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.cortito.www.Repository.UrlDisponibleRepository;
import java.util.List;
import cl.cortito.www.Model.UrlDisponible; // Import UrlDisponible model

@Service
public class UrlDisponibleService {
    @Autowired
    UrlDisponibleRepository urlDisponibleRepository;

    //Obtener todas las UrlDisponible.
    public List<UrlDisponible> getAllUrlDisponible(){
        return urlDisponibleRepository.findAll();
    }
    
}

package cl.cortito.www.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.cortito.www.Model.UrlDisponible; // Import UrlDisponible model

public interface UrlDisponibleRepository extends JpaRepository<UrlDisponible, Long> {
    // Your repository code goes here
    // find by disponible = true and get first 
    UrlDisponible findFirstByDisponibleTrue();
    
}

package cl.cortito.www.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.cortito.www.Model.Persona; // Import Persona model

public interface PersonaRepository extends JpaRepository<Persona, Long>  {
    
}

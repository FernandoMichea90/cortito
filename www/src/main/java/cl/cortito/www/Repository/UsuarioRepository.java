package cl.cortito.www.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.cortito.www.Model.Usuario; // Import Usuario model
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

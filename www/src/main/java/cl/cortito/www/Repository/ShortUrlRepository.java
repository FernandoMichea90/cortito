package cl.cortito.www.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.cortito.www.Model.ShortUrl;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    
    
}

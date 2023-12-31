package cl.cortito.www.Model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column 
    private String shortUrl;
    @ManyToOne
    
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
    @OneToOne
    @JoinColumn(name = "url_disponible_id")
    private UrlDisponible urlDisponible;
    
    
}

package cl.cortito.www.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.cortito.www.Repository.PersonaRepository;
import cl.cortito.www.Model.Persona; // Import Persona model


@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    // crear persona
    public Persona crearPersona(Persona persona){
         return  personaRepository.save(persona);
    }
    
}

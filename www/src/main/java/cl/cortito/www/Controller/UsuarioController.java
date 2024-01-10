package cl.cortito.www.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.cortito.www.Service.UsuarioService;
import cl.cortito.www.Service.PersonaService;
import org.springframework.http.ResponseEntity;

import cl.cortito.www.DTO.LoginRequest;
import cl.cortito.www.Model.Persona;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cl.cortito.www.Model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PersonaService personaService;

    // crear usuario con persona
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        if (usuario.getPersona() != null) {
            try {
                Persona persona = personaService.crearPersona(usuario.getPersona());
                usuario.setPersona(persona);
                usuarioService.crearUsuario(usuario);
                return ResponseEntity.ok().body("Usuario creado correctamente");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        } else {
            // no se puede crear usuario sin persona
            return ResponseEntity.badRequest().body("No se puede crear usuario sin persona");
        }

    }

    // Login usuario
    @PostMapping("/login")
    public ResponseEntity <?> login(@RequestBody LoginRequest loginRequest) {
        try {
             Persona usuarioLogueado = usuarioService.login(loginRequest.getCorreo(),loginRequest.getPassword());
            return ResponseEntity.ok().body(usuarioLogueado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // crear usuario con persona
    @PostMapping("/saludar")
    public ResponseEntity<?> saludar() {
        return ResponseEntity.ok().body("hola");
    }
}

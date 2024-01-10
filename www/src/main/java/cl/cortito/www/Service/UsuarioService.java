package cl.cortito.www.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cortito.www.Model.Persona;
import cl.cortito.www.Model.Usuario;
import cl.cortito.www.Repository.UsuarioRepository;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // crear usuario
    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    // login usuario
    public Persona login(String correo, String password) throws Exception {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null) {
            if (usuario.getContrasena().equals(password)) {
                return usuario.getPersona();
            } else {
                throw new Exception("Contraseña incorrecta");
            }
        } else {
            throw new Exception("Usuario no encontrado");
        }
    }

    
}

package cl.cortito.www.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import cl.cortito.www.Model.Usuario;
import cl.cortito.www.Model.Persona;

import cl.cortito.www.Repository.UsuarioRepository;

import java.util.Collections;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    
    // crear usuario
    public void crearUsuario(Usuario usuario) {
        String contrasena = usuario.getContrasena();
        String contrasenaEncriptada = new BCryptPasswordEncoder().encode(contrasena);
        usuario.setContrasena(contrasenaEncriptada);
        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo);
        }

        return new org.springframework.security.core.userdetails.User(usuario.getCorreo(), usuario.getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

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

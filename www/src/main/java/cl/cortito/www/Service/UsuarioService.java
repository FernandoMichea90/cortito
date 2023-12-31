package cl.cortito.www.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cortito.www.Model.Usuario;
import cl.cortito.www.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // crear usuario
    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    
}

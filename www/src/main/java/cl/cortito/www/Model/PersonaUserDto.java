package cl.cortito.www.Model;

public class PersonaUserDto {

    Persona persona;
    Usuario usuario;

 
    public PersonaUserDto(Persona persona, Usuario usuario) {
        this.persona = persona;
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

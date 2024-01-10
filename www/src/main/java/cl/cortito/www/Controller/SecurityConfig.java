package cl.cortito.www.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig   {
    @Autowired
    private UserDetailsService userDetailsService;
   

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // deshabilita la protección CSRF, ya que no estamos procesando formularios de envío directo
            .csrf(csrf -> csrf.disable())
            // Configura las solicitudes para permitir todas las solicitudes sin autenticación.
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/usuario/login").permitAll()
                .requestMatchers("/usuario").permitAll()
                .anyRequest().authenticated())    
            // Aplica la autenticación HTTP básica con la configuración predeterminada.
            .httpBasic(withDefaults());
        // Construye y devuelve la cadena de filtros de seguridad configurada.
        return http.build();
    }

    @Autowired 
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
         
    }

}

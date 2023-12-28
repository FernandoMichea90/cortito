package cl.cortito.www.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// cambios 

@RestController
@RequestMapping("/google")
public class GoogleController {
    
    @GetMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }
}

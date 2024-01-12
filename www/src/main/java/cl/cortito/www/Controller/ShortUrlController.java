package cl.cortito.www.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import cl.cortito.www.Service.ShortUrlService;

@RestController
@RequestMapping("/shorturl")
public class ShortUrlController {
    @Autowired
    ShortUrlService shortUrlService;

    @PostMapping
    public ResponseEntity<?> createShortUrl(@AuthenticationPrincipal UserDetails userDetails,@RequestBody String longurl) {
        try {
            String correo = userDetails.getUsername();
            // call function createShortUrl from ShortUrlService\
            shortUrlService.createShortUrl(longurl, correo);
            return ResponseEntity.ok().body("Short url created");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating short url");
        }

    }
}

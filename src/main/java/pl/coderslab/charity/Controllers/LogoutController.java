package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        return "You have been logged out";
    }
}

package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.DAO.UserDao;
import pl.coderslab.charity.DTO.passUser;
import pl.coderslab.charity.Entity.User;

@Controller
@AllArgsConstructor
public class LoginController {

    public UserDao userDao;

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}

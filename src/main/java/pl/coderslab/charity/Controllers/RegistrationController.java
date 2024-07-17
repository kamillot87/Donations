package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.DAO.UserDao;
import pl.coderslab.charity.DTO.UserRegistrationDto;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Service.UserClassImpl;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private UserDao userDao;
    private UserClassImpl userClass;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute("user") UserRegistrationDto user) {
//        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userClass.save(user);
        return "redirect:/login";
    }
}

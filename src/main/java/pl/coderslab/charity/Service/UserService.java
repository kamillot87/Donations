package pl.coderslab.charity.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.charity.DTO.UserRegistrationDto;
import pl.coderslab.charity.Entity.User;

public interface UserService extends UserDetailsService {

    User save (UserRegistrationDto userRegistrationDto);
}

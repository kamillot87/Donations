package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.DAO.UserDao;
import pl.coderslab.charity.DTO.UserRegistrationDto;
import pl.coderslab.charity.DTO.passUser;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserClassImpl implements UserService{


    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public UserClassImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setName(userRegistrationDto.getName());
        user.setPassword(userRegistrationDto.getPassword());
        user.setPassword(new BCryptPasswordEncoder().encode(userRegistrationDto.getPassword())); // zahashowanie hasła

        user.setEmail(userRegistrationDto.getEmail());
        user.setLastName(userRegistrationDto.getLastName());
        user.setRoles(List.of(new Role("USER")));
        return userDao.save(user);
    }


    // ustawiamy w serwisie pobieranie danych przez maila
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userDao.findByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName + " not found");
        }
        return new passUser(user,user.getEmail(),user.getPassword(),getAuthorities(user));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user));

    }


    // metoda do pobierania kolekcji roli
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream().map( role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}

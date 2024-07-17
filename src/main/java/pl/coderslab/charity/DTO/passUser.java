package pl.coderslab.charity.DTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class passUser extends User {

    private pl.coderslab.charity.Entity.User user;
    public passUser(pl.coderslab.charity.Entity.User user,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.user= user;
    }

    public pl.coderslab.charity.Entity.User getUser() {
        return user;
    }
}

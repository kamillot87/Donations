package pl.coderslab.charity.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
}

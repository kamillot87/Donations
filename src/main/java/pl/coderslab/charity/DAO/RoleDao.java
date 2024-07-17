package pl.coderslab.charity.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
}

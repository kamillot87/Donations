package pl.coderslab.charity.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entity.Institution;

public interface InstitutionDao extends JpaRepository<Institution, Integer> {
    Institution findByName(String name);
}

package pl.coderslab.charity.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.coderslab.charity.Entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}

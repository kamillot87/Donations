package pl.coderslab.charity.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany (mappedBy = "roles")
    private List<User> users;

    public Role(String name) {
        this.name = name;
    }
}

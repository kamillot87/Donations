package pl.coderslab.charity.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;

    @OneToMany
    private List<Donation> donations;
}

package pl.coderslab.charity.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Donation {

    @Id
    @GeneratedValue
    private Integer id;

    //liczba worków
    private Integer quantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Institution institution;

    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;


}

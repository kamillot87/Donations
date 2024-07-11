package pl.coderslab.charity.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.Entity.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer> {

    @Query ("select count (b) from Donation b")
    Integer allDonationsNumb ();
}

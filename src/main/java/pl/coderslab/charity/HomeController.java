package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.DAO.DonationDao;
import pl.coderslab.charity.DAO.InstitutionDao;
import pl.coderslab.charity.Entity.Donation;

import javax.servlet.http.HttpServletRequest;


@Controller
@AllArgsConstructor
public class HomeController {

    private InstitutionDao institutionDao;
    private DonationDao donationDao;

    @GetMapping("/")
    public String homeAction(Model model){
        //dodanie wszystkich instytucji
        model.addAttribute("instit", institutionDao.findAll());
        //dodanie sumy wszystkich worków
        model.addAttribute("donQuantity", donationDao.findAll().stream().mapToInt(Donation::getQuantity).sum());
        //dodanie liczby wszystkich datków
        model.addAttribute("allDonations", donationDao.allDonationsNumb());
        return "index";
    }
}

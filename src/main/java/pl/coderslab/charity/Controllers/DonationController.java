package pl.coderslab.charity.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.DAO.CategoryDao;
import pl.coderslab.charity.DAO.DonationDao;
import pl.coderslab.charity.DAO.InstitutionDao;
import pl.coderslab.charity.Entity.Category;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private DonationDao donationDao;
    private InstitutionDao institutionDao;
    private CategoryDao categoryDao;

    @GetMapping("/form")
    public String getDonation(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("institutions", institutionDao.findAll());
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping ("/form")
    @ResponseBody
    public String saveDonation(@ModelAttribute("donation") Donation donation, @RequestParam List<String> categories, @RequestParam Integer institution) {
        donation.setCategory(categories.stream().map(a -> categoryDao.findByName(a)).map(category -> category).toList());
        donation.setInstitution(institutionDao.findById(institution).get());
//        donationDao.save(donation);
        return donation.toString();
    }

//    @PostMapping ("/form")
//    @ResponseBody
//    public String saveDonation(@RequestParam List<String> categories, @RequestParam Integer quantity, @RequestParam Integer institutionId,
//                               @RequestParam String street, @RequestParam String city, @RequestParam String zipCode, @RequestParam String phone,
//                               @RequestParam LocalDate pickUpDate, @RequestParam LocalTime pickUpTime, @RequestParam String pickUpComment) {
//        return categories.toString();
//    }
}

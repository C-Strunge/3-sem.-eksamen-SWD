package mandatory.two.controller;

import mandatory.two.model.Company;
import mandatory.two.repository.CategoryRepository;
import mandatory.two.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * Created by Matthias Skou 30/11/2018
 */

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepo;
    @Autowired
    private CategoryRepository categoryRepo;


    @GetMapping("/company/create")
    public String createCompany(Model model){
        model.addAttribute("company", new Company());
        model.addAttribute("category", categoryRepo.findAll());
        return "createCompany";
    }

    @PostMapping("/company/create")
    public String createCompany(@ModelAttribute Company company){
        if (checkIfEmailExists(company.getEmail())){
            companyRepo.save(company);
        }
        // Insert else statement that redirects to company/create
        return "redirect:/company";
    }

    @GetMapping("/company/edit/{id}")
    public String editCompany(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryRepo.findAll());
        model.addAttribute("company", companyRepo.findById(id));

        return "editCompany";
    }

    @PostMapping("/company/edit")
    public String editCompany(@ModelAttribute Company company){
            companyRepo.save(company);
        return "";
    }

    public boolean checkIfEmailExists(String email){
        ArrayList<Company> companyArrayList = (ArrayList) companyRepo.findAllByEmail(email);
        if (companyArrayList.size() >= 1){
            return false;
        } else {
            return true;
        }
    }

}

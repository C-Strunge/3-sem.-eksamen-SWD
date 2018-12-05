package mandatory.two.controller;

import mandatory.two.helper.CreateHelper;
import mandatory.two.model.Company;
import mandatory.two.model.User;
import mandatory.two.repository.CategoryRepository;
import mandatory.two.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
        return "company/createCompany";
    }

    @PostMapping("/company/create")
    public String createCompany(@ModelAttribute Company company){
        ArrayList<User> companyArrayList = (ArrayList) companyRepo.findAllByEmail(company.getEmail());
        if (CreateHelper.checkIfEmailExists(companyArrayList)){
            companyRepo.save(company);
        }
        // Insert else statement that redirects to company/create
        return "redirect:/company";
    }

    @GetMapping("/company/edit/{id}")
    public String editCompany(@PathVariable Long id, Model model){
        Optional<Company> company = companyRepo.findById(id);
        Company c = company.get();
        System.out.println("ID BEFORE: " + c.getId());
        c.setId(id);
        model.addAttribute("category", categoryRepo.findAll());
        model.addAttribute("company", c);
        return "company/editCompany";
    }

    @PostMapping("/company/edit")
    public String editCompany(@ModelAttribute Company company){
        System.out.println(company.getId());
        System.out.println(company.getCompanyName());
        System.out.println(company.getFirstName());
            companyRepo.save(company);
        return "";
    }

}

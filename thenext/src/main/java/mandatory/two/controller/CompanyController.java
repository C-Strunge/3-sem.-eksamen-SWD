package mandatory.two.controller;

import mandatory.two.model.Company;
import mandatory.two.repository.CategoryRepository;
import mandatory.two.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        companyRepo.save(company);
        return "redirect:/company/create/category";
    }

}

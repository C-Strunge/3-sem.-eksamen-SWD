package mandatory.two.controller;

import mandatory.two.helper.CreateHelper;
import mandatory.two.model.Customer;
import mandatory.two.model.User;
import mandatory.two.repository.CategoryRepository;
import mandatory.two.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * Created by Matthias Skou 30/11/2018
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/customer/create")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("category", categoryRepo.findAll());
        return "customer/createCustomer";
    }

    @PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute Customer customer){
        ArrayList<User> customerArrayList = (ArrayList) customerRepo.findAllByEmail(customer.getEmail());
        if (CreateHelper.checkIfEmailExists(customerArrayList)){
            customerRepo.save(customer);
        }
        // Insert else statement that redirects to company/create
        return "redirect:/customer/create/payment";
    }

    @GetMapping("/customer/create/payment")
    public String createCustomerPayment(Model model){
        model.addAttribute(customerRepo.findTopByOrderById());
        return "customer/createCustomerPayment";
    }

    @PostMapping("/customer/create/payment")
    public String createCustomerPayment(@ModelAttribute Customer customer){
        customerRepo.save(customer);
        return "";
    }

}

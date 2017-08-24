package com.jjmining.miningsite.miningsite.controllers;


import com.jjmining.miningsite.miningsite.models.Customer;
import com.jjmining.miningsite.miningsite.models.data.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jarrett on 8/3/2017.
 */

@Controller
@RequestMapping("customer")
public class MiningController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String submit(Model model){
        model.addAttribute("title", "Submit a Budget");
        model.addAttribute(new Customer());

        return "customer/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute @Valid Customer newCustomer,
                                Errors errors, Model model){
        if (errors.hasErrors())
        {
            model.addAttribute("title", "Submit a Budget");
            return "customer/index";
        }

        customerDao.save(newCustomer);
        return "customer/thanks";

    }

}

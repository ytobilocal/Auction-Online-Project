package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.enums.Gender;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new AccountEntity());
        return "registration";
    }

    @PostMapping("/register")
    public String registerAccount(@ModelAttribute("account") AccountEntity account) {
        account.setStatus(UserStatus.ACTIVE);
        account.setGender(Gender.MALE);

        //thêm xác thực, xử lý lỗi tại đây nếu cần

        // Save to the database
        accountService.saveAccount(account);
        return "redirect:/login";
    }
}


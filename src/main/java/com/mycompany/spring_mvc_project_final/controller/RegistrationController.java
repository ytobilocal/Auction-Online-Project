package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.enums.Status;
import com.mycompany.spring_mvc_project_final.repository.RoleRepository;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new AccountEntity());
        return "registration";
    }

    @PostMapping("/register")
    public String registerAccount(@ModelAttribute("account") AccountEntity account, Model model) {
        if (account == null) {
            model.addAttribute("error", "Invalid account data");
            return "registration";
        }

        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(roleRepository.findByRole(Role.ROLE_BIDDER));
        account.setUserRoles(userRoles);


        // Set các giá trị khác cho tài khoản
        account.setStatus(Status.ACTIVE);

        // Lưu vào cơ sở dữ liệu
        accountService.saveAccount(account);

        return "redirect:/login";
    }
}

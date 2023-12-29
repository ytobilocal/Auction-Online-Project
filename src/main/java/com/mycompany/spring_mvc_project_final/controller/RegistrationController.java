package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.enums.Status;
import com.mycompany.spring_mvc_project_final.repository.RoleRepository;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new AccountEntity());
        return "registration";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("account") AccountEntity account, Model model) {
        if (account == null) {
            model.addAttribute("error", "Invalid account data");
            return "registration";
        }

        // Mã hóa mật khẩu sử dụng BCrypt
        String encryptedPassword = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPassword(encryptedPassword);

        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(roleRepository.findByRole(Role.ROLE_BIDDER));
        account.setUserRoles(userRoles);

        account.setStatus(Status.ACTIVE);

        accountService.saveAccount(account);

        return "redirect:/login";
    }
}

package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/home")
public class AdminHomeController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/userList")
    public String showUserList(Model model) {
        List<AccountEntity> accountList = accountService.getAllAccounts();
        model.addAttribute("accountList", accountList);
        return "admin/userList";
    }

    @GetMapping
    public String adminHome() {
        return "admin/home";
    }

    @GetMapping("/edit")
    public String editAccount(@RequestParam("id") String accountId, Model model) {
        AccountEntity account = accountService.getAccountById(accountId);
        model.addAttribute("account", account);

        return "admin/editAccount";
    }

    @GetMapping("/delete")
    public String deleteAccount(@RequestParam("id") String accountId) {
        accountService.deleteAccountById(accountId);

        return "redirect:/admin/userList";
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute("account") AccountEntity updatedAccount) {
        accountService.updateAccount(updatedAccount);

        return "redirect:/admin/userList";
    }
}




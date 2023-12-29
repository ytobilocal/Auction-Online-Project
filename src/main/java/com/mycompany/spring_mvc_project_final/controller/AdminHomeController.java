package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.repository.RoleRepository;
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
    @Autowired
    private RoleRepository roleRepository;
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

//    @GetMapping("/editAccount/{id}")
//    public String editAccount(@PathVariable Long id, Model model) {
//        AccountEntity account = accountService.getAccountById(id);
//        List<RoleEntity> availableRoles = roleRepository.findAll();
//        model.addAttribute("account", account);
//        model.addAttribute("availableRoles", availableRoles);
//        return "admin/editAccount";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateAccount(@PathVariable Long id, @ModelAttribute("account") AccountEntity updatedAccount) {
//        // Kiểm tra xem account có tồn tại không
//        AccountEntity existingAccount = accountService.getAccountById(id);
//        if (existingAccount != null) {
//            // Cập nhật thông tin của account
//            existingAccount.setName(updatedAccount.getName());
//            existingAccount.setPhone(updatedAccount.getPhone());
//            existingAccount.setUserRoles(updatedAccount.getUserRoles());
//
//            accountService.saveAccount(existingAccount);
//        }
//
//        return "redirect:/admin/home/editAccount/" + id;
//    }
//
//    @GetMapping("/delete/${account.id}")
//    public String deleteAccount(@PathVariable Long id) {
//        accountService.deleteAccountById(id);
//        return "redirect:/admin/userList";
//    }
}




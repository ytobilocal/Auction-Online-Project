/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.*;
import com.mycompany.spring_mvc_project_final.enums.Status;
import com.mycompany.spring_mvc_project_final.repository.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    BidRepository bidRepository;
    @Autowired
    CreditRepository creditRepository;

    @RequestMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "error", required = false) boolean error) {

        if (error) {
            model.addAttribute("message", "Login Fail!!!");
        }
        return "login";
    }
    @RequestMapping("/admin/home")
    public String viewHome(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        model.addAttribute("message", "Hello Admin: " + username);
        return "admin/home";
    }

    @RequestMapping("/user/home")
    public String viewHome(Model model, HttpSession session) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            session.setAttribute("username", username);

        }

        return "user/home";
    }

    @RequestMapping("/auctioneer/home")
    public String viewAuctioneerHome(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();

        model.addAttribute("message", "Hello Auctioneer: " + username);
        return "auctioneer/home";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomePage(Model model,HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            session.setAttribute("username", username);
        }
        List<ProductEntity> productEntityList = productRepository.findByView1("2", Status.ACTIVE.name());
        List<AuctionEntity> auctionEntityList=auctionRepository.findByViewEndTime();
        model.addAttribute("auctionEntityList",auctionEntityList);
        model.addAttribute("productEntityList",productEntityList);
        return "home";
    }

    @RequestMapping(value = {"/user/hethan/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public String hethan(@PathVariable long id, HttpServletRequest request) {
        auctionRepository.updateAuctionById(id);

        ProductEntity product=productRepository.findByView2(id);
        AuctionEntity auction=auctionRepository.findByViewPro(product.getProductId());
        BidEntity bid=new BidEntity();
        bid.setAuction(auction);
        bid.setAmount(auction.getStartPrice());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        bid.setTimeStamp(formattedDateTime);
        bid.setAccount(auction.getAccount());
        bid.setStatus(Status.ACTIVE);
        bidRepository.save(bid);
        return "";
    }
    @RequestMapping(value = {"/account"})
    public String account(Model model, HttpServletRequest request) {
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        AccountEntity ac =accountRepository.findByEmail(username);
        long account_id=ac.getId();
        CreditEntity credit=creditRepository.findByAccount_id(account_id);
        List<BidEntity> bid=bidRepository.findByAccount_id(account_id);
        List<BidEntity> bidList = bid.stream()
                .collect(Collectors.toMap(BidEntity::getAuction, p -> p, (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        for (BidEntity b:bidList);
        List<BidEntity> bidEntityList=bidRepository.findByAccount1(account_id);
        model.addAttribute("ac",ac);
        model.addAttribute("credit",credit);
        model.addAttribute("bidList",bidList);
        model.addAttribute("bidEntityList",bidEntityList);
        return "account";
    }
    @RequestMapping(value = {"/thanhToan/{id}"},method = RequestMethod.GET)
    public String thanhToan(Model model,HttpServletRequest request,@PathVariable long id) {
        BidEntity bid=bidRepository.findById(id).get();
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        AccountEntity ac =accountRepository.findByEmail(username);
        long account_id=ac.getId();
        CreditEntity credit=creditRepository.findByAccount_id(account_id);
        double balance=credit.getBalance()-bid.getAmount();
        if (balance>=0){
            credit.setBalance(balance);
            creditRepository.save(credit);
            bid.setStatus(Status.UNACTIVE);
            bidRepository.save(bid);
        }else {
            model.addAttribute("message","Bạn không đử tiền để thanh toán vui lòng nạp thêm");
        }
        return "redirect:/account";
    }
}
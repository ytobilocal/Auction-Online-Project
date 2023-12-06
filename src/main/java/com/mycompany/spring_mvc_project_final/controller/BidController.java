package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BidController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    ProductRepository productRepository;
    @RequestMapping(value = "/bid/{id}",method = RequestMethod.GET)
    public String showBid(Model model, @PathVariable long id){
//        model.addAttribute("product",productRepository.findById(id));
//        model.addAttribute("msg","Sửa vật phẩm");
//        model.addAttribute("type","update");
//        model.addAttribute("action","update");
        return "bid";
    }
}

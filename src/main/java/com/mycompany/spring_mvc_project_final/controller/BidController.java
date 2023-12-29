package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.enums.Status;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class BidController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "user/auction/{id}",method = RequestMethod.GET)
    public String addAuction(Model model,@PathVariable long id){
        ProductEntity pr = productRepository.findById(id).orElse(new ProductEntity());
        model.addAttribute("product", pr);
        AuctionEntity auction=auctionRepository.findByViewPrice(id);
        model.addAttribute("auction",auction);
        return "user/auction";
    }
    @RequestMapping(value = "user/auction/auction1",method = RequestMethod.POST)
    public String saveAuction(AuctionEntity auction, @RequestParam long id1,@RequestParam double startPrice,HttpServletRequest request){
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        if (username != null){
            AccountEntity ac =accountRepository.findByEmail(username);
            auction.setAccount(ac);
            ProductEntity pro = productRepository.findById(id1).orElse(new ProductEntity());
            auction.setProduct(pro);
            auction.setStatus(Status.PENDING);
            auction.setStartPrice(startPrice);
            auctionRepository.save(auction);
        }
        else {

        }
        return "redirect:/";
    }
}




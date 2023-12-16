package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.BidRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BidRepository bidRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showBid(Model model, @PathVariable long id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        // Kiểm tra xem sản phẩm có tồn tại không
        if (product != null) {

            AuctionEntity auction = product.getAuctions().stream().findFirst().orElse(null);
            if (auction != null) {
                model.addAttribute("startPrice", auction.getStartPrice());
            }

            // Thêm sản phẩm vào model để hiển thị trên trang bid.jsp
            model.addAttribute("product", product);
            model.addAttribute("auction", auction);
            return "bid";
        } else {
            // Nếu không tìm thấy sản phẩm, có thể chuyển hướng hoặc xử lý theo cách khác
            return "redirect:/";
        }
    }

}

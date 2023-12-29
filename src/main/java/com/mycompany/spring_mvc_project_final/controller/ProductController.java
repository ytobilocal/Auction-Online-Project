package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Controller
@RequestMapping("/user")
public class ProductController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/sendMail")
    public ModelAndView testSendMail(ModelAndView model) throws IOException {
        // Send mail
        System.out.println("Send Mail ==>");
        String emailTo = "emtyomeka@gmail.com";
        sendEmail(emailTo, "Subject", "Hello all");
        model.addObject("msg", emailTo);
        return new ModelAndView("user/email");
    }

    public void sendEmail(String recipient, String subject, String body) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipient);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
//    @RequestMapping(value = "/insertImage", method = RequestMethod.POST,
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ModelAndView save(@RequestParam("productName") String productName, @RequestParam("description") String description,
//                             @RequestPart("photo") MultipartFile photo) {
//        try {
//            ProductEntity s = new ProductEntity();
//            s.setProductName(productName);
//            s.setDescription(description);
//            s.setProductImg(photo.getBytes());
//            productRepository.save(s);
//            return new ModelAndView( "redirect:/user/fetch");
//            //return new ModelAndView("pro", "msg", "Records succesfully inserted into database.");
//
//        } catch (Exception e) {
//            return new ModelAndView("product/index", "msg", "Error: " + e.getMessage());
//        }
//    }
//    @RequestMapping(value = "/index")
//    public ModelAndView showIndex(ModelAndView model) throws IOException {
//
////        List<ProductEntity> listPro = (List<ProductEntity>) productRepository.findAll();
////
////        model.addObject("listPro", listPro);
//        model.setViewName("product/index");
//
//        return model;
//    }
//    @RequestMapping(value = "/fetch")
//    public ModelAndView listProduct(ModelAndView model) throws IOException {
//
//        List<ProductEntity> listPro = (List<ProductEntity>) productRepository.findAll();
//
//        model.addObject("listPro", listPro);
//        model.setViewName("product/product");
//
//        return model;
//    }
//    @RequestMapping(value = "/getProductPhoto/{productId}")
//    public void getProductPhoto(HttpServletResponse response, @PathVariable("productId") int productId) throws Exception {
//        response.setContentType("image/png");
//
//        ProductEntity s = productRepository.findById(productId).get();
//        byte[] ph = s.getPhoto();
//        InputStream inputStream = new ByteArrayInputStream(ph);
//        IOUtils.copy(inputStream, response.getOutputStream());
//    }
//
//    @RequestMapping(value = "/update/{productId}", method = RequestMethod.GET)
//    public ModelAndView showUpdateForm(@PathVariable("productId") int productId, ModelAndView model) {
//        ProductEntity product = productRepository.findById(productId).orElse(new ProductEntity());
//        model.addObject("product", product);
//        model.setViewName("product/updateForm");
//        return model;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public ModelAndView updateProduct(@ModelAttribute("product") ProductEntity product) {
//        try {
//            productRepository.save(product);
//            return new ModelAndView("redirect:/user/fetch");
//        } catch (Exception e) {
//            return new ModelAndView("product/index", "msg", "Error: " + e.getMessage());
//        }
//    }
//
//    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
//    public ModelAndView deleteProduct(@PathVariable("productId") int productId) {
//        productRepository.deleteById(productId);
//        return new ModelAndView("redirect:/user/fetch");
//    }
}
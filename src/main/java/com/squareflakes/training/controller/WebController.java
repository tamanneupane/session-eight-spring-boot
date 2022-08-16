package com.squareflakes.training.controller;

import com.squareflakes.training.model.Contact;
import com.squareflakes.training.model.MyService;
import com.squareflakes.training.model.MySkill;
import com.squareflakes.training.model.PersonalDetail;
import com.squareflakes.training.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class WebController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private APIService apiService;

    @GetMapping(value = "/")
    public String index(Model model){
        Logger.getGlobal().info("Index function called");

        PersonalDetail personalDetail = new PersonalDetail();
        personalDetail.setName("Taman Neupane");
        personalDetail.setAddress("Bhaktapur, Nepal");
        personalDetail.setEmail("taman@squareflakes.com");
        personalDetail.setAge(30);
        personalDetail.setImage("");
        personalDetail.setCvURL("https://drive.google.com/file/d/1n0GGAYj4LmGxIx3Jdm-qLDKekL1Qnwcx/view?usp=sharing");
        personalDetail.setDescription("This is test description");
        personalDetail.setYearsOfExperience("8");

//        List<MyService> myServices = new ArrayList<>();
//        myServices.add(new MyService("icon", "Web Development", "Web development different kind of websites"));
//        myServices.add(new MyService("icon", "Android Development", "Android development different kind of websites"));
////        myServices.add(new MyService("icon", "IOS Development", "IOS development different kind of websites"));

        MySkill mySkill = new MySkill();
        mySkill.setSkillName("Test Skill");
        mySkill.setSkillPercentage("80");

        model.addAttribute("personal",personalDetail);
        model.addAttribute("services",apiService.getAllService());
        model.addAttribute("skill",mySkill);

        return "index";
    }

    @PostMapping(value = "/contact")
    public String contact(@ModelAttribute Contact contact){
        System.out.println(contact);
        String name = contact.getName();
        String email = contact.getEmail();
        String message = contact.getMessage();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo("taman.neupane@peacenepal.com");
        simpleMailMessage.setSubject("Email from personal website");
        simpleMailMessage.setText(name + " " + email + " " + message);

//        try{
//            javaMailSender.send(simpleMailMessage);
//        }catch (MailSendException exception){
//            exception.printStackTrace();
//        }

        return "redirect:";
    }

}

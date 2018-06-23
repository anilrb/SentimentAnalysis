package com.example1.controller;

import analysis.SentimentModal;
import analysis.SentimentText;
import component.Address;
import component.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anil on 21/6/18.
 */
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    ApplicationContext  applicationContext;

    public  CardController(ApplicationContext applicationContext){
        this.applicationContext=applicationContext;
    }
    @GetMapping
    public SentimentModal getSentimentText() throws IOException {
        SentimentText sentimentText=new SentimentText();
        return sentimentText.getSentimentalAnalysis();
    }

    @GetMapping("/user")
    public List<User>  getUser() throws CloneNotSupportedException {
        User user=applicationContext.getBean(User.class);
        User  user1=applicationContext.getBean(User.class);


        User user2=(User)user.clone();
        user2.setId(1);
        user2.setName("basic");
        System.out.println(user.hashCode()+"  "+user2.hashCode());
        user.setId(1);
        user.setName("Anil");
        Address address=applicationContext.getBean(Address.class);
        address.setAddress("Ghaziabad");
        address.setGaliNo(10);
        user.setAddress(address);
        List<User> users=new LinkedList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }
}
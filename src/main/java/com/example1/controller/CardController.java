package com.example1.controller;

import analysis.SentimentModal;
import analysis.SentimentText;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by anil on 21/6/18.
 */
@RestController
@RequestMapping("/card")
public class CardController {

    @GetMapping
    public SentimentModal getSentimentText() throws IOException {
        SentimentText sentimentText=new SentimentText();
        return sentimentText.getSentimentalAnalysis();
    }
}
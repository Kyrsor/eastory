package by.minsk.controllers;

import by.minsk.impl.LanguageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/language")
public class LanguageController {

    private LanguageServiceImpl languageService;

    @Autowired
    public LanguageController(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }







}

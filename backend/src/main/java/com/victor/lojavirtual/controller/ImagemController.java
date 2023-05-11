package com.victor.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.lojavirtual.service.ImagemService;

@RestController
@RequestMapping(name = "/imagem")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

   

}

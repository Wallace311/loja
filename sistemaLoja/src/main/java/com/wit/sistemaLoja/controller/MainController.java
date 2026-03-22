package com.wit.sistemaLoja.controller;


import com.wit.sistemaLoja.infraestructure.entitys.Estado;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/administrativo")
    public String acessarPrincipal(){
        return "administrativo/home";
    }

}

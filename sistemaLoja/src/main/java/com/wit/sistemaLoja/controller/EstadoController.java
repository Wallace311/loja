package com.wit.sistemaLoja.controller;

import com.wit.sistemaLoja.infraestructure.entitys.Estado;
import com.wit.sistemaLoja.infraestructure.repositorys.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class EstadoController {

    private final EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping("/listarEstados")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("/administrativo/estados/lista");
        mv.addObject("listaEstados", estadoRepository.findAll());
        return mv;
    }


    @GetMapping("/cadastroEstado")
    public ModelAndView cadastrarEstado(Estado estado){
        ModelAndView mv = new ModelAndView("administrativo/estados/cadastro");
        mv.addObject("estado", estado);
        return mv;
    }

    @PostMapping ("/salvarEstado")
    public ModelAndView salvarEstado(Estado estado, BindingResult result){
        if (result.hasErrors()){
            return cadastrarEstado(estado);
        }
        estadoRepository.saveAndFlush(estado);
        return cadastrarEstado(new Estado());
    }

    @GetMapping ("/editarEstado/{id}")
    public ModelAndView editarEstado(@PathVariable("id") Long id){
        Optional <Estado> estado = estadoRepository.findById(id);
        return cadastrarEstado(estado.get());
    }
}

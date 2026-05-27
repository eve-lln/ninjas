package br.com.etec.ninjas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninjas.model.Ninjas;
import br.com.etec.ninjas.service.NinjaService;

@RestController
@RequestMapping ("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping
    public Ninjas cadastrarNinja(@RequestBody Ninjas ninja) {
        return ninjaService.cadastrarNinja(ninja);
    }   
}

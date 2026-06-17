package br.com.etec.ninja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninja.model.Missao;
import br.com.etec.ninja.model.Ninja;
import br.com.etec.ninja.repository.service.MissaoService;
import br.com.etec.ninja.repository.service.NinjaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/missoes")
public class MissaoController {
    
    
    @Autowired
    private MissaoService MissaoService;

     @PostMapping
    public Missao cadastrarMissao (@Valid @RequestBody Missao missao){
        return MissaoService.cadastrarMissao(missao);
        }
        @GetMapping
        public List<Missao> listarMissoes(){
            return MissaoService.listarMissoes();
        }

         @GetMapping("id/{id}")
        public Optional<Missao> pesquisarMissao(@PathVariable Long id){
            return MissaoService.pesquisarMissao(id);
        }
}

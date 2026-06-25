package br.com.etec.ninja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninja.model.Missao;
import br.com.etec.ninja.repository.service.MissaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @PostMapping
    public Missao cadastrarMissao(@Valid @RequestBody Missao missao){
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping
    public List<Missao> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping("/id/{id}")
    public Optional<Missao> pesquisarMissao(@PathVariable Long id){
        return missaoService.pesquisarMissao(id);
    }

    @GetMapping("/dificuldade/{dificuldade}")
    public List<Missao> pesquisarPorDificuldade(
        @PathVariable("dificuldade") String dificuldadeMissao) {
        return missaoService.pesquisarMissaoPorDificuldade(dificuldadeMissao);
}
    @PutMapping("/{id}")
    public Missao atualizarMissao(@PathVariable Long id, @Valid @RequestBody Missao missao){
        return missaoService.atualizarMissao(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }
}
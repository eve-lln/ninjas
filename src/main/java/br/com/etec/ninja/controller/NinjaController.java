package br.com.etec.ninja.controller;

import java.security.PublicKey;
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

import br.com.etec.ninja.model.Ninja;
import br.com.etec.ninja.repository.service.NinjaService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/ninjas") // para mapear requisicoes http para classes ou metodos. Ela define caminhos de URL, métodos HTTP
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping // cadastrar/criar novo objeto 
    public Ninja cadastrarNinja (@Valid @RequestBody Ninja ninja){
        return ninjaService.cadastrarNinja(ninja);
        }
        @GetMapping //utilizada para mapear requisições http do tipo GET, normalmente usadas para buscar ou listar dados em uma API.
        public List<Ninja> listarNinjas(){
            return ninjaService.listarNinjas();
        }
        @GetMapping("id/{id}") //mapear a rota para quando alguem fizer um GET passando um ID na URL, execute o método
        public Optional<Ninja> pesquisarNinja(@PathVariable Long id){ //pathvariable converte o valor inserido na url e armazene na variavel id
            return ninjaService.pesquisarNinja(id);
        }

        @GetMapping("/nomecompleto/{nome}") //altera o endpoint da pesquisaNinjaPorNome
        public Ninja pesquisarNinja(@PathVariable String nome){
            return ninjaService.pesquisarNinjaPorNome(nome);
        }

        @GetMapping("/nome/{nome}")
        public List<Ninja>pesquisarNinjaPorParteDoNome(@PathVariable String nome){
            return ninjaService.pesquisarNinjaPorParteDoNome(nome);
        }

        @PutMapping("/{id}") // a annotation eh utlizada para mapeaer requisicoes http do tipo put. alterar ou atualizar dados existentes
        public Ninja atualizarNinja(@PathVariable Long id, @Valid @RequestBody Ninja ninja){
            return ninjaService.atualizarNinja(id, ninja);
        }

        @DeleteMapping("/{id}")//usada para mapear requisições HTTP do tipo DELETE, nomralmente usadsas para remover registros existentes de aplicação através de um identificador, como o ID.
        public void deletarNinja(@PathVariable Long id){
            ninjaService.deletarNinja(id);
        }
}
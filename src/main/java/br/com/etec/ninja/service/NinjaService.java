package br.com.etec.ninja.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.etec.ninja.model.Ninja;
import br.com.etec.ninja.repository.NinjaRepository;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja (Ninja ninja){
        return ninjaRepository.save(ninja);
    }
    public List<Ninja> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public Optional<Ninja> pesquisarNinja(Long id){
        return ninjaRepository.findById(id);
    }
    
    public Ninja pesquisarNinjaPorNome(String nome){
        return ninjaRepository.findByNome(nome); //querymethod que criamos na repository
    }

    public List<Ninja> pesquisarNinjaPorParteDoNome(String nome){
        return ninjaRepository.findByNomeContaining(nome); // metodo pesquisar ninjas por parte do nome
    }

    public Ninja atualizarNinja(Long id, Ninja ninjaAtualizado){
        Optional<Ninja> ninjaCadastrado = ninjaRepository.findById(id);
        if(ninjaCadastrado.isPresent()){
            Ninja ninja = ninjaCadastrado.get();

            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setCpf(ninjaAtualizado.getCpf());
            ninja.setEmail(ninjaAtualizado.getEmail());

            return ninjaRepository.save(ninja);
    }
    return null;
    }

    public void deletarNinja(Long id){ //void pois nada será retornado. quand algo é deletado, ele deixa de existir; nada retorna
        ninjaRepository.deleteById(id); //deletebyid metodo herdado da JPA (repository)
    }
}

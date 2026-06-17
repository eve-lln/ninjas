package br.com.etec.ninja.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.ninja.model.Missao;
import br.com.etec.ninja.model.Ninja;
import br.com.etec.ninja.repository.MissaoRepository;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

     public Missao cadastrarMissao (Missao missao){
        return missaoRepository.save(missao);
    } 

    public List<Missao> listarMissoes(){
        return missaoRepository.findAll();
    }

    public Optional<Missao> pesquisarMissao(Long id){
        return missaoRepository.findById(id);
    }
    
    public Missao pesquisarMissaoPorNome(String nomeMissao){
        return missaoRepository.findByNome(nomeMissao);
    }

    public List<Missao> pesquisarMissaoPorParteDoNome(String nomeMissao){
        return missaoRepository.findByNomeContaining(nomeMissao);
    }

    public Missao atualizarMissao(Long id, Missao missaoAtualizada){
        Optional<Missao> missaoCadastrada = missaoRepository.findById(id);
        if(missaoCadastrada.isPresent()){
            Missao missao = missaoCadastrada.get();

            missao.setNomeMissao(missaoAtualizada.getNomeMissao());
            missao.setDescMissao(missaoAtualizada.getDescMissao());
            missao.setDificuldadeMissao(missaoAtualizada.getDificuldadeMissao());

            return missaoRepository.save(missao);
    }
    return null;
    }

    public void deletarMissao(Long id){ 
        missaoRepository.deleteById(id);
    }
}


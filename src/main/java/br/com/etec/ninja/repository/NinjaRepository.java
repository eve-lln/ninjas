package br.com.etec.ninja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.ninja.model.Ninja;

public interface NinjaRepository extends JpaRepository<Ninja, Long>{

//quando precisamos de uma busca especifica. como peswquisar por nome, criamos um query method para que o spring data jpa gere automaticamente a consulta.
 
Ninja findByNome(String nome); //criamos o metodo na repository pq ela é a camda responsavel pela comunicação com o banco de dados.
    //findby - metodo herdado  

    List<Ninja> findByNomeContaining(String nome); //metodo pesquisar ninjas por parte do nome. contem, ou seja, pesquisa por partes
}

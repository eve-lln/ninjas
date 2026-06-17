package br.com.etec.ninja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.ninja.model.Missao;

public interface MissaoRepository extends JpaRepository<Missao, Long>{

Missao findByNome(String nomeMissao);

List<Missao> findByNomeContaining(String nomeMissao);

}
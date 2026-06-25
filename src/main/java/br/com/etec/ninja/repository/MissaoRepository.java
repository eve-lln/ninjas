package br.com.etec.ninja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.ninja.model.Missao;

public interface MissaoRepository extends JpaRepository<Missao, Long> {

    List<Missao> findByDificuldadeMissao(String dificuldadeMissao);
}
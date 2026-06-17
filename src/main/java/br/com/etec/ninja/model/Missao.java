package br.com.etec.ninja.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Description;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table (name = "missao")
@Data
@Valid
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_missao;

    @Column (name="nome_missao", nullable = false)
    @Size(min = 3, max = 255, message= "Nome deve ter entre 3 e 255 caracteres.")
    @NotBlank (message = "Nome é obrigatório.")
    private String nomeMissao;

    @Column (name="desc_missao", nullable = false, unique = true)
    @Size(min = 100, max = 300, message= "Descrição deve ter entre 10 e 300 caracteres.")
    private String descMissao;

    @Column (name="dificuldade_missao", nullable = false, unique = true)
    @Size(min = 5, max = 15, message= "Dificuldade da missão deve ter entre 5 e 15 caracteres.")
    private String dificuldadeMissao;
}
package br.com.etec.ninja.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "missao")
@Data
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 3, max = 255)
private String nomeMissao;

    @Column(name = "descricao", nullable = false)
    @NotBlank(message = "Descrição é obrigatória.")
    @Size(min = 10, max = 300)
    private String descMissao;

    @Column(name = "dificuldade", nullable = false)
    @NotBlank(message = "Dificuldade é obrigatória.")
    private String dificuldadeMissao;
}
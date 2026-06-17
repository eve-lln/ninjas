package br.com.etec.ninja.model;

import org.hibernate.validator.constraints.br.CPF;

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
@Table (name = "ninja")
@Data
@Valid
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ninja;
    @Column (name="nome_ninja", nullable = false)
    @Size(min = 3, max = 255, message= "Nome deve ter entre 3 e 255 caracteres.")
    @NotBlank (message = "Nome é obrigatório.")
    private String nome;
    @Column (name="cpf_ninja", nullable = false, unique = true)
    @CPF
    private String cpf;
    @Column (name="email_ninja", nullable = false, unique = true)
    @Email(message = "Email invalido.")
    private String email;
}



    

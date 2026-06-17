package br.com.etec.ninja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ninja;
    @Column (name="nome_ninja", nullable = false)
    private String nome;
    @Column (name="cpf_ninja", nullable = false, unique = true)
    private String cpf;
    @Column (name="email_ninja", nullable = false, unique = true)
    private String email;

    public Ninja() {
    }
    public Ninja(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

package br.com.etec.ninjas.model;

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
@Table (name = "ninja")//Nome diferente do nome da classe 
@Data
@Valid //ativar a validação automática dos dados recebidos pela aplicação

//Construtores vazios 
public class Ninjas {
    @Id//sempre colocar ela a cima da chave que vai ser primaria 
    @GeneratedValue(strategy =  GenerationType.AUTO)//vamos gerar uma sequencia de dados, de maneira automatica que vem do bd, inicia no 1 e ir dando sequência 
    private Long id_ninja;
                                //nullable = nao pode ser nulo
    @Column(name = "nome_ninja", nullable = false)//fica em cima, é a anotacao e quem vai receber a regra
    @NotBlank(message= "Nome é obrigatório.") //annotation notblank é utilizada para validar campos de texto (string), impedindo que sejam enviados valores nulos, vazios ou contendo apenas espaços em branco
    @Size(min=3, max=255, message="Nome deve ter entre 3 e 255 caracteres.") // annotation size serve para definir tamanho minimo e/ou maximo de caracteres
    private String nome;
    @Column(name = "cpf_ninja", nullable = false, unique = true)
    @CPF
    private String cpf;
    @Column(name = "email_ninja", nullable = false, unique = true)
    @Email(message = "E-mail inválido.")
    private String email;
     
    
}

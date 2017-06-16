/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marcely
 */
@Entity
@Table(name = "orientador")
public class Orientador implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_orientador", sequenceName = "seq_orientador_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_orientador", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "O cpf não pode ser nulo")
    @NotBlank(message = "O cpf não pode ser em branco")
    @Length(max = 50, message = "O cpf não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 50, nullable = false)
    private String cpf;
    @NotNull(message = "A instituicao não pode ser nulo")
    @NotBlank(message = "A instituicao não pode ser em branco")
    @Length(max = 50, message = "A instituicao não pode ter mais que {max} caracteres")
    @Column(name = "instituicao", length = 50, nullable = false)
    private String instituicao;
    @NotNull(message = "A titulacao não pode ser nulo")
    @NotBlank(message = "A titulacao não pode ser em branco")
    @Length(max = 50, message = "A titulacao não pode ter mais que {max} caracteres")
    @Column(name = "titulacao", length = 50, nullable = false)
    private String titulacao;
    @OneToMany(mappedBy = "orientador", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Publicacao> publicacoes = new ArrayList<>();

    public Orientador() {
    }
    
     public void adicionarPublicacao(Publicacao obj){
        obj.setOrientador(this);
        this.publicacoes.add(obj);
    }
    
    public void removerPublicacao(int idx){
        this.publicacoes.remove(idx);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orientador other = (Orientador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

}

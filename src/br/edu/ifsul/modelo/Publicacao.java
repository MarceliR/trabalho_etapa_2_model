/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marcely
 */
@Entity
@Table(name = "publicacao")
public class Publicacao implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_publicacao", sequenceName = "seq_publicacao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_publicacao", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message = "O titulo não pode ser nulo")
    @NotBlank(message = "O titulo não pode ser em branco")
    @Length(max = 50, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;
     @NotNull(message = "a data de Publicacao não pode ser nula")
    @Temporal(TemporalType.DATE)
    private Calendar dataPublicacao;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_publicacao_aluno"))    
    private Aluno aluno;
    @NotNull(message = "O orientador não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "orientador_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_publicacao_orientador"))        
    private Orientador orientador;

    public Publicacao() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Publicacao other = (Publicacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }
    
}

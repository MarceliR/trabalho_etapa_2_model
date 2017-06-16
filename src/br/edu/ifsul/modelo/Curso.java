
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "curso")
public class Curso implements Serializable{
     @Id
    @Column(name = "nome", length = 30, nullable = false)   
    private String nome;
       @ManyToMany
     @JoinTable(name = "cursam",
             joinColumns = 
             @JoinColumn(name= "curso", referencedColumnName = "nome",
                     nullable = false),
                     inverseJoinColumns =
              @JoinColumn(name= "aluno", referencedColumnName = "id",
                     nullable = false))
    private List<Aluno> cursam = new ArrayList<>();

    public Curso() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public List<Aluno> getCursam() {
        return cursam;
    }

    public void setCursam(List<Aluno> cursam) {
        this.cursam = cursam;
    }
    
}

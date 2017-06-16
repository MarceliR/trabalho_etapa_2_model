
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
     @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;
     @NotNull(message = "A matricula não pode ser nulo")
    @NotBlank(message = "A matricula não pode ser em branco")
    @Length(max = 50, message = "O matricula não pode ter mais que {max} caracteres")
    @Column(name = "matricula", length = 50, nullable = false)
    private String matricula;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "O sexo não pode ser nulo")
    @NotBlank(message = "O sexo não pode ser em branco")
    @Length(max = 50, message = "O sexo não pode ter mais que {max} caracteres")
    @Column(name = "sexo", length = 50, nullable = false)  
    private String sexo;
    @NotNull(message = "O cpf não pode ser nulo")
    @NotBlank(message = "O cpf não pode ser em branco")
    @Length(max = 50, message = "O cpf não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 50, nullable = false)
    private String cpf;
    @NotNull(message = "O nascimento não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar dataNascimento;
     @NotNull(message = "O Orientador não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "orientador", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_aluno_orientador"))
    private Orientador orientador;
    @ManyToMany
    @JoinTable(name = "cursam",
            joinColumns
            = @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "curso", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_cursam",
                        columnNames = {"aluno", "curso"})})
    private List<Curso> cursam = new ArrayList<>();

    public Aluno() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Curso> getCursam() {
        return cursam;
    }

    public void setCursam(List<Curso> cursam) {
        this.cursam = cursam;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }
    
    
}

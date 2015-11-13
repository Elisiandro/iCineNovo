package br.com.elisiandro.iCine.entidade;

import br.com.elisiandro.iCine.entidade.Enum.GENERO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Elisiandro
 */


@Table(name="t_filme")
@Entity
public class Filme implements Serializable {
    
    ///
    /// Atributos
    ///
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    @Column(length = 50)
    private String nome;

    @Enumerated(EnumType.STRING)
    private GENERO genero;

    @Column(length = 200)
    private String sinopse;

    
    ///
    /// Construtor
    ///
    public Filme()
    {
    }

    public Filme(String nome, GENERO genero, String sinopse) {
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
    }
    
    
    ///
    /// get e set
    ///
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GENERO getGenero() {
        return genero;
    }

    public void setGenero(GENERO genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    
    
}

package br.com.elisiandro.iCine.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Elisiandro
 */


@Table(name="t_secao")
@Entity
public class Secao implements Serializable {
    
    ///
    /// Atributos
    ///
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private Sala sala;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private Filme filme;
    
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    
    ///
    /// Construtor
    ///
    public Secao()
    {
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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    
}

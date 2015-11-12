package br.com.elisiandro.iCine.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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


@Table(name="t_usu")
@Entity
public class Usuario implements Serializable {
    
    ///
    /// Atributos
    ///
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String sobrenome;
    @Column(length = 50)
    private String usuario;
    @Column(length = 50)
    private String senha;
    @Column(length = 100)
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;
    
    @Enumerated(EnumType.ORDINAL)
    private Enum.PERFIL_GRUPO perfil;
    
    ///
    /// Construtor
    ///
    public Usuario()
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Enum.PERFIL_GRUPO getPerfil() {
        return perfil;
    }

    public void setPerfil(Enum.PERFIL_GRUPO perfil) {
        this.perfil = perfil;
    }
    
    
}

package br.com.elisiandro.iCine.bean;

import br.com.elisiandro.iCine.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Elisiandro
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginMB implements Serializable{
    
    
    private String login, senha;
    private Usuario usuarioLogado;
    
    public String envia() {
        
        UsuarioMB usuarioBean = new UsuarioMB();
        Usuario usuarioLocalLogin = new Usuario();        
        usuarioLocalLogin = usuarioBean.getUsuarioLogin(login, senha);
        //FacesContext contexto = FacesContext.getCurrentInstance();
                
        //usuarioLocalLogin.getUsuario
                
        if (usuarioLocalLogin == null)
        {
            FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));            
            //FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro no Login!", "Usuário/Senha Incorreto"));
            //contexto.addMessage("messages", mensagem);        
            usuarioBean = null;
            usuarioLocalLogin = null;
            return null;
        }
        if (!usuarioLocalLogin.getSenha().equals(senha))
        {
            FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));                        
            //FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inválido!", "Usuário ou senha estão errados!");
            //contexto.addMessage("messages", mensagem);
            usuarioBean = null;
            usuarioLocalLogin = null;
            
            return null;
        }
        
        //usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
        //if (usuario == null) {
        //    usuario = new Usuario();
        //    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
        //    return null;
        //} else {
        //    return "/main";
        //}
        
        return "/home.xhtml?faces-redirect=true";
    }


    
    public String verificaLogin() {
        //Pega o contexto do JSF - serve agora e depois para mensagem.
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Obtém o usuarioMB criado pelo servidor (nível de aplicação)
        //UsuarioBean usuarioMB = (UsuarioBean) contexto.getExternalContext().getApplicationMap().get("usuarioBean");
        //A partir do usuarioMB do servidor, pegamos a lista de usuários cadastrados no sistema
        
        UsuarioMB usuMB = new UsuarioMB();
        
        
        System.out.println("Antes");
        //List<Usuario> listaUsuarios = (List<Usuario>) usuarioMB.getListaUsuarios();
        System.out.println("Depois");
        
        System.out.println("Tetse");
        System.out.println("login: " + login + " senha: " + senha);
        
        
        //Usuario usuarioLocalLogin = usuarioMB.getUsuarioLogin(login);
        /*
        if (usuarioLocalLogin == null)
        {
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inválido!", "Usuário ou senha estão errados!");
            contexto.addMessage("idMensagem", mensagem);        
            return ("");
        }
        if (!usuarioLocalLogin.getSenha().equals(senha))
        {
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inválido!", "Usuário ou senha estão errados!");
            contexto.addMessage("idMensagem", mensagem);
            return ("");
        }
        */
        return ("");
        //return "/home.xhtml?faces-redirect=true";
    }
    
    public String realizaLogout() {        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuarioLogado = null;        
        return ("/index?faces-redirect=true");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    
    
}


/*


package br.com.elisiandro.iCine.bean;

import br.com.elisiandro.iCine.entidade.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;



@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable{
    
    
    private String login, senha;
    private Usuario usuarioLogado;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean estaLogado() {
        return (usuarioLogado != null);
    }

    public boolean eAdmin() {
        return (this.estaLogado() && this.getUsuarioLogado().isAdmin());
    }

    public String verificaLogin() {
        //Pega o contexto do JSF - serve agora e depois para mensagem.
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Obtém o usuarioMB criado pelo servidor (nível de aplicação)
        UsuarioMB usuarioMB = (UsuarioMB) contexto.getExternalContext().getApplicationMap().get("usuarioMB");
        //A partir do usuarioMB do servidor, pegamos a lista de usuários cadastrados no sistema
        List<Usuario> listaUsuarios = usuarioMB.getListaUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.verificaLogin(login, senha)) {
                usuarioLogado = usuario;
                
                return "view/home.xhtml?faces-redirect=true";
            }
        }
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inválido!", "Usuário ou senha estão errados!");
        contexto.addMessage("idMensagem", mensagem);
        return ("");
        
    }

    public String realizaLogout() {
        usuarioLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ("/login?faces-redirect=true");
    }
    
}


 */

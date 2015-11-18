package br.com.elisiandro.iCine.bean;

import br.com.elisiandro.iCine.dao.InterfaceCrud;
import br.com.elisiandro.iCine.dao.UsuarioDao;
import br.com.elisiandro.iCine.entidade.Usuario;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Elisiandro
 */
@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioMB implements Serializable{
    private Usuario usuario;
    private DataModel listaUsuarios;

    public UsuarioMB()
    {
        
    }
    
    public Usuario getUsuario() {
        if (this.usuario == null)
            this.usuario = new Usuario();
        
        return this.usuario;
    }

    ///
    /// Busca usuario
    ///    
    public Usuario getUsuarioLogin(String usu, String senha) {                
        
        //UsuarioDao dao = new UsuarioDao();
        //return dao.getItem(usu);
        
        UsuarioDao dao = new UsuarioDao();
        return dao.getUsuario(usu, senha);
        
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setListaUsuarios(DataModel listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public DataModel getListaUsuarios() {
        List<Usuario> lista = new UsuarioDao().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public void prepararAdicionarUsuario(ActionEvent actionEvent) {
        usuario = new Usuario();
    }
    public void prepararAlterarUsuario(ActionEvent actionEvent) {
        usuario = (Usuario)(listaUsuarios.getRowData());
    }
    
    public void adicionar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new UsuarioDao();
        dao.salvar(usuario);
        usuario = new Usuario();
    }
    public void alterar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new UsuarioDao();
        dao.atualizar(usuario);
        usuario = new Usuario();
    }
    
    public String excluir()
    {
        Usuario usu = (Usuario)(listaUsuarios.getRowData());
        InterfaceCrud dao = new UsuarioDao();
        dao.remover(usu);
        return "usuario";
    }
}

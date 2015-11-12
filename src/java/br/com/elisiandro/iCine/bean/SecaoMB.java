package br.com.elisiandro.iCine.bean;

import br.com.elisiandro.iCine.dao.InterfaceCrud;
import br.com.elisiandro.iCine.dao.SecaoDao;
import br.com.elisiandro.iCine.entidade.Secao;
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
@ManagedBean(name="secaoBean")
@RequestScoped
public class SecaoMB implements Serializable{
    private Secao secao;
    private DataModel listaSecaos;

    public SecaoMB()
    {
        
    }
    
    public Secao getSecao() {
        if (this.secao == null)
            this.secao = new Secao();
        
        return this.secao;
    }

    ///
    /// Busca secao
    ///    
    public void setSecao(Secao secao) {
        this.secao = secao;
    }
    
    public DataModel getListaSecaos() {
        List<Secao> lista = new SecaoDao().list();
        listaSecaos = new ListDataModel(lista);
        return listaSecaos;
    }

    public void prepararAdicionarSecao(ActionEvent actionEvent) {
        secao = new Secao();
    }
    public void prepararAlterarSecao(ActionEvent actionEvent) {
        secao = (Secao)(listaSecaos.getRowData());
    }
    
    public void adicionar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new SecaoDao();
        dao.salvar(secao);
        secao = new Secao();
    }
    public void alterar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new SecaoDao();
        dao.atualizar(secao);
        secao = new Secao();
    }
    
    public String excluir()
    {
        Secao usu = (Secao)(listaSecaos.getRowData());
        InterfaceCrud dao = new SecaoDao();
        dao.remover(usu);
        return "secao";
    }
}

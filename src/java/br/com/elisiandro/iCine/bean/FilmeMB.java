package br.com.elisiandro.iCine.bean;

import br.com.elisiandro.iCine.dao.InterfaceCrud;
import br.com.elisiandro.iCine.dao.FilmeDao;
import br.com.elisiandro.iCine.entidade.Filme;
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
@ManagedBean(name="filmeBean")
@RequestScoped
public class FilmeMB implements Serializable{
    private Filme filme;
    private DataModel listaFilmes;

    public FilmeMB()
    {
        
    }
    
    public Filme getFilme() {
        if (this.filme == null)
            this.filme = new Filme();
        
        return this.filme;
    }

    ///
    /// Busca filme
    ///    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public DataModel getListaFilmes() {
        List<Filme> lista = new FilmeDao().list();
        listaFilmes = new ListDataModel(lista);
        return listaFilmes;
    }

    public void prepararAdicionarFilme(ActionEvent actionEvent) {
        filme = new Filme();
    }
    public void prepararAlterarFilme(ActionEvent actionEvent) {
        filme = (Filme)(listaFilmes.getRowData());
    }
    
    public void adicionar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new FilmeDao();
        dao.salvar(filme);
        filme = new Filme();
    }
    public void alterar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new FilmeDao();
        dao.atualizar(filme);
        filme = new Filme();
    }
    
    public String excluir()
    {
        Filme usu = (Filme)(listaFilmes.getRowData());
        InterfaceCrud dao = new FilmeDao();
        dao.remover(usu);
        return "filme";
    }
}
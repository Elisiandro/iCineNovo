package br.com.elisiandro.iCine.bean;

import br.com.elisiandro.iCine.dao.InterfaceCrud;
import br.com.elisiandro.iCine.dao.SalaDao;
import br.com.elisiandro.iCine.entidade.Sala;
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
@ManagedBean(name="salaBean")
@RequestScoped
public class SalaMB implements Serializable{
    private Sala sala;
    private DataModel listaSalas;

    public SalaMB()
    {
        
    }
    
    public Sala getSala() {
        if (this.sala == null)
            this.sala = new Sala();
        
        return this.sala;
    }

    ///
    /// Busca sala
    ///    
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public DataModel getListaSalas() {
        List<Sala> lista = new SalaDao().list();
        listaSalas = new ListDataModel(lista);
        return listaSalas;
    }

    public void prepararAdicionarSala(ActionEvent actionEvent) {
        sala = new Sala();
    }
    public void prepararAlterarSala(ActionEvent actionEvent) {
        sala = (Sala)(listaSalas.getRowData());
    }
    
    public void adicionar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new SalaDao();
        dao.salvar(sala);
        sala = new Sala();
    }
    public void alterar(ActionEvent actionEvent)
    {
        InterfaceCrud dao = new SalaDao();
        dao.atualizar(sala);
        sala = new Sala();
    }
    
    public String excluir()
    {
        Sala usu = (Sala)(listaSalas.getRowData());
        InterfaceCrud dao = new SalaDao();
        dao.remover(usu);
        return "sala";
    }
}

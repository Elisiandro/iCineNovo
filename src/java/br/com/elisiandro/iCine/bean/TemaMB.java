package br.com.elisiandro.iCine.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
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
@ManagedBean(name = "themaBean")
@ApplicationScoped
public class TemaMB implements Serializable{

    private String layout;
    private List<String> lista;

    public TemaMB() {
        this.layout = "afternoon";

        lista = new ArrayList<>();
        lista.add("afterdark");
        lista.add("afternoon");
        lista.add("afterwork");
        lista.add("aristo");
        lista.add("black-tie");
        lista.add("blitzer");
        lista.add("bluesky");
        lista.add("bootstrap");
        lista.add("casablanca");
        lista.add("cupertino");
        lista.add("cruze");
        lista.add("dark-hive");
        lista.add("delta");
        lista.add("dot-luv");
        lista.add("eggplant");
        lista.add("excite-bike");
        lista.add("flick");
        lista.add("glass-x");
        lista.add("home");
        lista.add("hot-sneaks");
        lista.add("humanity");
        lista.add("le-frog");
        lista.add("midnight");
        lista.add("mint-choc");
        lista.add("overcast");
        lista.add("pepper-grinder");
        lista.add("redmond");
        lista.add("rocket");
        lista.add("sam");
        lista.add("smoothness");
        lista.add("south-street");
        lista.add("start");
        lista.add("sunny");
        lista.add("swanky-purse");
        lista.add("trontastic");
        lista.add("ui-darkness");
        lista.add("ui-lightness");
        lista.add("vader");

    }

    public String refresh() {
        FacesContext context = FacesContext.getCurrentInstance();

        System.out.println("->  " + this.layout);

        return context.getViewRoot().getViewId() + "?faces-redirect=true";

    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}

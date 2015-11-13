package br.com.elisiandro.iCine.dao;

import br.com.elisiandro.iCine.entidade.Usuario;
import br.com.elisiandro.iCine.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Elisiandro
 */
public class UsuarioDao implements InterfaceCrud<Usuario>{

    @Override
    public Usuario getItem(Long id) {
        
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = (Usuario) ss.load(Usuario.class, id);
        return usuario;
        
    }
    
    public Usuario getUsuario(String pUsuario, String pSenha) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        
        List<Usuario> list;
        
        list = ss.createQuery("SELECT u from Usuario u where u.usuario = :name and u.senha = :senha")
                .setParameter("name", pUsuario)
                .setParameter("senha", pSenha).list();
                    
        Usuario usuario;
        for (Usuario item : list) {
            usuario = item;
            return usuario;
        }
    
        return null;
        
    }



    public Usuario getItem(String usu)
    {        
        Session ss = HibernateUtil.getSessionFactory().openSession();        
        ss.beginTransaction(); 
        List retorno = ss.createSQLQuery("select * from t_usu where usuario='"+usu+"'").list();
        Usuario usuario = null;
        
        System.out.println("sssssss " + usu);
        
        if (retorno != null || retorno.size() > 0 )
        {   
            Object primeiraLinha = retorno.get(0);
            usuario = (Usuario) primeiraLinha;
        }
        
        ss.getTransaction().commit(); 
        ss.close();
        
        return usuario;
    }
    
    @Override
    public void salvar(Usuario usuario) {        
        Session ss = HibernateUtil.getSessionFactory().openSession();  
        Transaction t = ss.beginTransaction();  
        ss.save(usuario);  
        t.commit();  
        ss.close();
    }

    @Override
    public void remover(Usuario usuario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.delete(usuario);
        t.commit();
        ss.close();

    }

    @Override
    public void atualizar(Usuario usuario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.update(usuario);
        t.commit();
        ss.close();

    }

    @Override
    public List<Usuario> list() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        List lista;
        lista = ss.createQuery("from Usuario").list();
        t.commit();
        ss.close();
        
        return lista;
    }
    
}

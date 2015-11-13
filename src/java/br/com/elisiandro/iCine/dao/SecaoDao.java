package br.com.elisiandro.iCine.dao;

import br.com.elisiandro.iCine.entidade.Secao;
import br.com.elisiandro.iCine.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Elisiandro
 */
public class SecaoDao implements InterfaceCrud<Secao>{

    @Override
    public Secao getItem(Long id) {
        
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Secao secao =(Secao) ss.load(Secao.class, id);        
        ss.close();
                
        return secao;
    }

    public Secao getItem(String usu)
    {        
        Session ss = HibernateUtil.getSessionFactory().openSession();        
        ss.beginTransaction(); 
        List retorno = ss.createSQLQuery("select * from t_usu where secao='"+usu+"'").list();
        Secao secao = null;
        
        System.out.println("sssssss " + usu);
        
        if (retorno != null || retorno.size() > 0 )
        {   
            Object primeiraLinha = retorno.get(0);
            secao = (Secao) primeiraLinha;
        }
        
        ss.getTransaction().commit(); 
        ss.close();
        
        return secao;
    }
    
    @Override
    public void salvar(Secao secao) {        
        Session ss = HibernateUtil.getSessionFactory().openSession();  
        Transaction t = ss.beginTransaction();  
        ss.save(secao);  
        t.commit();  
        ss.close();
    }

    @Override
    public void remover(Secao secao) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.delete(secao);
        t.commit();
        ss.close();

    }

    @Override
    public void atualizar(Secao secao) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.update(secao);
        t.commit();
        ss.close();

    }

    @Override
    public List<Secao> list() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        List lista;
        lista = ss.createQuery("from Secao").list();
        t.commit();
        
        return lista;
    }
    
}

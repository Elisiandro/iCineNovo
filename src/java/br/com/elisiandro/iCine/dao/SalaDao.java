/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.elisiandro.iCine.dao;

import br.com.elisiandro.iCine.entidade.Sala;
import br.com.elisiandro.iCine.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Elisiandro
 */
public class SalaDao implements InterfaceCrud<Sala>{

    
    @Override
    public Sala getItem(Long id) {
        
        Session ss = HibernateUtil.getSessionFactory().openSession();
        return (Sala) ss.load(Sala.class, id);        
    }

    @Override
    public void salvar(Sala sala) {        
        Session ss = HibernateUtil.getSessionFactory().openSession();  
        Transaction t = ss.beginTransaction();  
        ss.save(sala);  
        t.commit();  
        ss.close();
    }

    @Override
    public void remover(Sala sala) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.delete(sala);
        t.commit();
        ss.close();

    }

    @Override
    public void atualizar(Sala sala) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.update(sala);
        t.commit();
        ss.close();

    }

    @Override
    public List<Sala> list() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        List lista;
        lista = ss.createQuery("from Sala").list();
        t.commit();
        
        return lista;
    }
}

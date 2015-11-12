/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.elisiandro.iCine.dao;

import br.com.elisiandro.iCine.entidade.Filme;
import br.com.elisiandro.iCine.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Elisiandro
 */
public class FilmeDao implements InterfaceCrud<Filme>{

    
    @Override
    public Filme getItem(Long id) {
        
        Session ss = HibernateUtil.getSessionFactory().openSession();
        return (Filme) ss.load(Filme.class, id);        
    }

    @Override
    public void salvar(Filme filme) {        
        Session ss = HibernateUtil.getSessionFactory().openSession();  
        Transaction t = ss.beginTransaction();  
        ss.save(filme);  
        t.commit();  
        ss.close();
    }

    @Override
    public void remover(Filme filme) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.delete(filme);
        t.commit();
        ss.close();

    }

    @Override
    public void atualizar(Filme filme) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        ss.update(filme);
        t.commit();
        ss.close();

    }

    @Override
    public List<Filme> list() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();  
        List lista;
        lista = ss.createQuery("from Filme").list();
        t.commit();
        
        return lista;
    }
}

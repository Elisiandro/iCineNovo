/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.elisiandro.iCine.app;

import br.com.elisiandro.iCine.entidade.Enum.GENERO;
import br.com.elisiandro.iCine.entidade.Filme;
import br.com.elisiandro.iCine.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author New
 */
public class Principal {
    public static void main(String[] args) {
        
//        List<Filme> lista = new ArrayList<>();
//        
//        lista.add(new Filme("Caligula", GENERO.PORNO, "Filme muito antigo de putaria"));
//        lista.add(new Filme("Os Vingadores", GENERO.ACAO, "Filme sobre personagens em quadrinhos"));
//        lista.add(new Filme("Os Pioneiros", GENERO.AVENTURA, "Filme de epoca no foroeste"));
//        lista.add(new Filme("Matador em Conflito", GENERO.COMEDIA, "Filme de acao cujo um assassino profissional fica em duvida com o seu amor."));
//        lista.add(new Filme("Madagascar", GENERO.ANIMACAO, "Filme infantil de animais."));
//        
//        Session ss = HibernateUtil.getSessionFactory().openSession();  
//        Transaction t = ss.beginTransaction();  
//        for (Filme filme : lista) {
//            ss.save(filme);
//        }
//        
//        t.commit();  
//        ss.close();
//        
        
        List<Filme> lista = new ArrayList<>();
        
        lista.add(new Filme("Poeira em alto mar", GENERO.ACAO, "Filme muito antigo de mar"));
        
        Session ss = HibernateUtil.getSessionFactory().openSession();  
        Transaction t = ss.beginTransaction();  
        for (Filme filme : lista) {
            ss.save(filme);
        }
        
        t.commit();  
        ss.close();
        
        
        
    }
    
}

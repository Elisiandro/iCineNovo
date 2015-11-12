/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.elisiandro.iCine.entidade;

/**
 *
 * @author Elisiandro
 */
public class Enum {
    public enum PERFIL_GRUPO {
        ADMIN(1),
        GERENTE_VENDA(2), 
        VENDEDOR(3),
        FINANCEIRO(4);
        
        
        private final int valor;
        PERFIL_GRUPO(int valorOpcao) {
            valor = valorOpcao;
        }
        public int getValor() {
            return valor;
        }
    }
    
    public enum GENERO{
        ACAO(0),
        ANIMACAO(1),
        AVENTURA(2),
        COMEDIA(3),
        DOCUMENTARIO(4),
        DRAMA(5),
        MUSICAL(6),
        ROMANCE(7),
        Romance(8),
        SUSPENSE(9),
        TERROR(10),
        PORNO(11);
        
        private final int valor;
        GENERO(int valorOpcao) {
            valor = valorOpcao;
        }
        public int getValor() {
            return valor;
        }
    }
    
    
}


package br.com.elisiandro.iCine.dao;

import java.util.List;

/**
 *
 * @author Elisiandro
 * @param <T>
 */
public interface InterfaceCrud<T> {
    public T getItem(Long id);
    public void salvar(T model);
    public void remover(T model);
    public void atualizar(T model);
    public List<T> list();
}

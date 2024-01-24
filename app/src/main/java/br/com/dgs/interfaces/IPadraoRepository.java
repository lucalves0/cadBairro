package br.com.dgs.interfaces;

import java.util.ArrayList;

public interface IPadraoRepository {
    void inserir(Object o);
    void alterar (Object o);
    void remover (Object o);
    public ArrayList getAll();
    public Object getById(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author CristhianFriasJaldin
 */

public class GestorVacunas {
    private ArrayList<Vacunados> lista;

public GestorVacunas(){
    lista=new ArrayList<Vacunados>();
}

    public ArrayList<Vacunados> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Vacunados> lista) {
        this.lista = lista;
    }
    
    public void insertVacunado(Vacunados item){
        lista.add(item);
    }
    public void modificarVacunado(int pos, Vacunados item){
        lista.set(pos, item);
    }
    public void eliminarVacunado(int pos){
        lista.remove(pos);
    }
    public int obtieneId()
    {
        int idaux=0;
        for(Vacunados item : lista){
            idaux=item.getId();
        }
        return idaux+1;
    }
    
    public int ubicarVacunado(int id){
        int pos=-1;
        Iterator<Vacunados> it=lista.iterator();
        while(it.hasNext()){
            ++pos;
            Vacunados aux=it.next();
            if(aux.getId()==id){
                break;
            }
        }
        return pos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author hca
 */
public interface ConjuntoADT <T> {
    public int cardinalidad();
    public boolean vacio();
    public boolean esElemento(T obj);
    public boolean agrega(T obj);
    public boolean quita(T obj);
    public boolean equals(Object obj);
    public boolean subconjunto(Object obj);
    public Object union(Object obj);
    public Object interseccion(Object obj);
    public Object diferencia(Object obj);
}

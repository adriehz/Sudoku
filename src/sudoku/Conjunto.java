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
public class Conjunto <T> implements ConjuntoADT<T>{
    private int DIM, n;
    private T vec[];
    
    Conjunto(){
        DIM = 9;
        n=0;
        vec=(T[]) new Comparable[DIM];
    }
    public int cardinalidad(){
        return n;
    }
    public boolean vacio(){
        return n==0;
    }
    public boolean esElemento(T obj){
        boolean resp=true;
        int i;
        i=0;
        if(n==0)
            resp=false;
        else{
        while(!vec[i].equals(obj) && i<n-1)
            i=i+1;
        if(!vec[i].equals(obj))
            resp=false;
        }
        return resp;
    }
    /*public boolean agrega(T obj){
        boolean resp;
        if(n==DIM)
            resp=false;
        else
            if(n>0 && esElemento(obj))
                resp=false;
            else{
                resp=true;
                vec[n]=obj;
                n=n+1;
            }
        return resp;
    }*/
    public boolean agrega(T obj){
        boolean resp;
        resp= esElemento(obj);
        if(n==DIM)
            resp=false;
        else
            if(n>0 && esElemento(obj))
                resp=false;
            else{
                resp=true;
                vec[n]=obj;
                n=n+1;
            }
        return resp;
    }
    public boolean quita(T obj){
        boolean resp;
        int i;
        i=0;
        while(i<n-1 && !vec[i].equals(obj))
            i=i+1;
        if(vec[i].equals(obj)){
          resp=true;
          vec[i]=vec[n-1];
          n=n-1;
        }
        else
          resp=false;
        return resp;
    }
    public boolean equals(Object obj){
        Conjunto aux;
        int i;
        boolean resp;
        aux=(Conjunto)obj;
        if(n==aux.n){
            i=0;
            while(i<n-1 && aux.esElemento(vec[i]))
                i=i+1;
            resp=aux.esElemento(vec[i]);
        }
        else
            resp=false;
        return resp;
    }
    public boolean subconjunto(Object obj){
        Conjunto aux;
        boolean resp;
        int i;
        aux = (Conjunto)obj;
        if(n > aux.n)
            resp=false;
        else{
            i=0;
            while(i<aux.n-1  && aux.esElemento(vec[i]))
                i=i+1;
            resp = aux.esElemento(vec[i]);
        }
        return resp;
    }
    public Object union(Object obj){
        Conjunto<T> resp, aux;
        int i;
        aux= (Conjunto)obj;
        resp= new Conjunto();
        for(i=0; i< n; i++)
            resp.agrega(vec[i]);
        //Copiar objeto visitante (aux) en resp
        for(i=0;i<aux.n; i++)
            resp.agrega(aux.vec[i]);
        return resp;
    }
    public Object interseccion(Object obj){
        Conjunto<T> aux, resp;
        int i;
        aux=(Conjunto)obj;
        resp= new Conjunto();
        if(n < aux.n)
            for(i=0;i<n; i++)
                if(aux.esElemento(vec[i]))
                    resp.agrega(vec[i]);
        else
              for(i=0;i<aux.n; i++)
                if(this.esElemento(aux.vec[i]))
                    resp.agrega(aux.vec[i]);
        return resp;
    }
    public Object diferencia(Object obj){
        Conjunto<T> aux, resp;
        int i;
        aux=(Conjunto)obj;
        resp= new Conjunto();
        for(i=0;i < n; i++)
             if(!aux.esElemento(vec[i]))
                 resp.agrega(vec[i]);
        return resp;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.*;
import java.io.*;

/**
 *
 * @author LSITOMPU
 */
public class Sudoku1 {
     private Conjunto [] renglones, columnas, zonas;
     private Integer[][] sudo, aux;
     private Integer [][] mat;
    
    Sudoku1() 
    {
        renglones= new Conjunto [9];
        columnas= new Conjunto [9];
        zonas= new Conjunto [9];
        sudo= new Integer [9][9];
        aux= new Integer [9][9];
        mat=new Integer[9][9];
    }
    
    public void toString(int[][] sudo)
    {
        
    }
    
    public boolean llena(Integer [][] mat)  //metodo que llena los conjuntos con los valores correspondientes de cada casilla de la matriz atributo
    {    
        Conjunto <Integer> con0, con1, con2, con3, con4, con5, con6, con7, con8, con9, con10, con11, con12, con13, con14, con15, con16, con17, con18, con19, con20, con21, con22, con23, con24, con25, con26;
        int ren,col,i,j;
        boolean res; //respuesta es inicializada en true para no interrurmpir el proceso
        res=true;
        ren=9;
        col=9;
        con0= new Conjunto(); //intancio 27 conjuntos
        con1= new Conjunto();
        con2= new Conjunto();
        con3= new Conjunto();
        con4= new Conjunto();
        con5= new Conjunto();
        con6= new Conjunto();
        con7= new Conjunto();
        con8= new Conjunto();
        con9= new Conjunto();
        con10= new Conjunto();
        con11= new Conjunto();
        con12= new Conjunto();
        con13= new Conjunto();
        con14= new Conjunto();
        con15= new Conjunto();
        con16= new Conjunto();
        con17= new Conjunto();
        con18= new Conjunto();
        con19= new Conjunto();
        con20= new Conjunto();
        con21= new Conjunto();
        con22= new Conjunto();
        con23= new Conjunto();
        con24= new Conjunto();
        con25= new Conjunto();
        con26= new Conjunto();
        for(i=0; i<9; i++)  //guardo los valores en sudo y aux
            for(j=0; j<9; j++) 
            {
                sudo[i][j]=mat[i][j];
                aux[i][j]=mat[i][j];  
            }
        
        return llena(mat, con0, con1, con2, con3, con4, con5, con6, con7, con8, con9, con10, con11, con12, con13, con14, con15, con16, con17, con18, con19, con20, con21, con22, con23, con24, con25, con26, ren-1, col-1, res); //llamada recursiva
    }
    
    private boolean llena(Integer [][] mat, Conjunto <Integer> con0, Conjunto <Integer> con1, Conjunto <Integer> con2, Conjunto <Integer> con3, Conjunto <Integer> con4, Conjunto <Integer> con5, Conjunto <Integer> con6, Conjunto <Integer> con7, Conjunto <Integer> con8, Conjunto <Integer> con9, Conjunto <Integer> con10, Conjunto <Integer> con11, Conjunto <Integer> con12, Conjunto <Integer> con13, Conjunto <Integer> con14, Conjunto <Integer> con15, Conjunto <Integer> con16, Conjunto <Integer> con17, Conjunto <Integer> con18, Conjunto <Integer> con19, Conjunto <Integer> con20, Conjunto <Integer> con21, Conjunto <Integer> con22, Conjunto <Integer> con23, Conjunto <Integer> con24, Conjunto <Integer> con25, Conjunto <Integer> con26, int ren, int col, boolean res) {
        if(ren<0)  //estado base verdadero
        {    
            zonas[0]= con0;
            zonas[1]= con1;
            zonas[2]= con2;
            zonas[3]= con3;
            zonas[4]= con4;
            zonas[5]= con5;
            zonas[6]= con6;
            zonas[7]= con7;
            zonas[8]= con8;
            renglones[0]= con9;
            renglones[1]= con10;
            renglones[2]= con11;
            renglones[3]= con12;
            renglones[4]= con13;
            renglones[5]= con14;
            renglones[6]= con15;
            renglones[7]= con16;
            renglones[8]= con17;
            columnas[0]= con18;
            columnas[1]= con19;
            columnas[2]= con20;
            columnas[3]= con21;
            columnas[4]= con22;
            columnas[5]= con23;
            columnas[6]= con24;
            columnas[7]= con25;
            columnas[8]= con26;
            return true; 
        }
        else 
        {
            if(!res) //estado base falso
                return false;
            else 
            {
                if(col<0) //cambio de renglón
                { 
                    ren=ren-1;
                    col= 8;
                    return llena(mat, con0, con1, con2, con3, con4, con5, con6, con7, con8, con9, con10, con11, con12, con13, con14, con15, con16, con17, con18, con19, con20, con21, con22, con23, con24, con25, con26, ren, col, res);
                }
                else 
                {
                    if(mat[ren][col]!= 0) // si es diferente de cero lo debo guardar en mis conjuntos
                    {
                        if(mat[ren][col]>=1  && mat[ren][col]<=9) 
                        {
                            switch(this.getZona(ren, col)) //switch que determina a que conjunto agregar el valor dependiendo de la zona
                            {    
                                case(0): 
                                    res= con0.agrega(mat[ren][col]);
                                    break;
                                case(1): 
                                    res= con1.agrega(mat[ren][col]);
                                    break;
                                case(2): 
                                    res= con2.agrega(mat[ren][col]);
                                    break;
                                case(3): 
                                    res= con3.agrega(mat[ren][col]);
                                    break;
                                case(4): 
                                    res= con4.agrega(mat[ren][col]);
                                    break;
                                case(5): 
                                    res= con5.agrega(mat[ren][col]);
                                    break;
                                case(6): 
                                    res= con6.agrega(mat[ren][col]);
                                    break;
                                case(7): 
                                    res= con7.agrega(mat[ren][col]);
                                    break;
                                case(8): 
                                    res= con8.agrega(mat[ren][col]);
                                    break;
                            }
                            if(res) 
                            {
                                switch(ren)  //switch que determina a que conjunto agregar el valor dependiendo de la zona
                                {   
                                    case(0): 
                                        res= con9.agrega(mat[ren][col]);
                                        break;
                                    case(1): 
                                        res= con10.agrega(mat[ren][col]);
                                        break;
                                    case(2): 
                                        res= con11.agrega(mat[ren][col]);
                                        break;
                                    case(3): 
                                        res= con12.agrega(mat[ren][col]);
                                        break;
                                    case(4): 
                                        res= con13.agrega(mat[ren][col]);
                                        break;
                                    case(5): 
                                        res= con14.agrega(mat[ren][col]);
                                        break;
                                    case(6): 
                                        res= con15.agrega(mat[ren][col]);
                                        break;
                                    case(7): 
                                        res= con16.agrega(mat[ren][col]);
                                        break;
                                    case(8): 
                                        res= con17.agrega(mat[ren][col]);
                                        break;
                                }
                                if(res) 
                                {
                                    switch(col)  //switch que determina a que conjunto agregar el valor dependiendo de la zona
                                    {    
                                        case(0): 
                                            res= con18.agrega(mat[ren][col]);
                                            break;
                                        case(1): 
                                            res= con19.agrega(mat[ren][col]);
                                            break;
                                        case(2): 
                                            res= con20.agrega(mat[ren][col]);
                                            break;
                                        case(3): 
                                            res= con21.agrega(mat[ren][col]);
                                            break;
                                        case(4): 
                                            res= con22.agrega(mat[ren][col]);
                                            break;
                                        case(5): 
                                            res= con23.agrega(mat[ren][col]);
                                            break;
                                        case(6): 
                                            res= con24.agrega(mat[ren][col]);
                                            break;
                                        case(7): 
                                            res= con25.agrega(mat[ren][col]);
                                            break;
                                        case(8): 
                                            res= con26.agrega(mat[ren][col]);
                                            break;
                                    }
                                }
                            }
                        }
                        else 
                        {
                            return false; //el número no se encuentra entre 1 y 9
                        }
                    }
                    return llena(mat, con0, con1, con2, con3, con4, con5, con6, con7, con8, con9, con10, con11, con12, con13, con14, con15, con16, con17, con18, con19, con20, con21, con22, con23, con24, con25, con26, ren, col-1, res); //llamda recursiva
                }
            }
        }
        
    }
    private int getZona(int ren, int col)  //metodo que regresa la zona correspondiente a una pocision (ren, col)
    {    
        int res;
        if(col<3) 
            if(ren<3) 
                res= 0;
            else 
                if(ren<6) 
                    res= 3;
                else 
                    res= 6;
        else 
            if(col<6) 
                if(ren<3) 
                    res= 1;
                else 
                    if(ren<6) 
                        res= 4;
                    else 
                        res= 7;
            else 
                if(ren<3) 
                    res= 2;
                else 
                    if(ren<6)
                        res= 5;
                    else 
                        res= 8;
        return res;
    } 
    
    public boolean ir() //metodo que resuelve el sudoku
    {   
        int ren, col;
        ren= 9; //tamaño de la matriz
        col= 9;
        return ir(ren-1, col-1); //llamada recursiva
    }
     
    private boolean ir(int ren, int col) 
    {
        boolean band;
        if(ren<0)  //estado base verdadero
            return true;
        else 
            if(col<0)  //cambio de renglón
            {    
                ren=ren-1;
                col= 8;
                return ir(ren, col);
            }
            else 
            {
                if(aux[ren][col]==0)  //espacio modificable
                {    
                    band= this.intenta(ren, col, 1); //determina si intenta fue exitosa
                    if(!band)  //debo regresar a encontrar otra solucion  
                        return regresa(ren, col+1); //regresa a corregir
                }
                return ir(ren, col-1); //llamada recursiva siguiente casilla
            }
    }
      private boolean intenta(int ren, int col, int i) { //metodo que intenta agregar un numero
        if(i==10)  //estado base falso, intento del 1 al 9
            return false;
        else 
            if(!this.pertenece(ren, col, i))  //determina si un numero no pertence a alguno de los conjuntos relacionados con una pocision (ren, col)
            {    
                aux[ren][col]=i; //agrega el numero a la matriz
                renglones[ren].agrega(i); //agrega al conjunto de ese renglón
                columnas[col].agrega(i); //agrega al conjunto de esa columna
                zonas[this.getZona(ren, col)].agrega(i); //agrega al conjunto de esa zona
                return true;
            }
            else
                return intenta(ren, col, i+1); //intenta con el siguiente numero
    }
    private boolean pertenece(int ren, int col, int i) //metodo que determina si un numero i pertence a alguno de los conjuntos relacionados con una pocision (ren, col)
    {    
        boolean band;
        band= renglones[ren].esElemento(i);
        band= band || columnas[col].esElemento(i);
        band= band || zonas[getZona(ren, col)].esElemento(i);
        return band; 
    }
    private boolean regresa(int ren, int col)  //metodo que perimite obtener otra posible solucion
    {   
        int i;
        if(ren==9) //estado base falso, no hay otra solucion
            return false;
        else 
            if(col==9)  //cambio de renglon
            {    
                ren=ren+1;
                col=0;
                return regresa(ren, col); 
            }
            else 
                if(sudo[ren][col]==0)  //posicion modificable
                {
                    i= aux[ren][col]; //modifico
                    renglones[ren].quita(i);
                    columnas[col].quita(i);
                    zonas[this.getZona(ren, col)].quita(i);
                    return regresa(ren, col, i); //llamda recursiva
                }
                else
                    return regresa(ren,col+1); //regreso con otra pocision
    }
    
    private boolean regresa(int ren, int col, int i) 
    {
        boolean band;
        if(ren==9)  //estado base falso
            return false;
        else 
            if(col==9)  //cambio de renglon
            {    
                ren++;
                col= 0;
                return regresa(ren, col);
            }
            else 
            {
                if(sudo[ren][col]==0)  //pocision modificable
                {    
                    band= this.intenta(ren, col, i+1); //intenta modificar
                    if(band)//lo logre
                        return ir(ren, col); //cominenzo a resolver el sudoku otra vez
                    else
                    {
                        aux[ren][col]= 0; //no lo logre, esta casilla es cero
                        return regresa(ren, col+1); //intento modificar la anterior
                    }
                }
                return regresa(ren, col+1); //intento modificar la anterior
            }
    }
       
    public Integer[][] getMat()  //regresa la matriz aux, se usa para obtener la matriz solucion
    {    
        return aux;
    }
    
    public String toStringAux() 
    {
        String cad;
        int i,j,a;
        a=1;
        cad="";
//        StringBuilder sb= new StringBuilder();
        for(i=0; i<9; i++) 
        {
            cad=cad+"\n\n";//sb.append("\n");
            for(j=0; j<9; j++) 
            {
                cad=cad+aux[i][j];//sb.append(aux[i][j]);
                if(a%3==0)
                    cad=cad+"|";
                a=a+1;
            }
        }
        return cad;
    } 
    public static int leeInfo(Integer[][] vector){
        File datos;
        Scanner lee;
        Integer a,i,j,ci,cj,cont;
        cont=0;
        datos = new File("prueba.txt");
        try
        {
            lee= new Scanner(datos);
        }
        catch(Exception e)
        {
            lee = null;
        }
        if(lee !=null)
        {
            while(lee.hasNext())
            {
                for(i=0;i<9;i++)
                {
                    for(j=0;j<9;j++)
                    {
                        a=lee.nextInt();
                        vector[i][j]=a;
                        if(a!=0)
                            cont=cont+1;
                    }
                    lee.nextLine();
                }
            }
            lee.close();
        }
        return cont;
    }
    
      public static void main(String[] args) {
          Sudoku1 s;
           Integer [][] matri,mat;
           String cad;
           int i,j,ci,cj;
           cad="";
           s= new Sudoku1();
           matri= new Integer[9][9];
           mat= new Integer[9][9];
           mat= s.getMat();
           if(leeInfo(s.getMat())<17)
               System.out.println("No tiene solucion");
           
           System.out.println("\t\tSOLUCIONES\n\n");

           for(i=0;i<9;i++)
            {
                cad=cad+"\n";
                for(j=0;j<9;j++)
                {
                    cad=cad+" "+s.aux[i][j];
                    if(((j+1)%3)==0)
                        cad=cad+"  ";
                }
                if(((i+1)%3)==0)
                    cad=cad+"\n";
                if(i==8)
                    cad=cad+"\n\n";
            }


        if(s.llena(mat))
        {
            if(s.ir())
            {
                
                matri= s.getMat();
                
            }
            else
                System.out.println("No hay solucion.");
        }
        else
              System.out.println("Sudoku mal llenado.");;
                  
        
        for(ci=0;ci<9;ci++)
        {
            cad=cad+"\n";
            for(cj=0;cj<9;cj++)
            {
                cad=cad+" "+s.aux[ci][cj];
                if(((cj+1)%3)==0)
                    cad=cad+"  ";
            }
            if(((ci+1)%3)==0)
                cad=cad+"\n";
            
        }
        System.out.println(cad);
        
        //System.out.println(s.llena(mat));
        
      } 
    }
   
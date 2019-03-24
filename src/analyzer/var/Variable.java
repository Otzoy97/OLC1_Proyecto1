/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer.var;


/**
 * 
 * @author otzoy
 */
public class Variable {
    private Object objeto;
    private Var tipo;
    private String identificador;
    private int fila, columna;
    
    public enum Var {
        ENTERO, DECIMAL, BOOLEANO, CADENA;
    }

    public Variable(Object objeto, Var tipo, String identificador, int fila, int columna) {
        this.objeto = objeto;
        this.tipo = tipo;
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public void setTipo(Var tipo) {
        this.tipo = tipo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    9
}

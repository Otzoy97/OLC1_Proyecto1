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

    public Object getObjeto() {
        return objeto;
    }

    public Var getTipo() {
        return tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }


}

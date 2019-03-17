/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer.var;

import analyzer.var.Var;

/**
 * 
 * @author otzoy
 */
public class Variable {
    private int entero;
    private double decimal;
    private boolean boleano;
    private String cadena;
    private Var tipo;
    private String identificador;
    private int fila, columna;
    
    public enum Var {
        ENTERO, DECIMAL, BOOLEANO, CADENA;
    }
    
    /**
     * Constructor para una variable de tipo entero
     * @param entero
     * @param identificador
     * @param fila
     * @param columna 
     */
    public Variable(int entero, String identificador, int fila, int columna) {
        this.entero = entero;
        this.tipo = Var.ENTERO;
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }
    /**
     * Constructor para una variable de tipo double
     * @param decimal
     * @param identificador
     * @param fila
     * @param columna 
     */
    public Variable(double decimal, String identificador,  int fila, int columna) {
        this.decimal = decimal;
        this.tipo = Var.DECIMAL;
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }
    /**
     * Constructor para una variable booleana
     * @param boleano
     * @param identificador
     * @param fila
     * @param columna 
     */
    public Variable(boolean boleano, String identificador,  int fila, int columna) {
        this.boleano = boleano;
        this.tipo = Var.BOOLEANO;
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }
    /**
     * Constructor para una variable string
     * @param cadena
     * @param identificador
     * @param fila
     * @param columna 
     */
    public Variable(String cadena, String identificador,  int fila, int columna) {
        this.cadena = cadena;
        this.tipo = Var.CADENA;
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getEntero() {
        return entero;
    }

    public double getDecimal() {
        return decimal;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean getBoleano() {
        return boleano;
    }

    public String getCadena() {
        return cadena;
    }

    public Var getTipo() {
        return tipo;
    }

    public String getIdentificador() {
        return identificador;
    }
}

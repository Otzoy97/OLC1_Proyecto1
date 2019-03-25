/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.hscript;


/**
 * 
 * @author otzoy
 */
public class Variable implements HScript {
    private Object objeto;
    private String identificador;
    private int fila, columna;
    
    public Variable(Object objeto, String identificador, int fila, int columna) {
        this.objeto = objeto;
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }

    public Object getObjeto() {
        return objeto;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getFila() {
        return fila;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public int getColumna() {
        return columna;
    }

    public Object[] getFilaInfo(){
        Object[] obj = new Object[]{this.identificador, this.objeto.getClass().getSimpleName(), this.objeto, this.fila, this.columna};
        return obj;
    }

}

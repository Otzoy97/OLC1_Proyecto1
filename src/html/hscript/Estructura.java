/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.hscript;

import html.ComponentHTML;

/**
 * Dado que HScript es un entorno de "programación" totalmente diferente al de
 * etiquetas de HTML pero también su estructura interna afecta posteriormente al
 * de etitquetas, es necesario "encolar" la serie de acciones que dentro de
 * HScript se especifica, ya que no solo se "ejecutan" funciones internas, si no
 * que tambíén se pueden ejecutar condicionales e iteraciones tales como un IF o
 * un REPETIR.
 *
 * En esta clase se guarda todo tipo de instruccion que se declare dentro de la
 * etiqueta HSCRIPT cada acción o función está especificada en las clases ENUM
 * que contiene esta clase.
 *
 * @author otzoy
 */
public class Estructura implements HScript {

    /**
     *
     */
    private String identificador;
    /**
     *
     */
    private Struct struct;
    /**
     *
     */
    private ComponentHTML componente;

    /**
     * Determina qué estructura se creará, modificará o insertará
     */
    public enum Struct {
        PARRAFO_,
        TEXTOA_,
        TEXTOB_,
        IMAGEN_,
        TABLA_,
        BOTON_
    }

    /**
     *
     * @param identificador
     * @param struct
     * @param componente
     */
    public Estructura(String identificador, ComponentHTML componente) {
        this.identificador = identificador;
        this.componente = componente;
        switch (componente.getClass().getSimpleName()) {
            case "Paragraph":
                this.struct = Struct.PARRAFO_;
                break;
            case "TextA":
                this.struct = Struct.TEXTOA_;
                break;
            case "TextB":
                this.struct = Struct.TEXTOB_;
                break;
            case "Image":
                this.struct = Struct.IMAGEN_;
                break;
            case "Table":
                this.struct = Struct.TABLA_;
                break;
            case "Button":
                this.struct = Struct.BOTON_;
                break;
        }
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    public ComponentHTML getComponente() {
        return componente;
    }

    public void setComponente(ComponentHTML componente) {
        this.componente = componente;
    }

}

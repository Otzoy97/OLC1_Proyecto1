/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer;

/**
 *
 * @author otzoy
 */
public class Token {
    private String lexema;
    private String token;
    private int columna, fila;
    
    public Token (String token, int columna, int fila, String lexema){
        this.token = token;
        this.columna = columna;
        this.fila = fila;
        this.lexema = lexema;
    }
    /**
     * Devuelve una celda HTML con la informacion almacenada del token
     * @param contador mantiene el contéo de tokens encontrados
     * @return 
     */
    public String getToken(int contador){
        StringBuilder br = new StringBuilder();
        br.append("<tr>");
        br.append("<th>").append(contador).append("</th>");
        br.append("<th>").append(this.fila).append("</th>");
        br.append("<th>").append(this.columna).append("</th>");
        br.append("<th>").append(this.lexema).append("</th>");
        br.append("<th>").append(this.token).append("</th>");
        br.append("</tr>");        
        return br.toString();
    }
}

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
        System.out.println(token + " -> " + lexema);
    }
    /**
     * Devuelve una celda HTML con la informacion almacenada del token
     * @param contador mantiene el contéo de tokens encontrados
     * @return 
     */
    public String getToken(int contador){
        StringBuilder br = new StringBuilder();
        this.lexema = this.lexema.replace("<", "&lt;");
        this.lexema= this.lexema.replace(">", "&gt;");
        br.append("<tr>");
        br.append("<td class=\"tg-baqh\" >").append(contador).append("</td>");
        br.append("<td class=\"tg-baqh\" >").append(this.fila).append("</td>");
        br.append("<td class=\"tg-baqh\" >").append(this.columna).append("</td>");
        br.append("<td class=\"tg-baqh\" >").append(this.lexema).append("</td>");
        br.append("<td class=\"tg-baqh\" >").append(this.token).append("</td>");
        br.append("</tr>");        
        return br.toString();
    }
}

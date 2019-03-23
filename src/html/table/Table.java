/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.table;

import html.ComponentHTML;
import java.util.Queue;

/**
 *
 * @author otzoy
 */
public class Table implements ComponentHTML {
    private Queue<Row> filas;
    private boolean borde;
    
    public Table(Queue<Row> filas, boolean borde) {
        this.filas = filas;
        this.borde = borde;
    }
    /**
     * Devuelve una tabla en formato HTML
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table");
        if(borde){
            sb.append(" style=\"border: 1px solid\"");
        }
        sb.append(">\n");
        while(!filas.isEmpty()){
            sb.append(filas.poll().getHtml());
        }
        sb.append("</table>\n");
        return sb.toString();
    }
    
}

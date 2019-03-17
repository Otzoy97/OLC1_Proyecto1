/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.table;
import java.util.Stack;
import html.ComponentHTML;
/**
 *
 * @author otzoy
 */
public class Row implements ComponentHTML {
    private Stack<Column> columnas;

    public Row(Stack<Column> columnas) {
        this.columnas = columnas;
    }
    /**
     * Devuelve fila en formato HTML
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>\n");
        while(!columnas.isEmpty()){
            sb.append(columnas.pop().getHtml());
        }
        sb.append("</tr>\n");
        return sb.toString();
    }
    
}

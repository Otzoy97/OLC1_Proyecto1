/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.table;
import java.util.Queue;
import html.ComponentHTML;
/**
 *
 * @author otzoy
 */
public class Row implements ComponentHTML {
    private Queue<Column> columnas;

    public Row(Queue<Column> columnas) {
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
            sb.append(columnas.poll().getHtml());
        }
        sb.append("</tr>\n");
        return sb.toString();
    }
    
}

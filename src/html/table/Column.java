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
public class Column implements ComponentHTML {
    private Queue<ComponentHTML> contenido;
    private boolean esEncabezado;
    
    public Column(Queue<ComponentHTML> contenido, boolean esEncabezado ) {
        this.contenido = contenido;
        this.esEncabezado = esEncabezado;
    }
        
    /**
     * Devuelve una columna en formato HTML
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append(esEncabezado ? "<th>" : "<td>" );
        while(!contenido.isEmpty()){
            sb.append(contenido.poll().getHtml());
        }
        sb.append(esEncabezado ? "</th>" : "</td>" ).append("\n");
        return sb.toString();
    }
    
}

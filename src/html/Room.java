/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;
import java.util.Queue;
/**
 *
 * @author otzoy
 */
public class Room implements ComponentHTML {
    private Queue<ComponentHTML> pilaHTML;
    
    public Room(Queue<ComponentHTML> pilaHTML){
        this.pilaHTML = pilaHTML;
    }
    /**
     * Devuelve un div en formato HTML con el contenido que haya sido especificado
     * @return 
     */
    @Override
    public String getHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<div>\n");
        for(ComponentHTML component : this.pilaHTML){
            String temp = component.getHtml();
            sb.append(temp);
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}

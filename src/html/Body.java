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
public class Body implements ComponentHTML {
    private Queue<ComponentHTML> cuerpoHTML;
    private String color;
    
    public Body(String color, Queue<ComponentHTML> cuerpo){
        this.cuerpoHTML = cuerpo;
        this.color = color;
    }
    
    public Body(Queue<ComponentHTML> cuerpo){
        this.cuerpoHTML = cuerpo;
    }
    /**
     * Devuelve el body en formato html
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<body");
        if (!color.isEmpty()){
            sb.append(" style=\"background-color: ").append(color).append(";\"");
        }
        sb.append(">\n");
        String temp;
        while(!cuerpoHTML.isEmpty()){
            temp = cuerpoHTML.poll().getHtml();
            sb.append(temp);
        }
        sb.append("</body>");
        return sb.toString();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;
import java.awt.Color;
import java.util.Stack;
/**
 *
 * @author otzoy
 */
public class Body implements ComponentHTML {
    private Stack<ComponentHTML> cuerpoHTML;
    private String color;
    
    public Body(String color, Stack<ComponentHTML> cuerpo){
        this.cuerpoHTML = cuerpo;
        this.color = color;
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
        while(!cuerpoHTML.isEmpty()){
            sb.append(cuerpoHTML.pop().getHtml());
        }
        sb.append("</body>");
        return sb.toString();
    }
}

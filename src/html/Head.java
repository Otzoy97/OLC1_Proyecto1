/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

/**
 *
 * @author otzoy
 */
public class Head implements ComponentHTML {
    private ComponentHTML titulo;
    
    public Head(ComponentHTML titulo){
        this.titulo = titulo;
    }

    /**
     * Deuelve el head de un html con su titulo adentro
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<head>\n").append("<meta charset=\"utf-8\"/>\n").append(titulo.getHtml()).append("</head>\n");
        return sb.toString();
    }
    
}

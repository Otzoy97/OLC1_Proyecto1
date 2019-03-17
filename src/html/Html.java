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
public class Html implements ComponentHTML {
    private Head cabecera;
    private Body cuerpo;
    
    public Html(Head cabeza, Body cuerpo){
        this.cabecera = cabeza;
        this.cuerpo = cuerpo;
    }
    
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n").append(cabecera.getHtml()).append(cuerpo.getHtml()).append("</html>\n");
        return sb.toString();
    }
    
}

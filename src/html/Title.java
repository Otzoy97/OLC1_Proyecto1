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
public class Title implements ComponentHTML  {
    private String titulo;

    public Title(String titulo){
        this.titulo = titulo;
    }
    /**
     * Devuelve el título en formato html
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<title>").append(titulo).append("</title>\n");
        return sb.toString();
    }
}

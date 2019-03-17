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
public class TextA implements ComponentHTML{
    private String texto;

    public TextA(String texto) {
        this.texto = texto;
    }
    /**
     * Devuelve un título grando en formate HTML
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>\n").append(texto).append("\n</h1>\n");
        return sb.toString();
    }
    
}

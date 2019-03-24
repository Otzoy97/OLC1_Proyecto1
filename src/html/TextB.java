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
public class TextB implements ComponentHTML {
    private String texto;

    public TextB(String texto) {
        this.texto = texto;
    }
    /**
     * Devuelve un formato de título pequeño en HTML
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h3>\n").append(texto).append("\n</h3>\n");
        return sb.toString();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

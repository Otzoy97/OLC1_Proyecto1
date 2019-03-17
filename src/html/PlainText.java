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
public class PlainText implements ComponentHTML {
    private String texto;

    public PlainText(String texto) {
        this.texto = texto;
    }
    /**
     * Retorna un texto plano
     * @return 
     */
    @Override
    public String getHtml() {
        return this.texto + "\n";
    }    
}

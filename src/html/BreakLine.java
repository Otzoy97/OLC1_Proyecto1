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
public class BreakLine implements ComponentHTML {
    /**
     * Devuelve un salto de línea en formato HTML
     * @return 
     */
    @Override
    public String getHtml() {
        return "\n<br>\n";
    }
    
}

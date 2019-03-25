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
public class Button implements ComponentHTML {
    private String identificador;
    private String texto;
    private String alerta;
    
    public Button(String texto, String identificador){
        this.texto = texto;
        this.identificador = identificador;
        this.alerta = "";
    }
    /**
     * Devuelve un botón en formato HTML 
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<input type=\"button\" value=\"").append(texto).append("\"");
        if(!alerta.isEmpty()){
            sb.append(" onclick=\"(function(){alert('").append(this.alerta).append("'); return false;})();return false;\"");
        }
        sb.append(">\n");
        return sb.toString();
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return this.texto;
    }
    public void setAlerta(String alerta){
        this.alerta = alerta;
    }
}

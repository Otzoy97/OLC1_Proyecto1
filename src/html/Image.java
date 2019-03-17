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
public class Image implements ComponentHTML {

    private String path;
    private int alto = -1;
    private int ancho = -1;
    /**
     * Esta clase enum existe ya que tanto como alto o ancho pueden o no aparecer, ya sea una o la otra o ambas.
     * Entonces cuando solo aparezca una de ellas esta clase enum servirá para determinar cuál dimensión se especificó
     */
    public enum Dimension{
        ALTO, ANCHO;
    }
    /**
     * Solo se específica uno de las dos medidas, alto o ancho
     * @param path
     * @param medida
     * @param dimension 
     */
    public Image(String path, int medida, Dimension dimension){
        this.path = path;
        switch(dimension){
            case ALTO:
                alto = medida;
                break;
            case ANCHO:
                ancho = medida;
                break;
        }
    }
    /**
     * Se especifican las dos medidas
     * @param path
     * @param alto
     * @param ancho 
     */
    public Image(String path, int alto, int ancho) {
        this.path = path;
        this.alto = alto;
        this.ancho = ancho;
    }
    /**
     * Se especifica únicamente el path
     * @param path 
     */
    public Image(String path) {
        this.path = path;
    }
    /**
     * Devuelve una segmento HTML de imagen
     * @return 
     */
    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<img src=\"").append(path).append("\"");
        if( alto >= 0 ){
            sb.append(" width=\"").append(ancho).append("\"");
        }
        if ( ancho >= 0){
            sb.append(" height=\"").append(ancho).append("\"");
        }
        sb.append(">\n");
        return sb.toString();
    }

}

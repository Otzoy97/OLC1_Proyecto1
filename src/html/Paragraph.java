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
public class Paragraph implements ComponentHTML {
    
    private Align alineado = null;
    private String parrafo = "";
    
    public enum Align{
        IZQ,DER,CENTER,JUSTIFY;
    }
    /**
     * Constructor de parrafo con alineación específica
     * @param parrafo
     * @param alineado 
     */
    public Paragraph(String parrafo, Align alineado){
        this.parrafo = parrafo;
        this.alineado = alineado;
    }
    /**
     * Constructor de parrafo sin alineacion específica
     * @param parrafo 
     */
    public Paragraph(String parrafo){
        this.parrafo = parrafo;
    }
    /**
     * Devuelve un párrafo en formato HTML 
     * @return 
     */
    @Override
    public String getHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<p");
        //Si el alineado no es nulo decidirá cuál alineado colocar
        if(alineado!=null){
            sb.append(" style=\"text-align: ");
            switch(alineado){
                case IZQ:
                    sb.append("left;");
                    break;
                case DER:
                    sb.append("right;");
                    break;
                case CENTER:
                    sb.append("center;");
                    break;
                case  JUSTIFY:
                    sb.append("justify;");
                    break;
            }
            sb.append("\"");    
        }
        //Agrega el párrfo y cierra la etiqueta
        sb.append(">\n").append(parrafo).append("</p>\n");
        return sb.toString();
    }
}

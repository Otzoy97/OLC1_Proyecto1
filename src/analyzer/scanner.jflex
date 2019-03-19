//Paquete
package analyzer;
//Import
import java_cup.runtime.Symbol;
import java.util.LinkedList;
//Lista
%%
%{
    public LinkedList<Token> LexErr  = new LinkedList();
    public LinkedList<Token> LexTok = new LinkedList();
    private String cadena = "";
%}
//Directivas
%cupsym sym
%class Scanner
%cup 
%public
%unicode
%line
%column
%char
%ignorecase
%state HTML, CUERPO, PARRAFO, SALTO, TEXTOA, TEXTOB, IMAGEN, BOTON, TABLA, FILA, COLUMNAC, COLUMNAC, HSCRIPT
//RE
ComentarioHTML = ("<!" [^/] ~"!>") |("<!" "!"+ "!>")
Comentario = "//" [^\r\n]* [^\r\n]
ComentarioMulti = ("/*" [^/] ~"*/") |("/*" "/"+ "*/")
Entero = [0-9]+
Cadena =[\"][^\"\n]*[\"\n]
Decimal = {Entero}.{Entero}
Letra = [A-Za-z]+
Identificador = "$"{Letra}({Letra}|{Entero}|"_")*
Estructura = "#"{Letra}({Letra}|{Entero}|"_")*
Espacio = \t\f|" "|\r|\n


COMPI_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "compi" ({ComentarioHTML}|{Espacio})* ">"
COMPI_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "compi" ({ComentarioHTML}|{Espacio})* ">"

CABEZA_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "cabecera" ({ComentarioHTML}|{Espacio})* ">"
CABEZA_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "cabecera" ({ComentarioHTML}|{Espacio})* ">"

TITULO_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "titulo" ({ComentarioHTML}|{Espacio})* ">"
TITULO_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "titulo" ({ComentarioHTML}|{Espacio})* ">"

CUERPO_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "cuerpo" ({ComentarioHTML}|{Espacio})*
CUERPO_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "cuerpo" ({ComentarioHTML}|{Espacio})* ">"

ESPACIO_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "espacio" ({ComentarioHTML}|{Espacio})* ">"
ESPACIO_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "espacio" ({ComentarioHTML}|{Espacio})* ">"

PARRAFO_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "parrafo" ({ComentarioHTML}|{Espacio})*
PARRAFO_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "parrafo" ({ComentarioHTML}|{Espacio})* ">"

SALTO = "<"  ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "salto" ({ComentarioHTML}|{Espacio})* ">"

TEXTOA_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "textoa" ({ComentarioHTML}|{Espacio})* ">"
TEXTOA_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "textoa" ({ComentarioHTML}|{Espacio})* ">"

TEXTOB_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "textob" ({ComentarioHTML}|{Espacio})* ">"
TEXTOB_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "cabecera" ({ComentarioHTML}|{Espacio})* ">"

IMAGEN_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "imagen" ({ComentarioHTML}|{Espacio})* 
IMAGEN_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "imagen" ({ComentarioHTML}|{Espacio})* ">"

BOTON_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "boton" ({ComentarioHTML}|{Espacio})*
BOTON_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "boton" ({ComentarioHTML}|{Espacio})* ">"

TABLA_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "tabla" ({ComentarioHTML}|{Espacio})*
TABLA_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "tabla" ({ComentarioHTML}|{Espacio})* ">"

FILA_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "fila" ({ComentarioHTML}|{Espacio})* ">"
FILA_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "fila" ({ComentarioHTML}|{Espacio})* ">"

COLUMNAC_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "columnac" ({ComentarioHTML}|{Espacio})* ">"
COLUMNAC_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "columnac" ({ComentarioHTML}|{Espacio})* ">"

COLUMNA_INICIAL = "<" ({ComentarioHTML}|{Espacio})* "columna" ({ComentarioHTML}|{Espacio})* ">"
COLUMNA_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "columna" ({ComentarioHTML}|{Espacio})* ">"

HSCRIPT_INICIO = "<" ({ComentarioHTML}|{Espacio})* "?" ({ComentarioHTML}|{Espacio})* "hs"
HSCRTIP_FINAL = "?" ({ComentarioHTML}|{Espacio})* ">"

//(String token, int columna, int fila, String lexema){
%%
{ComentarioHTML}{}
{Espacio}{}
<HTML>{
    {ComentarioHTML}{}
    {Espacio}{
        String temp = cadena.substring(cadena.length-1);
        if(!temp.equals(" ") && !temp.equals("\n") && !temp.equals("\t") && !temp.equals("\f") && !temp.equals("\r")){
            cadena += " ";
        }
    }
    [^]{
        if(yytext().equals("<")){
            yypushback(1);
            yybegin(YYINITIAL);
            LexTok.add(new Token("TEXTO PLANO",yycolumn,yyline,cadena));        
            return new Sym(sym.PLAINTEXT,yycolumn,yyline,cadena);
        } else {
            cadena += yytext();
        }
    }
}
{COMPI_INICIAL} {
    LexTok.add(new Token("COMPI_INICIO",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML)
    return new Symbol(sym.COMPI_INICIO,yycolumn,yyline,yytext());
}
{COMPI_FINAL} {
    LexTok.add(new Token("COMPI_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML)
    return new Symbol(sym.COMPI_FINAL,yycolumn,yyline,yytext());
}
{CABEZA_INICIAL} {
    LexTok.add(new Token("CABEZA_INICIO",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML)
    return new Symbol(sym.CABEZA_INICIO,yycolumn,yyline,yytext());
}
{CABEZA_FINAL} {
    LexTok.add(new Token("CABEZA_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML)
    return new Symbol(sym.CABEZA_FINAL,yycolumn,yyline,yytext());
}
{TITULO_INICIAL} {
    LexTok.add(new Token("TITULO_INICIO",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML)
    return new Symbol(sym.TITULO_INICIO,yycolumn,yyline,yytext());
}
{TITULO_FINAL} {
    LexTok.add(new Token("TITULO_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML)
    return new Symbol(sym.TITULO_FINAL,yycolumn,yyline,yytext());
}
{CUERPO_INICIAL} {
    LexTok.add(new Token("CUERPO_INICIO",yycolumn,yyline,yytext()));
    yybegin(CUERPO)
    return new Symbol(sym.CUERPO_INICIO,yycolumn,yyline,yytext());
}
<CUERPO>{
    {Espacio}{}
    {ComentarioHTML}{}
    "fondo" {
        LexTok.add(new Token("FONDO",yycolumn,yyline,yytext()));
        return new Symbol(sym.FONDO,yycolumn,yyline,yytext());
    }
    "="{
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    {Cadena}{
        LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CADENA,yycolumn,yyline,yytext());
    }
    ">"{
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
}
{CUERPO_FINAL}{
    LexTok.add(new Token("CUERPO_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.CUERPO_FINAL,yycolumn,yyline,yytext());
}
{ESPACIO_INICIAL}{
    LexTok.add(new Token("ESPACIO_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.ESPACIO_INICIO,yycolumn,yyline,yytext());
}
{ESPACIO_FINAL}{
    LexTok.add(new Token("ESPACIO_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.ESPACIO_FINAL,yycolumn,yyline,yytext());
}
{PARRAFO_INICIAL}{
    LexTok.add(new Token("PARRAFO_INICIAL",yycolumn,yyline,yytext()));
    yybegin(PARRAFO);
    return new Symbol(sym.PARRAFO_INICIAL,yycolumn,yyline,yytext());
}
<PARRAFO>{
    {Espacio}{}
    {ComentarioHTML}{}
    "alineacion" {
        LexTok.add(new Token("ALINEACION",yycolumn,yyline,yytext()));
        return new Symbol(sym.ALINEACION,yycolumn,yyline,yytext());
    }
    "="{
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    {Cadena}{
        LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CADENA,yycolumn,yyline,yytext());
    }
    ">"{
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
}
{PARRAFO_FINAL}{

}
"+"{
    LexTok.add(new Token("MAS",yycolumn,yyline,yytext()));
    return new Symbol(sym.MAS,yycolumn,yyline,yytext());
}
"-"{
    LexTok.add(new Token("MENOS",yycolumn,yyline,yytext()));
    return new Symbol(sym.MENOS,yycolumn,yyline,yytext());
}
"*"{
    LexTok.add(new Token("PRODUCTO",yycolumn,yyline,yytext()));
    return new Symbol(sym.PRODUCTO,yycolumn,yyline,yytext());
}
"/"{
    LexTok.add(new Token("DIVISION",yycolumn,yyline,yytext()));
    return new Symbol(sym.DIVISION,yycolumn,yyline,yytext());
}
"("{
    LexTok.add(new Token("PARDER",yycolumn,yyline,yytext()));
    return new Symbol(sym.PARDER,yycolumn,yyline,yytext());
}
")"{
    LexTok.add(new Token("PARIZQ",yycolumn,yyline,yytext()));
    return new Symbol(sym.PARIZQ,yycolumn,yyline,yytext());
}
"{"{
    LexTok.add(new Token("LLVDER",yycolumn,yyline,yytext()));
    return new Symbol(sym.LLVDER,yycolumn,yyline,yytext());
}
"}"{
    LexTok.add(new Token("LLVIZQ",yycolumn,yyline,yytext()));
    return new Symbol(sym.LLVIZQ,yycolumn,yyline,yytext());
}
"["{
    LexTok.add(new Token("CORDER",yycolumn,yyline,yytext()));
    return new Symbol(sym.CORDER,yycolumn,yyline,yytext());
}
"]"{
    LexTok.add(new Token("CORIZQ",yycolumn,yyline,yytext()));
    return new Symbol(sym.CORIZQ,yycolumn,yyline,yytext());
}
"&&"{
    LexTok.add(new Token("AND",yycolumn,yyline,yytext()));
    return new Symbol(sym.AND,yycolumn,yyline,yytext());
}
"||"{
    LexTok.add(new Token("OR",yycolumn,yyline,yytext()));
    return new Symbol(sym.OR,yycolumn,yyline,yytext());
}
"!"{
    LexTok.add(new Token("NOT",yycolumn,yyline,yytext()));
    return new Symbol(sym.NOT,yycolumn,yyline,yytext());
}
"<"{
    LexTok.add(new Token("MENOR_QUE",yycolumn,yyline,yytext()));
    return new Symbol(sym.MENOR_QUE,yycolumn,yyline,yytext());
}
">"{
    LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
    return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
}
"<="{
    LexTok.add(new Token("MENOR_QUE_IGUAL",yycolumn,yyline,yytext()));
    return new Symbol(sym.MENOR_QUE_IGUAL,yycolumn,yyline,yytext());
}
">="{
    LexTok.add(new Token("MAYOR_QUE_IGUAL",yycolumn,yyline,yytext()));
    return new Symbol(sym.MAYOR_QUE_IGUAL,yycolumn,yyline,yytext());
}
"=="{
    LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
    return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
}
"!="{
    LexTok.add(new Token("DIFERENTE",yycolumn,yyline,yytext()));
    return new Symbol(sym.DIFERENTE,yycolumn,yyline,yytext());
}
"="{
    LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
    return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
}
";"{
    LexTok.add(new Token("SEMICOLON",yycolumn,yyline,yytext()));
    return new Symbol(sym.SEMICOLON,yycolumn,yyline,yytext());
}
"."{
    LexTok.add(new Token("DOT",yycolumn,yyline,yytext()));
    return new Symbol(sym.DOT,yycolumn,yyline,yytext());
}

<HTML>{
    {ComentarioHTML}{}
    {Espacio}{}
    "compi"{
        yybegin(COMPI);
        LexTok.add(new Token("COMPI",yycolumn,yyline,yytext()));
        return new Symbol(sym.COMPI,yycolumn,yyline,yytext());
    }
    .{
        yypushback(1);
        yybegin(YYINITIAL);
    }
}
<COMPI> {
    {ComentarioHTML}{}
    {Espacio}{}
    ">"{
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
}
{Identificador}{
    LexTok.add(new Token("IDENTIFICADOR",yycolumn,yyline,yytext()));
    return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
}
{Estructura}{
    LexTok.add(new Token("ESTRUCTURA",yycolumn,yyline,yytext()));
    return new Symbol(sym.ESTRUCTURA, yycolumn, yyline, yytext());
}
{Entero} 
{
    LexTok.add(new Token("ENTERO",yycolumn,yyline,yytext()));
    return new Symbol(sym.ENTERO, yycolumn, yyline, yytext());
}
{Decimal} 
{
    LexTok.add(new Token("DECIMAL",yycolumn,yyline,yytext()));
    return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());
}
{Cadena}  
{
    LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
    return new Symbol(sym.CADENA, yycolumn,yyline,yytext());
}
.{
    LexErr.add(new Token("Error léxico",yychar,yyline,yytext()));
}
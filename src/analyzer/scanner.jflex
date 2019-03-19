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
    public String cadena = "";
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
%full
%state HTML 
%state CUERPO 
%state PARRAFO 
%state IMAGEN 
%state BOTON 
%state TABLA 
%state HSCRIPT
//RE
ComentarioHTML = ("<!" [^/] ~"!>") |("<!" "!"+ "!>")
Comentario = "//" [^\r\n]* [^\r\n]
ComentarioMulti = ("/*" [^/] ~"*/") |("/*" "/"+ "*/")
Entero = [0-9]+
Cadena =[\"][^\"\n]*[\"\n]
Decimal = {Entero}.{Entero}
Letra = [A-Za-z]+
Identificador = "$" {Letra}({Letra}|{Entero}|"_")*
Estructura = "#" {Letra}({Letra}|{Entero}|"_")*
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
TEXTOB_FINAL = "<" ({ComentarioHTML}|{Espacio})* "/" ({ComentarioHTML}|{Espacio})* "textob" ({ComentarioHTML}|{Espacio})* ">"

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
HSCRIPT_FINAL = "?" ({ComentarioHTML}|{Espacio})* ">"

%%
<YYINITIAL> {COMPI_INICIAL} {
    LexTok.add(new Token("COMPI_INICIO",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.COMPI_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {COMPI_FINAL} {
    LexTok.add(new Token("COMPI_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.COMPI_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {CABEZA_INICIAL} {
    LexTok.add(new Token("CABEZA_INICIO",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.CABEZA_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {CABEZA_FINAL} {
    LexTok.add(new Token("CABEZA_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.CABEZA_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {TITULO_INICIAL} {
    LexTok.add(new Token("TITULO_INICIO",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.TITULO_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {TITULO_FINAL} {
    LexTok.add(new Token("TITULO_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.TITULO_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {CUERPO_INICIAL} {
    LexTok.add(new Token("CUERPO_INICIO",yycolumn,yyline,yytext()));
    yybegin(CUERPO);
    return new Symbol(sym.CUERPO_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {CUERPO_FINAL} {
    LexTok.add(new Token("CUERPO_FINAL",yycolumn,yyline,yytext()));
    cadena = "";
    yybegin(HTML);
    return new Symbol(sym.CUERPO_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {ESPACIO_INICIAL} {
    LexTok.add(new Token("ESPACIO_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.ESPACIO_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {ESPACIO_FINAL} {
    LexTok.add(new Token("ESPACIO_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.ESPACIO_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {PARRAFO_INICIAL} {
    LexTok.add(new Token("PARRAFO_INICIAL",yycolumn,yyline,yytext()));
    yybegin(PARRAFO);
    return new Symbol(sym.PARRAFO_INICIAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {PARRAFO_FINAL} {
    LexTok.add(new Token("PARRAFO_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.PARRAFO_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {SALTO} {
    LexTok.add(new Token("SALTO",yycolumn,yyline,yytext()));
    return new Symbol(sym.SALTO,yycolumn,yyline,yytext());
}
<YYINITIAL> {TEXTOA_INICIAL} {
    LexTok.add(new Token("TEXTOA_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.TEXTOA_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {TEXTOA_FINAL} {
    LexTok.add(new Token("TEXTOA_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.TEXTOA_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {TEXTOB_INICIAL} {
    LexTok.add(new Token("TEXTOB_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.TEXTOB_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {TEXTOB_FINAL} {
    LexTok.add(new Token("TEXTOB_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.TEXTOB_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {IMAGEN_INICIAL} {
    LexTok.add(new Token("IMAGEN_INICIO",yycolumn,yyline,yytext()));
    yybegin(IMAGEN);
    return new Symbol(sym.IMAGEN_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {IMAGEN_FINAL} {
    LexTok.add(new Token("IMAGEN_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.IMAGEN_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {BOTON_INICIAL} {
    LexTok.add(new Token("BOTON_INICIO",yycolumn,yyline,yytext()));
    yybegin(BOTON);
    return new Symbol(sym.BOTON_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {BOTON_FINAL} {
    LexTok.add(new Token("BOTON_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.BOTON_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {TABLA_INICIAL} {
    LexTok.add(new Token("TABLA_INICIO",yycolumn,yyline,yytext()));
    yybegin(TABLA);
    return new Symbol(sym.TABLA_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {TABLA_FINAL} {
    LexTok.add(new Token("TABLA_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.TABLA_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {FILA_INICIAL} {
    LexTok.add(new Token("FILA_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.FILA_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {FILA_FINAL} {
    LexTok.add(new Token("FILA_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.FILA_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {COLUMNAC_INICIAL} {
    LexTok.add(new Token("COLUMNAC_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.COLUMNAC_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {COLUMNAC_FINAL} {
    LexTok.add(new Token("COLUMNAC_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.COLUMNAC_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {COLUMNA_INICIAL} {
    LexTok.add(new Token("COLUMNA_INICIO",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.COLUMNA_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {COLUMNA_FINAL} {
    LexTok.add(new Token("COLUMNA_FINAL",yycolumn,yyline,yytext()));
    cadena="";
    yybegin(HTML);
    return new Symbol(sym.COLUMNA_FINAL,yycolumn,yyline,yytext());
}
<YYINITIAL> {HSCRIPT_INICIO} {
    LexTok.add(new Token("HSCRIPT_INICIO",yycolumn,yyline,yytext()));
    yybegin(HSCRIPT); 
    return new Symbol(sym.HSCRIP_INICIO,yycolumn,yyline,yytext());
}
<YYINITIAL> {ComentarioHTML} {}
<YYINITIAL> {Espacio} {}
<HTML> {
    {ComentarioHTML} {}
    {Espacio} {
        String temp = cadena.substring(cadena.length-1);
        if(!temp.equals(" ") && !temp.equals("\n") && !temp.equals("\t") && !temp.equals("\f") && !temp.equals("\r")){
            cadena += " ";
        }
    }
    [^] {
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
<HSCRIPT> {
    {Comentario} {}
    {ComentarioMulti} {}
    {Espacio} {}
    {HSCRIPT_FINAL} {
        LexTok.add(new Token("HSCRIPT_FINAL",yycolumn,yyline,yytext()));
        cadena="";
        yybegin(HTML);
        return new Symbol(sym.HSCRIPT_FINAL,yycolumn,yyline,yytext());
    }
    "+" {
        LexTok.add(new Token("MAS",yycolumn,yyline,yytext()));
        return new Symbol(sym.MAS,yycolumn,yyline,yytext());
    }
    "-" {
        LexTok.add(new Token("MENOS",yycolumn,yyline,yytext()));
        return new Symbol(sym.MENOS,yycolumn,yyline,yytext());
    }
    "*" {
        LexTok.add(new Token("PRODUCTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.PRODUCTO,yycolumn,yyline,yytext());
    }
    "/" {
        LexTok.add(new Token("DIVISION",yycolumn,yyline,yytext()));
        return new Symbol(sym.DIVISION,yycolumn,yyline,yytext());
    }
    "(" {
        LexTok.add(new Token("PARDER",yycolumn,yyline,yytext()));
        return new Symbol(sym.PARDER,yycolumn,yyline,yytext());
    }
    ")" {
        LexTok.add(new Token("PARIZQ",yycolumn,yyline,yytext()));
        return new Symbol(sym.PARIZQ,yycolumn,yyline,yytext());
    }
    "{" {
        LexTok.add(new Token("LLVDER",yycolumn,yyline,yytext()));
        return new Symbol(sym.LLVDER,yycolumn,yyline,yytext());
    }
    "}" {
        LexTok.add(new Token("LLVIZQ",yycolumn,yyline,yytext()));
        return new Symbol(sym.LLVIZQ,yycolumn,yyline,yytext());
    }
    "[" {
        LexTok.add(new Token("CORDER",yycolumn,yyline,yytext()));
        return new Symbol(sym.CORDER,yycolumn,yyline,yytext());
    }
    "]" {
        LexTok.add(new Token("CORIZQ",yycolumn,yyline,yytext()));
        return new Symbol(sym.CORIZQ,yycolumn,yyline,yytext());
    }
    "&&" {
        LexTok.add(new Token("AND",yycolumn,yyline,yytext()));
        return new Symbol(sym.AND,yycolumn,yyline,yytext());
    }
    "||" {
        LexTok.add(new Token("OR",yycolumn,yyline,yytext()));
        return new Symbol(sym.OR,yycolumn,yyline,yytext());
    }
    "!" {
        LexTok.add(new Token("NOT",yycolumn,yyline,yytext()));
        return new Symbol(sym.NOT,yycolumn,yyline,yytext());
    }
    ">" {
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
    "<" {
        LexTok.add(new Token("MENOR_QUE",yycolumn,yyline,yytext()));
        return new Symbol(sym.MENOR_QUE,yycolumn,yyline,yytext());
    }
    "<=" {
        LexTok.add(new Token("MENOR_QUE_IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.MENOR_QUE_IGUAL,yycolumn,yyline,yytext());
    }
    ">=" {
        LexTok.add(new Token("MAYOR_QUE_IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.MAYOR_QUE_IGUAL,yycolumn,yyline,yytext());
    }
    "==" {
        LexTok.add(new Token("IGUAL_IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL_IGUAL,yycolumn,yyline,yytext());
    }
    "!=" {
        LexTok.add(new Token("DIFERENTE",yycolumn,yyline,yytext()));
        return new Symbol(sym.DIFERENTE,yycolumn,yyline,yytext());
    }
    "=" {
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    ";" {
        LexTok.add(new Token("SEMICOLON",yycolumn,yyline,yytext()));
        return new Symbol(sym.SEMICOLON,yycolumn,yyline,yytext());
    }
    "." {
        LexTok.add(new Token("DOT",yycolumn,yyline,yytext()));
        return new Symbol(sym.DOT,yycolumn,yyline,yytext());
    }
    "," {
        LexTok.add(new Token("COMMA",yycolumn,yyline,yytext()));
        return new Symbol(sym.COMMA,yycolumn,yyline,yytext());
    }
    "if" {
        LexTok.add(new Token("IF",yycolumn,yyline,yytext()));
        return new Symbol(sym.IF, yycolumn, yyline, yytext());
    }
    "else" {
        LexTok.add(new Token("ELSE",yycolumn,yyline,yytext()));
        return new Symbol(sym.ELSE, yycolumn, yyline, yytext());
    }
    "echo" {
        LexTok.add(new Token("ECHO",yycolumn,yyline,yytext()));
        return new Symbol(sym.ECHO, yycolumn, yyline, yytext());
    }
    "repetir" {
        LexTok.add(new Token("REPETIR",yycolumn,yyline,yytext()));
        return new Symbol(sym.REPETIR, yycolumn, yyline, yytext());
    }
    "crearimagen" {
        LexTok.add(new Token("CREARIMAGEN",yycolumn,yyline,yytext()));
        return new Symbol(sym.CREARIMAGEN, yycolumn, yyline, yytext());
    }
    "getpath" {
        LexTok.add(new Token("GETPATH",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETPATH, yycolumn, yyline, yytext());
    }
    "getancho" {
        LexTok.add(new Token("GETANCHO",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETANCHO, yycolumn, yyline, yytext());
    }
    "getalto" {
        LexTok.add(new Token("GETALTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETALTO, yycolumn, yyline, yytext());
    }
    "setalto" {
        LexTok.add(new Token("SETALTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETALTO, yycolumn, yyline, yytext());
    }
    "setancho" {
        LexTok.add(new Token("SETALTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETALTO, yycolumn, yyline, yytext());
    }
    "setpath" {
        LexTok.add(new Token("SETPATH",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETPATH, yycolumn, yyline, yytext());
    }
    "insertar" {
        LexTok.add(new Token("INSERTAR",yycolumn,yyline,yytext()));
        return new Symbol(sym.INSERTAR, yycolumn, yyline, yytext());
    }
    "crearparrafo" {
        LexTok.add(new Token("CREARPARRAFO",yycolumn,yyline,yytext()));
        return new Symbol(sym.CREARPARRAFO, yycolumn, yyline, yytext());
    }
    "setcontenido" {
        LexTok.add(new Token("SETCONTENIDO",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETCONTENIDO, yycolumn, yyline, yytext());
    }
    "getcontenido" {
        LexTok.add(new Token("GETCONTENIDO",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETCONTENIDO, yycolumn, yyline, yytext());
    }
    "setalineacion" {
        LexTok.add(new Token("SETALINEACION",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETALINEACION, yycolumn, yyline, yytext());
    }
    "getalineacion" {
        LexTok.add(new Token("GETALINEACION",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETALINEACION, yycolumn, yyline, yytext());
    }
    "creartextoa" {
        LexTok.add(new Token("CREARTEXTOA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CREARTEXTOA, yycolumn, yyline, yytext());
    }
    "creartextob" {
        LexTok.add(new Token("CREARTEXTOB",yycolumn,yyline,yytext()));
        return new Symbol(sym.CREARTEXTOB, yycolumn, yyline, yytext());
    }
    "creartabla" {
        LexTok.add(new Token("CREARTABLA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CREARTABLA, yycolumn, yyline, yytext());
    }
    "setborde" {
        LexTok.add(new Token("SETBORDE",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETBORDE, yycolumn, yyline, yytext());
    }
    "getborde" {
        LexTok.add(new Token("GETBORDE",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETBORDE, yycolumn, yyline, yytext());
    }
    "crearboton" {
        LexTok.add(new Token("CREARBOTON",yycolumn,yyline,yytext()));
        return new Symbol(sym.CREARBOTON, yycolumn, yyline, yytext());
    }
    "settexto" {
        LexTok.add(new Token("SETTEXTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETTEXTO, yycolumn, yyline, yytext());
    }
    "gettexto" {
        LexTok.add(new Token("GETTEXTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETTEXTO, yycolumn, yyline, yytext());
    }
    "setid" {
        LexTok.add(new Token("SETID",yycolumn,yyline,yytext()));
        return new Symbol(sym.SETID, yycolumn, yyline, yytext());
    }
    "getid" {
        LexTok.add(new Token("GETID",yycolumn,yyline,yytext()));
        return new Symbol(sym.GETID, yycolumn, yyline, yytext());
    }
    "clickboton" {
        LexTok.add(new Token("CLICKBOTON",yycolumn,yyline,yytext()));
        return new Symbol(sym.CLICKBOTON, yycolumn, yyline, yytext());
    }
    {Identificador} {
        LexTok.add(new Token("IDENTIFICADOR",yycolumn,yyline,yytext()));
        return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
    }
    {Estructura} {
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
    . {
        LexErr.add(new Token("Error léxico",yychar,yyline,yytext()));
    }
}
<CUERPO> {
    {Espacio} {}
    {ComentarioHTML} {}
    ">" {
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
    "fondo" {
        LexTok.add(new Token("FONDO",yycolumn,yyline,yytext()));
        return new Symbol(sym.FONDO,yycolumn,yyline,yytext());
    }
    "=" {
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    {Cadena} {
        LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CADENA,yycolumn,yyline,yytext());
    }
}
<PARRAFO> {
    {Espacio} {}
    {ComentarioHTML} {}
    ">" {
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
    "alineacion" {
        LexTok.add(new Token("ALINEACION",yycolumn,yyline,yytext()));
        return new Symbol(sym.ALINEACION,yycolumn,yyline,yytext());
    }
    "=" {
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    {Cadena} {
        LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CADENA,yycolumn,yyline,yytext());
    }
}
<IMAGEN> {
    {Espacio} {}
    {ComentarioHTML} {}
    ">" {
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
    "path" {
        LexTok.add(new Token("PATH",yycolumn,yyline,yytext()));
        return new Symbol(sym.PATH,yycolumn,yyline,yytext());
    }
    "alto" {
        LexTok.add(new Token("ALTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.ALTO,yycolumn,yyline,yytext());
    }
    "ancho" {
        LexTok.add(new Token("ANCHO",yycolumn,yyline,yytext()));
        return new Symbol(sym.ANCHO,yycolumn,yyline,yytext());
    }
    "=" {
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    {Entero} {
        LexTok.add(new Token("ENTERO",yycolumn,yyline,yytext()));
        return new Symbol(sym.ENTERO, yycolumn, yyline, yytext());
    }
    {Cadena} {
        LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CADENA,yycolumn,yyline,yytext());
    }
}
<BOTON> {
    {Espacio} {}
    {ComentarioHTML} {}
    ">" {
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }  
    "id" {
        LexTok.add(new Token("ID",yycolumn,yyline,yytext()));
        return new Symbol(sym.ID,yycolumn,yyline,yytext());
    }
    "texto" {
        LexTok.add(new Token("TEXTO",yycolumn,yyline,yytext()));
        return new Symbol(sym.TEXTO, yycolumn, yyline, yytext());
    }    
    "=" {
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());
    }
    {Cadena} {
        LexTok.add(new Token("CADENA",yycolumn,yyline,yytext()));
        return new Symbol(sym.CADENA,yycolumn,yyline,yytext());
    }
}
<TABLA> {
    {Espacio} {}
    {ComentarioHTML} {}
    ">" {
        LexTok.add(new Token("MAYOR_QUE",yycolumn,yyline,yytext()));
        cadena = "";
        yybegin(HTML);
        return new Symbol(sym.MAYOR_QUE,yycolumn,yyline,yytext());
    }
    "borde" {
        LexTok.add(new Token("BORDE",yycolumn,yyline,yytext()));
        return new Symbol(sym.BORDE,yycolumn,yyline,yytext());
    }
    "=" {
        LexTok.add(new Token("IGUAL",yycolumn,yyline,yytext()));
        return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
    } 
    "true" {
        LexTok.add(new Token("BOOLEANO",yycolumn,yyline,yytext()));
        return new Symbol(sym.BOOLEANO,yycolumn,yyline,yytext());
    }
    "false" {
        LexTok.add(new Token("BOOLEANO",yycolumn,yyline,yytext()));
        return new Symbol(sym.BOOLEANO,yycolumn,yyline,yytext());
    }
}
[^] {
    cadena += yytext();
    yybegin(HTML);
}
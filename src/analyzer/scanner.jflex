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
//RE
Comentario = ("<!" [^/] ~"!>") |("<!" "!"+ "!>")
Entero = [0-9]+
Cadena =[\"][^\"\n]*[\"\n]
Decimal = {Entero}.{Entero}
Letra = [A-Za-z]+
Identificador = {Letra}({Letra}|{Entero}|"_")*
Espacio = \t\f|" "|\r|\n

//(String token, int columna, int fila, String lexema){
%%
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

{Comentario}{}
{Espacio}{}

.{
    LexErr.add(new Token("Error léxico",yychar,yyline,yytext()));
}
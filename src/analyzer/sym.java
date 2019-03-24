
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analyzer;

/** CUP generated class containing symbol constants. */
public class sym {
  /* terminals */
  public static final int PARRAFO_INICIO = 36;
  public static final int IDENTIFICADOR = 92;
  public static final int CORDER = 6;
  public static final int PARIZQ = 3;
  public static final int DIVISION = 11;
  public static final int MENOR_QUE = 17;
  public static final int PATH = 45;
  public static final int CREARBOTON = 86;
  public static final int SETANCHO = 74;
  public static final int GETTEXTO = 88;
  public static final int TITULO_INICIO = 29;
  public static final int BOTON_INICIO = 49;
  public static final int HSCRIPT_FINAL = 63;
  public static final int TEXTOA_INICIO = 40;
  public static final int VERDADERO = 96;
  public static final int SETBORDE = 84;
  public static final int SETPATH = 73;
  public static final int TEXTO = 51;
  public static final int COMMA = 24;
  public static final int DIFERENTE = 21;
  public static final int FALSO = 97;
  public static final int MAYOR_QUE = 16;
  public static final int ALTO = 46;
  public static final int IGUAL_IGUAL = 20;
  public static final int NOT = 15;
  public static final int SETCONTENIDO = 77;
  public static final int GETPATH = 70;
  public static final int BOTON_FINAL = 52;
  public static final int FILA_FINAL = 57;
  public static final int CUERPO_INICIO = 31;
  public static final int PRODUCTO = 10;
  public static final int PLAINTEXT = 64;
  public static final int SETALTO = 75;
  public static final int COLUMNAC_FINAL = 61;
  public static final int COLUMNA_INICIO = 58;
  public static final int LLVIZQ = 5;
  public static final int CREARTEXTOB = 82;
  public static final int CREARPARRAFO = 76;
  public static final int ESTRUCTURA = 90;
  public static final int CREARTABLA = 83;
  public static final int CREARTEXTOA = 81;
  public static final int TABLA_FINAL = 55;
  public static final int ENTERO = 94;
  public static final int TEXTOB_FINAL = 43;
  public static final int CORIZQ = 7;
  public static final int GETCONTENIDO = 78;
  public static final int MENOR_QUE_IGUAL = 18;
  public static final int IGUAL = 12;
  public static final int GETANCHO = 71;
  public static final int CABEZA_FINAL = 28;
  public static final int DECIMAL = 95;
  public static final int GETALTO = 72;
  public static final int FILA_INICIO = 56;
  public static final int TEXTOB_INICIO = 42;
  public static final int CREARIMAGEN = 69;
  public static final int GETBORDE = 85;
  public static final int PARDER = 2;
  public static final int ELSE = 66;
  public static final int MENOS = 9;
  public static final int HSCRIPT_INICIO = 62;
  public static final int ANCHO = 47;
  public static final int MAS = 8;
  public static final int DOT = 23;
  public static final int ECHO = 67;
  public static final int PARRAFO_FINAL = 38;
  public static final int CABEZA_INICIO = 27;
  public static final int SALTO = 39;
  public static final int EOF = 0;
  public static final int SEMICOLON = 22;
  public static final int INSERTAR = 91;
  public static final int SETTEXTO = 87;
  public static final int COLUMNA_FINAL = 59;
  public static final int BORDE = 54;
  public static final int TITULO_FINAL = 30;
  public static final int COLUMNAC_INICIO = 60;
  public static final int CLICKBOTON = 89;
  public static final int TEXTOA_FINAL = 41;
  public static final int ESPACIO_INICIO = 34;
  public static final int COMPI_INICIO = 25;
  public static final int OR = 14;
  public static final int COMPI_FINAL = 26;
  public static final int error = 1;
  public static final int IF = 65;
  public static final int MAYOR_QUE_IGUAL = 19;
  public static final int ID = 50;
  public static final int IMAGEN_INICIO = 44;
  public static final int SETALINEACION = 79;
  public static final int ESPACIO_FINAL = 35;
  public static final int CADENA = 93;
  public static final int CUERPO_FINAL = 33;
  public static final int ALINEACION = 37;
  public static final int TABLA_INICIO = 53;
  public static final int AND = 13;
  public static final int GETALINEACION = 80;
  public static final int FONDO = 32;
  public static final int IMAGEN_FINAL = 48;
  public static final int LLVDER = 4;
  public static final int REPETIR = 68;
  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "PARDER",
  "PARIZQ",
  "LLVDER",
  "LLVIZQ",
  "CORDER",
  "CORIZQ",
  "MAS",
  "MENOS",
  "PRODUCTO",
  "DIVISION",
  "IGUAL",
  "AND",
  "OR",
  "NOT",
  "MAYOR_QUE",
  "MENOR_QUE",
  "MENOR_QUE_IGUAL",
  "MAYOR_QUE_IGUAL",
  "IGUAL_IGUAL",
  "DIFERENTE",
  "SEMICOLON",
  "DOT",
  "COMMA",
  "COMPI_INICIO",
  "COMPI_FINAL",
  "CABEZA_INICIO",
  "CABEZA_FINAL",
  "TITULO_INICIO",
  "TITULO_FINAL",
  "CUERPO_INICIO",
  "FONDO",
  "CUERPO_FINAL",
  "ESPACIO_INICIO",
  "ESPACIO_FINAL",
  "PARRAFO_INICIO",
  "ALINEACION",
  "PARRAFO_FINAL",
  "SALTO",
  "TEXTOA_INICIO",
  "TEXTOA_FINAL",
  "TEXTOB_INICIO",
  "TEXTOB_FINAL",
  "IMAGEN_INICIO",
  "PATH",
  "ALTO",
  "ANCHO",
  "IMAGEN_FINAL",
  "BOTON_INICIO",
  "ID",
  "TEXTO",
  "BOTON_FINAL",
  "TABLA_INICIO",
  "BORDE",
  "TABLA_FINAL",
  "FILA_INICIO",
  "FILA_FINAL",
  "COLUMNA_INICIO",
  "COLUMNA_FINAL",
  "COLUMNAC_INICIO",
  "COLUMNAC_FINAL",
  "HSCRIPT_INICIO",
  "HSCRIPT_FINAL",
  "PLAINTEXT",
  "IF",
  "ELSE",
  "ECHO",
  "REPETIR",
  "CREARIMAGEN",
  "GETPATH",
  "GETANCHO",
  "GETALTO",
  "SETPATH",
  "SETANCHO",
  "SETALTO",
  "CREARPARRAFO",
  "SETCONTENIDO",
  "GETCONTENIDO",
  "SETALINEACION",
  "GETALINEACION",
  "CREARTEXTOA",
  "CREARTEXTOB",
  "CREARTABLA",
  "SETBORDE",
  "GETBORDE",
  "CREARBOTON",
  "SETTEXTO",
  "GETTEXTO",
  "CLICKBOTON",
  "ESTRUCTURA",
  "INSERTAR",
  "IDENTIFICADOR",
  "CADENA",
  "ENTERO",
  "DECIMAL",
  "VERDADERO",
  "FALSO"
  };
}


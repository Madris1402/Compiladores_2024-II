
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package fes.aragon.compilador;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class analisis_sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Simbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public analisis_sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public analisis_sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public analisis_sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\005\000\002\002\004\000\002\002" +
    "\004\000\002\003\004\000\002\003\005\000\002\003\005" +
    "\000\002\003\005\000\002\003\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\012\004\004\007\005\012\006\013\010\001" +
    "\002\000\012\004\004\007\005\012\006\013\010\001\002" +
    "\000\012\004\004\007\005\012\006\013\010\001\002\000" +
    "\012\005\ufffa\006\ufffa\010\ufffa\011\ufffa\001\002\000\010" +
    "\005\014\006\016\011\021\001\002\000\012\005\ufff9\006" +
    "\ufff9\010\ufff9\011\ufff9\001\002\000\014\002\013\004\004" +
    "\007\005\012\006\013\010\001\002\000\010\005\014\006" +
    "\016\011\015\001\002\000\004\002\000\001\002\000\012" +
    "\004\004\007\005\012\006\013\010\001\002\000\014\002" +
    "\001\004\001\007\001\012\001\013\001\001\002\000\012" +
    "\004\004\007\005\012\006\013\010\001\002\000\012\005" +
    "\ufffc\006\ufffc\010\ufffc\011\ufffc\001\002\000\012\005\ufffd" +
    "\006\ufffd\010\ufffd\011\ufffd\001\002\000\014\002\uffff\004" +
    "\uffff\007\uffff\012\uffff\013\uffff\001\002\000\010\005\014" +
    "\006\016\010\023\001\002\000\012\005\ufffb\006\ufffb\010" +
    "\ufffb\011\ufffb\001\002\000\012\005\ufffe\006\ufffe\010\ufffe" +
    "\011\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\006\002\010\003\006\001\001\000\004\003" +
    "\023\001\001\000\004\003\021\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\003\011\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\017" +
    "\001\001\000\002\001\001\000\004\003\016\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$analisis_sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$analisis_sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$analisis_sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public String resultado="";
    public static LinkedList<TError> TablaES = new LinkedList<TError>();
    public ArrayList<String> datos=new ArrayList<>();

    public void imprimir(String e){
        System.out.println("Valor= "+e);
    }

    public void syntax_error(Symbol s)
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!Error Sintactico Recuperado!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);

        TError datos = new TError(lexema,fila,columna,"Error Sintactico","Caracter no esperado");
        TablaES.add(datos);
       
    }

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!Error Sintactico");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);

         TError datos = new TError(lexema,fila,columna,"Error Sintactico","Caracter no esperado");
        TablaES.add(datos);
     
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$analisis_sintactico$actions {


        public void imprimirInterno(String e){
            System.out.println("Valor_i= "+e);
        }


  private final analisis_sintactico parser;

  /** Constructor */
  CUP$analisis_sintactico$actions(analisis_sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$analisis_sintactico$do_action_part00000000(
    int                        CUP$analisis_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$analisis_sintactico$parser,
    java.util.Stack            CUP$analisis_sintactico$stack,
    int                        CUP$analisis_sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$analisis_sintactico$result;

      /* select the action based on the action number */
      switch (CUP$analisis_sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // INICIO ::= INICIO E punto_coma 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).value;
		
                resultado=a;
                imprimir(a);
                imprimirInterno(a);
                datos.add(a);
            
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).value;
		RESULT = start_val;
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$analisis_sintactico$parser.done_parsing();
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= E punto_coma 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).value;
		
                resultado=a;
                imprimir(a);
                imprimirInterno(a);
                datos.add(a);
             
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // E ::= not E 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.peek()).value;
		 boolean val1= Boolean.parseBoolean(a);
                    boolean r = !val1;
                    RESULT = String.valueOf(r); 
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // E ::= E and E 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.peek()).value;
		 boolean val1= Boolean.parseBoolean(a);
                    boolean val2= Boolean.parseBoolean(b);
                    boolean r = val1 && val2;
                    RESULT = String.valueOf(r); 
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // E ::= E or E 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.peek()).value;
		  boolean val1= Boolean.parseBoolean(a);
                    boolean val2= Boolean.parseBoolean(b);
                    boolean r = val1 || val2;
                    RESULT = String.valueOf(r); 
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // E ::= par_a E par_c 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-1)).value;
		 RESULT = a; 
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.elementAt(CUP$analisis_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // E ::= tr 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.peek()).value;
		 RESULT = (String) a; 
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // E ::= fl 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$analisis_sintactico$stack.peek()).value;
		 RESULT = (String) a; 
              CUP$analisis_sintactico$result = parser.getSymbolFactory().newSymbol("E",1, ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$analisis_sintactico$stack.peek()), RESULT);
            }
          return CUP$analisis_sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$analisis_sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$analisis_sintactico$do_action(
    int                        CUP$analisis_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$analisis_sintactico$parser,
    java.util.Stack            CUP$analisis_sintactico$stack,
    int                        CUP$analisis_sintactico$top)
    throws java.lang.Exception
    {
              return CUP$analisis_sintactico$do_action_part00000000(
                               CUP$analisis_sintactico$act_num,
                               CUP$analisis_sintactico$parser,
                               CUP$analisis_sintactico$stack,
                               CUP$analisis_sintactico$top);
    }
}

}

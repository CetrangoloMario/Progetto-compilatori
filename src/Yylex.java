// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: srcjflexcup/circuit.flex

// toy.lex
//
// Description of lexer for circuit description language.
//
// Ian
/*
* This class is a simple example lexer
*/

import java_cup.runtime.Symbol;

import java.io.IOException;
import java.io.Reader;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING_CONST = 2;
  public static final int COMMENT = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2, 2
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\1\1\2\22\0\1\1"+
    "\1\4\1\5\3\0\1\6\1\0\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\11\20\1\21"+
    "\1\22\1\23\1\24\1\25\2\0\32\26\1\0\1\27"+
    "\2\0\1\26\1\0\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\2\26\1\41\1\26\1\42"+
    "\1\43\1\44\1\26\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\3\26\1\0\1\53\10\0\1\3\u01a2\0\2\3"+
    "\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\2\14\1\15\1\16"+
    "\1\17\1\20\1\21\17\22\1\1\2\23\1\24\3\23"+
    "\1\25\1\26\1\27\1\0\1\30\1\31\1\32\1\33"+
    "\2\22\1\34\2\22\1\35\1\22\1\36\2\22\1\37"+
    "\10\22\1\40\1\41\1\42\1\43\1\23\1\44\6\22"+
    "\1\45\11\22\1\46\1\47\1\50\1\51\2\22\1\52"+
    "\1\53\2\22\1\54\1\55\1\56\2\22\1\57\1\60"+
    "\2\22\1\61\1\62\1\63\1\64";

  private static int [] zzUnpackAction() {
    int [] result = new int[116];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\130\0\204\0\204\0\204\0\204\0\260"+
    "\0\204\0\204\0\204\0\204\0\204\0\334\0\u0108\0\u0134"+
    "\0\u0160\0\u018c\0\204\0\u01b8\0\204\0\u01e4\0\u0210\0\u023c"+
    "\0\u0268\0\u0294\0\u02c0\0\u02ec\0\u0318\0\u0344\0\u0370\0\u039c"+
    "\0\u03c8\0\u03f4\0\u0420\0\u044c\0\u0478\0\u04a4\0\204\0\u04d0"+
    "\0\204\0\u04fc\0\u0528\0\u0554\0\204\0\204\0\204\0\u0580"+
    "\0\204\0\204\0\204\0\204\0\u05ac\0\u05d8\0\u0210\0\u0604"+
    "\0\u0630\0\u0210\0\u065c\0\u0210\0\u0688\0\u06b4\0\u0210\0\u06e0"+
    "\0\u070c\0\u0738\0\u0764\0\u0790\0\u07bc\0\u07e8\0\u0814\0\204"+
    "\0\204\0\204\0\204\0\u0840\0\u0580\0\u086c\0\u0898\0\u08c4"+
    "\0\u08f0\0\u091c\0\u0948\0\u0210\0\u0974\0\u09a0\0\u09cc\0\u09f8"+
    "\0\u0a24\0\u0a50\0\u0a7c\0\u0aa8\0\u0ad4\0\u0210\0\u0210\0\u0210"+
    "\0\u0210\0\u0b00\0\u0b2c\0\u0210\0\u0210\0\u0b58\0\u0b84\0\u0210"+
    "\0\u0210\0\u0210\0\u0bb0\0\u0bdc\0\u0210\0\u0210\0\u0c08\0\u0c34"+
    "\0\u0210\0\u0210\0\u0210\0\u0210";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[116];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\4\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\4\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\4\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\2\27\1\35\1\27"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\27\1\44"+
    "\1\45\1\46\2\47\1\50\1\4\1\47\1\51\21\47"+
    "\1\52\23\47\1\50\2\47\1\50\1\4\5\47\1\53"+
    "\4\47\1\54\34\47\1\50\62\0\1\55\72\0\1\56"+
    "\37\0\1\57\57\0\1\60\53\0\1\60\1\0\2\21"+
    "\57\0\1\61\53\0\1\62\1\63\52\0\1\64\46\0"+
    "\2\27\5\0\1\27\1\0\23\27\20\0\2\27\5\0"+
    "\1\27\1\0\13\27\1\65\7\27\20\0\2\27\5\0"+
    "\1\27\1\0\13\27\1\66\7\27\20\0\2\27\5\0"+
    "\1\27\1\0\13\27\1\67\7\27\20\0\2\27\5\0"+
    "\1\27\1\0\11\27\1\70\11\27\20\0\2\27\5\0"+
    "\1\27\1\0\1\71\7\27\1\72\1\73\11\27\20\0"+
    "\2\27\5\0\1\27\1\0\5\27\1\74\4\27\1\75"+
    "\10\27\20\0\2\27\5\0\1\27\1\0\20\27\1\76"+
    "\2\27\20\0\2\27\5\0\1\27\1\0\3\27\1\77"+
    "\17\27\20\0\2\27\5\0\1\27\1\0\15\27\1\100"+
    "\5\27\20\0\2\27\5\0\1\27\1\0\4\27\1\101"+
    "\16\27\20\0\2\27\5\0\1\27\1\0\17\27\1\102"+
    "\3\27\20\0\2\27\5\0\1\27\1\0\7\27\1\103"+
    "\5\27\1\104\5\27\20\0\2\27\5\0\1\27\1\0"+
    "\13\27\1\105\7\27\20\0\2\27\5\0\1\27\1\0"+
    "\7\27\1\106\5\27\1\107\5\27\54\0\1\110\2\0"+
    "\1\50\50\0\1\50\5\0\1\111\21\0\1\112\42\0"+
    "\1\113\46\0\1\114\61\0\2\115\52\0\2\27\5\0"+
    "\1\27\1\0\13\27\1\116\7\27\20\0\2\27\5\0"+
    "\1\27\1\0\15\27\1\117\5\27\20\0\2\27\5\0"+
    "\1\27\1\0\10\27\1\120\5\27\1\121\4\27\20\0"+
    "\2\27\5\0\1\27\1\0\11\27\1\122\11\27\20\0"+
    "\2\27\5\0\1\27\1\0\13\27\1\123\7\27\20\0"+
    "\2\27\5\0\1\27\1\0\17\27\1\124\3\27\20\0"+
    "\2\27\5\0\1\27\1\0\11\27\1\125\11\27\20\0"+
    "\2\27\5\0\1\27\1\0\13\27\1\126\7\27\20\0"+
    "\2\27\5\0\1\27\1\0\1\127\22\27\20\0\2\27"+
    "\5\0\1\27\1\0\15\27\1\130\5\27\20\0\2\27"+
    "\5\0\1\27\1\0\4\27\1\131\16\27\20\0\2\27"+
    "\5\0\1\27\1\0\20\27\1\132\2\27\20\0\2\27"+
    "\5\0\1\27\1\0\10\27\1\133\12\27\20\0\2\27"+
    "\5\0\1\27\1\0\10\27\1\134\12\27\20\0\2\27"+
    "\5\0\1\27\1\0\10\27\1\135\12\27\12\0\1\47"+
    "\61\0\2\27\5\0\1\27\1\0\11\27\1\136\11\27"+
    "\20\0\2\27\5\0\1\27\1\0\14\27\1\137\6\27"+
    "\20\0\2\27\5\0\1\27\1\0\5\27\1\140\15\27"+
    "\20\0\2\27\5\0\1\27\1\0\4\27\1\141\16\27"+
    "\20\0\2\27\5\0\1\27\1\0\16\27\1\142\4\27"+
    "\20\0\2\27\5\0\1\27\1\0\1\143\22\27\20\0"+
    "\2\27\5\0\1\27\1\0\11\27\1\144\11\27\20\0"+
    "\2\27\5\0\1\27\1\0\2\27\1\145\20\27\20\0"+
    "\2\27\5\0\1\27\1\0\3\27\1\146\17\27\20\0"+
    "\2\27\5\0\1\27\1\0\10\27\1\147\12\27\20\0"+
    "\2\27\5\0\1\27\1\0\12\27\1\150\10\27\20\0"+
    "\2\27\5\0\1\27\1\0\4\27\1\151\16\27\20\0"+
    "\2\27\5\0\1\27\1\0\3\27\1\152\17\27\20\0"+
    "\2\27\5\0\1\27\1\0\11\27\1\153\11\27\20\0"+
    "\2\27\5\0\1\27\1\0\17\27\1\154\3\27\20\0"+
    "\2\27\5\0\1\27\1\0\4\27\1\155\16\27\20\0"+
    "\2\27\5\0\1\27\1\0\17\27\1\156\3\27\20\0"+
    "\2\27\5\0\1\27\1\0\11\27\1\157\11\27\20\0"+
    "\2\27\5\0\1\27\1\0\12\27\1\160\10\27\20\0"+
    "\2\27\5\0\1\27\1\0\4\27\1\161\16\27\20\0"+
    "\2\27\5\0\1\27\1\0\4\27\1\162\16\27\20\0"+
    "\2\27\5\0\1\27\1\0\12\27\1\163\10\27\20\0"+
    "\2\27\5\0\1\27\1\0\6\27\1\164\14\27\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3168];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\4\11\1\1\5\11\5\1\1\11\1\1\1\11"+
    "\21\1\1\11\1\1\1\11\3\1\3\11\1\0\4\11"+
    "\23\1\4\11\51\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[116];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */

    private StringBuffer string= new StringBuffer();
   // private static HashMap<String,Symbol> stringTable=new HashMap<String,Symbol>();

    private Symbol symbol(int type){
        return new Symbol(type, yyline,yycolumn);
    }

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

   /* private Symbol installID(String str){
        Symbol symbol;
        if(stringTable.containsKey(str)){
            return symbol(CircuitSym.ID,stringTable.get(str).toString());
        }
        else {
            symbol=new Symbol(CircuitSym.ID,str);
            stringTable.put(str,symbol);
            return symbol(CircuitSym.ID,str);
        }
    }

    private Symbol intNum(String str){
        Symbol symbol;
        symbol=new Symbol(CircuitSym.INTNUM,str);
        return symbol;
    }

    private Symbol decNUM(String str){
            Symbol symbol;
            symbol=new Symbol(CircuitSym.DECNUM,str);
            return symbol;
        }

        public void printStringTable(){
                //int x=0;
                System.out.println("--------String table--------");
                for (Map.Entry e : stringTable.entrySet())
                {
                    // x++;
                    System.out.println("| ID: "+e.getKey()+" | Token: "+e.getValue()+" |" );

                }
                System.out.println("------------------------------------" );
            }*/


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws IOException if the reader could not be closed.
   */
  public final void yyclose() throws IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case STRING_CONST: {
              System.err.println("Stringa costante non chiusa");
        			  return new Symbol(sym.EOF);
            }  // fall though
            case 117: break;
            case COMMENT: {
              System.err.println("Commento non chiuso"); return new Symbol(sym.error,yytext());
            }  // fall though
            case 118: break;
            default:
              {
                return new Symbol(sym.EOF);
              }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return new Symbol(sym.error,yytext());
            }
            // fall through
          case 53: break;
          case 2:
            { /* ignore */
            }
            // fall through
          case 54: break;
          case 3:
            { return new Symbol(sym.NOT);
            }
            // fall through
          case 55: break;
          case 4:
            { string.setLength(0); yybegin(STRING_CONST);
            }
            // fall through
          case 56: break;
          case 5:
            { return new Symbol(sym.LPAR);
            }
            // fall through
          case 57: break;
          case 6:
            { return new Symbol(sym.RPAR);
            }
            // fall through
          case 58: break;
          case 7:
            { return new Symbol(sym.TIMES);
            }
            // fall through
          case 59: break;
          case 8:
            { return new Symbol(sym.PLUS);
            }
            // fall through
          case 60: break;
          case 9:
            { return new Symbol(sym.COMMA);
            }
            // fall through
          case 61: break;
          case 10:
            { return new Symbol(sym.MINUS);
            }
            // fall through
          case 62: break;
          case 11:
            { return new Symbol(sym.DIV);
            }
            // fall through
          case 63: break;
          case 12:
            { return new Symbol(sym.INT_CONST,yytext());
            }
            // fall through
          case 64: break;
          case 13:
            { return new Symbol(sym.COLON);
            }
            // fall through
          case 65: break;
          case 14:
            { return new Symbol(sym.SEMI);
            }
            // fall through
          case 66: break;
          case 15:
            { return new Symbol(sym.LT);
            }
            // fall through
          case 67: break;
          case 16:
            { return new Symbol(sym.EQ);
            }
            // fall through
          case 68: break;
          case 17:
            { return new Symbol(sym.GT);
            }
            // fall through
          case 69: break;
          case 18:
            { return new Symbol(sym.ID,yytext());
            }
            // fall through
          case 70: break;
          case 19:
            { string.append(yytext());
            }
            // fall through
          case 71: break;
          case 20:
            { yybegin(YYINITIAL);
        		 return new Symbol(sym.STRING_CONST, string.toString());
            }
            // fall through
          case 72: break;
          case 21:
            { return new Symbol(sym.AND);
            }
            // fall through
          case 73: break;
          case 22:
            { return new Symbol(sym.RETURN);
            }
            // fall through
          case 74: break;
          case 23:
            { string.setLength(0); yybegin(COMMENT);
            }
            // fall through
          case 75: break;
          case 24:
            { return new Symbol(sym.ASSIGN);
            }
            // fall through
          case 76: break;
          case 25:
            { return new Symbol(sym.LE);
            }
            // fall through
          case 77: break;
          case 26:
            { return new Symbol(sym.NE);
            }
            // fall through
          case 78: break;
          case 27:
            { return new Symbol(sym.GE);
            }
            // fall through
          case 79: break;
          case 28:
            { return new Symbol(sym.DO);
            }
            // fall through
          case 80: break;
          case 29:
            { return new Symbol(sym.FI);
            }
            // fall through
          case 81: break;
          case 30:
            { return new Symbol(sym.IF);
            }
            // fall through
          case 82: break;
          case 31:
            { return new Symbol(sym.OD);
            }
            // fall through
          case 83: break;
          case 32:
            { return new Symbol(sym.OR);
            }
            // fall through
          case 84: break;
          case 33:
            { string.append('\"');
            }
            // fall through
          case 85: break;
          case 34:
            { string.append('\\');
            }
            // fall through
          case 86: break;
          case 35:
            { ;yybegin(YYINITIAL);
            }
            // fall through
          case 87: break;
          case 36:
            { return new Symbol(sym.FLOAT_CONST,yytext());
            }
            // fall through
          case 88: break;
          case 37:
            { return new Symbol(sym.INT);
            }
            // fall through
          case 89: break;
          case 38:
            { return new Symbol(sym.BOOL);
            }
            // fall through
          case 90: break;
          case 39:
            { return new Symbol(sym.CORP);
            }
            // fall through
          case 91: break;
          case 40:
            { return new Symbol(sym.ELIF);
            }
            // fall through
          case 92: break;
          case 41:
            { return new Symbol(sym.ELSE);
            }
            // fall through
          case 93: break;
          case 42:
            { return new Symbol(sym.NULL);
            }
            // fall through
          case 94: break;
          case 43:
            { return new Symbol(sym.PROC);
            }
            // fall through
          case 95: break;
          case 44:
            { return new Symbol(sym.THEN);
            }
            // fall through
          case 96: break;
          case 45:
            { return new Symbol(sym.TRUE);
            }
            // fall through
          case 97: break;
          case 46:
            { return new Symbol(sym.VOID);
            }
            // fall through
          case 98: break;
          case 47:
            { return new Symbol(sym.FALSE);
            }
            // fall through
          case 99: break;
          case 48:
            { return new Symbol(sym.FLOAT);
            }
            // fall through
          case 100: break;
          case 49:
            { return new Symbol(sym.WHILE);
            }
            // fall through
          case 101: break;
          case 50:
            { return new Symbol(sym.WRITE);
            }
            // fall through
          case 102: break;
          case 51:
            { return new Symbol(sym.READ);
            }
            // fall through
          case 103: break;
          case 52:
            { return new Symbol(sym.STRING);
            }
            // fall through
          case 104: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}

public class Tester {

	public static void main(String[] args)   {

		String test=args[0];
		try {
			lessicalPrint(test);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//stampa
	private static void lessicalPrint(String source) throws Exception {
		System.out.println("\n\n Printing lexens of " + source + ": ");
		Lexer lex = new Lexer();
		if (lex.initialize(source)) {
			Token res;
			while ((res = lex.nextToken()) != null) {
				System.out.println(res.toString());
			}
			lex.printSymbolTable();
			lex.printKeyWordsTable();
		}
		else System.out.println("File not found!!");
	}

}

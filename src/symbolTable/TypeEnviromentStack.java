package symbolTable;

import java.util.ArrayList;
import java.util.Hashtable;


public class TypeEnviromentStack implements Stack_old_version<Tabella> {

	private Stack_old_version<Tabella> stack;

	public TypeEnviromentStack(){
		this.stack = (Stack_old_version<Tabella>) new ArrayList<Tabella>();
		this.push(new Tabella());
	}

	public Tabella top() {
		return stack.top();
	}

	public void push(Tabella t) {
		stack.push(t);
	}
	
	public Tabella pop() {
		return stack.pop();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public String addId(String key, Item item)  {
		if (isEmpty()) {
			System.err.println("Stack is empty!");
			System.exit(1);
		}
		if(probe(key)){
			System.err.println("errore dichiarazione multipla");
			System.exit(1);
		}
		Tabella table= stack.top();
		table.addItem(key,item);

		return key;
	}

	public boolean probe(String k){
		Item i= stack.top().find(k);
		if (i!=null)
			return true;
		return false;
	}

	
	public Item lookup(String key) throws Exception {
		return stack.top().find(key);
	}
	
}

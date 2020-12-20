package paleo.lib.token;
import paleo.lib.interpreter.OperationDictionary;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class SetOperandToken implements OperandToken {
    private List <String> elements;

    private SetOperandToken (List <String> elements){
        this.elements = elements;
    }

    // TODO: Needs to find a better design.
	@Override
	public boolean isAnOperandToken() {
		return true;
    }
    
    @Override
	public boolean equals(Object obj) {
        return true;
    }
    
    @Override
	public String toString() {
		return "{ " + elements.stream().collect(Collectors.joining(" ; ")) + " }";
	}

    

    
    /******* SetOperandToken Factory ***************/
    private static List <String> storage = new ArrayList <String> ();

    public static void addElement (String element){
        storage.add(element);
    }

    public static SetOperandToken build (){
        SetOperandToken res = new SetOperandToken (storage);
        flush();
        return res;
    }

    public static void flush () {
        storage.clear();
    }
    
    
}
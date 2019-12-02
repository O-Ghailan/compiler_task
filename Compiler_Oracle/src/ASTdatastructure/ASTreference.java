package ASTdatastructure;
import java.util.Arrays;



public class ASTreference extends Nodes {

	String var;//variable of our reference
	
		//ASTreference Constructor
	public ASTreference(String var) {
		super();
		this.name="Ref";
		this.var = var;
		Nodes variableNode = new Nodes("String:"+ var);
		this.children = Arrays.asList(variableNode);
	}
	
	
	
	
	//referenec getter
	public String refgetvar(ASTreference n) {
		return n.var;
	}






//Code generator for reference node
	@Override
	public String NodetoCode() {
		
		String s;
		s=""+var;
		return s;
		
		}
	
}

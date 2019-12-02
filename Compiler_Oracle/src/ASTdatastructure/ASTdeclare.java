package ASTdatastructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ASTdeclare extends Nodes {
	public String var;
	public List<String> usecase= new ArrayList<>();	
	
	
	//Declaration node
	


	public ASTdeclare(String var) {
		super();
		
		this.name="Decl";
		this.var = var;
		Nodes variableNode = new Nodes("String:" + var);
		this.children = Arrays.asList(variableNode);
		
	}
	
	//Generated code of a node
	public String NodetoCode() {
		return "int " + var;
	}

	
}

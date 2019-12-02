package ASTdatastructure;
import java.util.Arrays;


public class ASTassign extends Nodes{
	
	
	String var;
	Nodes expression;
	//assign constuctor
	public ASTassign(String var, Nodes expression) {
		super();
		this.name="Assign";
		this.var = var;
		Nodes variableNode = new Nodes(var);
		this.expression = expression;
		this.children = Arrays.asList(variableNode, expression);
	}
	//Code generator
	@Override
	public String NodetoCode() {
		return var + "= " + expression.NodetoCode();
		}
	
}

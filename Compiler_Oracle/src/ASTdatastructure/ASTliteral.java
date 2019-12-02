package ASTdatastructure;
import java.util.Arrays;





public class ASTliteral extends Nodes {
	int value;
	//ASTliteral constructor
	public ASTliteral(int value) {
		super();
		this.name="Lit";
		this.value = value;
		Nodes valueNode = new Nodes("int:"+value);
		this.children = Arrays.asList(valueNode);
	}

	
	
	//ASTliteral Code generator
	public String NodetoCode() {
		String s;
		s=""+value;
		return s;
		}


}

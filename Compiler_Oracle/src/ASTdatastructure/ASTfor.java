package ASTdatastructure;
import java.util.Arrays;
import java.util.List;





public class ASTfor extends Nodes{
	
	public String i;
	public Nodes start;
	public Nodes stop;
	public List<Nodes> Body;
	
	//for constructor
	public ASTfor( String i, Nodes start, Nodes stop, List<Nodes> Body) {
		
		this.i = i;
		this.start = start;
		this.stop = stop;
		this.Body = Body;
		this.name="for";
		Nodes pointerNode = new Nodes("iterator");
		List<Nodes> loopcondition ;
		loopcondition= Arrays.asList(pointerNode, start, stop);
		Nodes loopParametersNode = new Nodes("List", loopcondition);
		Nodes loopBodyNode = new Nodes("List", Body);
		this.children = Arrays.asList(loopParametersNode, loopBodyNode);
		
		
	}
	//for generator
	public String NodetoCode() {
		String b = new String();
		for (Nodes node:Body) {
			b += "\t\t" + node.NodetoCode();
	    	if (!b.substring(b.length()-1).equals(";") && !b.substring(b.length()-1).equals("}") )
	    	{
				b += ";";
	    	}
	    	b += "\n" ;
	    }
		return "for (int " + this.i + " = "  + this.start.NodetoCode() + "; " + this.i + "<" +
	    this.stop.NodetoCode() + "; " + this.i + "++) {\n" + b + "\t}" ; 
	}
	
}

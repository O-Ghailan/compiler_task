package ASTdatastructure;
import java.util.ArrayList;
import java.util.List; 


public class Nodes {
	public String name; //name is a declared as local variable
	public List<Nodes> children= new ArrayList<>();//children of the node are stored as a list
	
	//generated constructor
	public Nodes(String name, List<Nodes> children) {
		super();
		this.name = name;
		this.children = children;
	}

	public Nodes() {
		super();
	}
	
	//for nodes that aren't supposed to have children
	public Nodes(String name) {
		super();
		this.name = name;
	}
	
	
	//this is a default method 
	public String NodetoCode() {
		return "";
	}

	
}
	

	
	
	
	










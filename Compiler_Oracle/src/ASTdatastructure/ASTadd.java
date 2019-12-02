package ASTdatastructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ASTadd extends Nodes{
	
	Nodes right;
	Nodes left;
	public List<String> addedvalues= new ArrayList<>();
	
	
	
	//add constructor
	public ASTadd( Nodes left, Nodes right) {
		this.name="Add";
		this.right = right;
		this.left = left;
		this.children = Arrays.asList(left, right);
			
		
	}
	
	public String refgetvar(ASTreference n){	
		return n.var;
		
	}
	

	//addvalues list
	public List<String> addvalueslist(){
		if (this.right instanceof ASTreference) {
			addedvalues.add(refgetvar((ASTreference)this.right));
			
		}
			else {
				if (this.right instanceof ASTadd){
					((ASTadd) this.right).addvalueslist();		
					
				}
			}
			
	return addedvalues;
	
		}
		
		
	
	//add generator
	
	@Override
	public String NodetoCode() {
		return left.NodetoCode() + " + " + right.NodetoCode();
		}
	 
}

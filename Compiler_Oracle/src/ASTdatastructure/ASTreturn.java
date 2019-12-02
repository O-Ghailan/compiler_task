package ASTdatastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASTreturn extends Nodes{
	
	Nodes returnValue;
	public List<String> returnedvalues= new ArrayList<>();
	
	//ASTreturn constructor
	
	public ASTreturn(Nodes returnValue) {
		super();
		this.returnValue = returnValue;
	}
	
	public List<String> addvaluesnode(ASTadd n){
		
		return n.addedvalues;
	}
	
	
	public String refvar(ASTreference n) {
		
		return n.var;
	}
	//Return values generator
	public List<String> returnedvaluesgenerator(){
		
		for (Iterator<Nodes> itererator = this.returnValue.children.iterator(); itererator.hasNext(); ) {
			Nodes temp = itererator.next();
			if (temp instanceof ASTadd) {		
				returnedvalues.addAll(this.addvaluesnode((ASTadd) temp));
				
			}
			
			else {
				
				if (temp instanceof ASTreference) {
					returnedvalues.add(refvar((ASTreference) temp));
				}			
			}
					
			}
			return returnedvalues;
		}
		
		
	
	//return code generator
	
	@Override
	public String NodetoCode() {
		return "return " +returnValue.NodetoCode();
		}
	
	

}

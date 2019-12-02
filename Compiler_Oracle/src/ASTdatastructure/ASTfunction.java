package ASTdatastructure;

import java.util.Arrays;

import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;


public class ASTfunction extends Nodes {
	
	public List<String> args;
	Nodes argsNode;
	public List<Nodes> body;
	public Nodes bodyNode;
	public String functionName;
	
	
	//astfunction constructor
	public ASTfunction(String functionName, List<String> args, List<Nodes> body) {
		super();
		this.name="Func";
		this.functionName = functionName;
		this.args = args;
		List<Nodes> argsNodes = new ArrayList<Nodes>();
		for (String argsName : args) {
			Nodes arg = new Nodes(argsName);
			argsNodes.add(arg);
		}
		this.argsNode = new Nodes("Args", argsNodes);
		this.body = body;
		this.bodyNode = new Nodes("Body", body);
		this.children = Arrays.asList(argsNode, bodyNode);

	}
	
	//code generator
	@Override
	public String NodetoCode() {
		String argsString = new String();	
		String bodyString = new String();	

		Iterator<String> iterator = args.iterator();
	    while (iterator.hasNext()) {
			argsString += "int " +iterator.next();
			if (iterator.hasNext()) {
				argsString += ", ";
			}
		}

	    for (Nodes node:body) {
	    	bodyString += "\t" + node.NodetoCode();
	    	if (!bodyString.substring(bodyString.length()-1).equals(";") && 
	    			!bodyString.substring(bodyString.length()-1).equals("}") ) {
	    		bodyString += ";";
	    	}
	    	bodyString += "\n" ;
	    }
		return "public static int " + functionName + "(" + argsString +") {\n" + bodyString +"}"; 
	}
	
	
	public void ASTCodeGenerator() {
		String JavaCode=new String();
		JavaCode=this.NodetoCode();
		System.out.println(JavaCode);
	}
	
	
	//useless for loops remover
	public void removeuselessfor(Nodes node) {
		for (Iterator<Nodes> itererator = node.children.iterator(); itererator.hasNext(); ) {
			Nodes temp = itererator.next();
		    if (temp instanceof ASTfor) {
		        if (temp.children.size()>1) {
		        	itererator.remove();
		        }
		        else {
		        	removeuselessfor(temp.children.get(1));
		        	itererator.remove();
		        }
		        }
		    }
		}
	
	//simple optimizer1
	public ASTfunction Optimizer1() {
		removeuselessfor(this.bodyNode);
		return this;
	}
	
	
	public List<String> adddectest(ASTadd node){
		
		return node.addvalueslist();
	}
	
	
	
public List<String> returndectest(ASTreturn node){
		
		return node.returnedvaluesgenerator();
	}

	//testing if declation is necessary or not 
	public boolean declarationtest(ASTdeclare declarationnode,Nodes node) {
		
		for (Iterator<Nodes> itererator = node.children.iterator(); itererator.hasNext(); ) {
			Nodes temp = itererator.next();
			if (temp instanceof ASTadd) {
				declarationnode.usecase.addAll(adddectest((ASTadd) temp));
				
			}
			if (temp instanceof ASTreturn) {
				List<String> L=returndectest((ASTreturn) temp);
				declarationnode.usecase.removeAll(L);
				
				if (L.equals(returndectest((ASTreturn) temp))) {
					
					return false;
				}
				else {
					return true;
				}
						
			}	
		}
		return true;	
		}
		
		
	
	
	//delete unnecessary declaration
	public void unnecessarydecldelete(Nodes node) {
		
		for (Iterator<Nodes> itererator = node.children.iterator(); itererator.hasNext(); ) {
			Nodes temp = itererator.next();
			if (temp instanceof ASTdeclare) {
				
				if (declarationtest((ASTdeclare) temp,node)==false) {
					itererator.remove();
					for (Iterator<Nodes> it = node.children.iterator(); itererator.hasNext(); ) {
						Nodes t=itererator.next();
						if (t instanceof ASTassign) {
							if (((ASTassign) t).var==((ASTdeclare) temp).var) {
								itererator.remove();
								
							}
						}
					}
				}
				
			}
		}
		
	}
	
	
	public void  Optmizer2(){		
		unnecessarydecldelete(this.bodyNode);		
	}
	
	
	}
	
	
	
	

	


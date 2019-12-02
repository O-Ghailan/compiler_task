package ASTtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ASTdatastructure.ASTadd;
import ASTdatastructure.ASTassign;
import ASTdatastructure.ASTdeclare;
import ASTdatastructure.ASTfunction;
import ASTdatastructure.ASTliteral;
import ASTdatastructure.ASTreference;
import ASTdatastructure.ASTreturn;
import ASTdatastructure.Nodes;

public class test5 {
	
	
	public static List<String> args = Arrays.asList("a"); 
	
	public static Nodes declare = new ASTdeclare("b");
	public static Nodes lit2 = new ASTliteral(1337);
	public static Nodes assign1 = new ASTassign("b", lit2);
	public static Nodes returnref = new ASTreference("a");
	public static Nodes lit = new ASTliteral(1);
	public static Nodes add = new ASTadd(returnref,lit);
	public static Nodes ret = new ASTreturn(add);
	
	public static List<Nodes> body = new LinkedList<Nodes>(Arrays.asList(declare,assign1,ret));
	public static ASTfunction func1 = new ASTfunction("test5",args,body);
	
	public static void main(String[] args) {
		System.out.println("before our optimization:");
		func1.ASTCodeGenerator();
		
		func1.Optmizer2();
		System.out.println("after our optimization:");
		func1.ASTCodeGenerator();
		
	}

}




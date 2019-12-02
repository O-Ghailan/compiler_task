package ASTtest;

import java.util.Arrays;
import java.util.List;

import ASTdatastructure.ASTadd;
import ASTdatastructure.ASTassign;
import ASTdatastructure.ASTdeclare;
import ASTdatastructure.ASTfor;
import ASTdatastructure.ASTfunction;
import ASTdatastructure.ASTliteral;
import ASTdatastructure.ASTreference;
import ASTdatastructure.ASTreturn;
import ASTdatastructure.Nodes;




public class test2 {
	
	public static List<String> args = Arrays.asList("a");
	public static Nodes addref1 = new ASTreference("a");
	public static Nodes addref2 = new ASTreference("b");
	public static Nodes declare = new ASTdeclare("b");
	public static Nodes lit2 = new ASTliteral(0);
	public static Nodes assign1 = new ASTassign("b", lit2);
	public static Nodes add = new ASTadd(addref1,addref2);
	public static Nodes assign2 = new ASTassign("b", add);
	public static Nodes lit1 = new ASTliteral(0);
	public static Nodes endfor = new ASTreference("a");
	public static List<Nodes> Body = Arrays.asList(assign2);
	public static Nodes for1 = new ASTfor("i",lit1,endfor,Body);
	public static Nodes returnref = new ASTreference("b");
	public static Nodes ret= new ASTreturn(returnref);
	public static List<Nodes> body = Arrays.asList(declare,assign1,for1,ret);
	public static ASTfunction func1 = new ASTfunction("test2", args,body);
	
	
	
	public static void main(String[] args) {
		
		func1.ASTCodeGenerator();
	}

}

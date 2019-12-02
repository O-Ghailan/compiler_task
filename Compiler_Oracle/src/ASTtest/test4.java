package ASTtest;


	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.List;
	import ASTdatastructure.ASTadd;
	import ASTdatastructure.ASTfor;
	import ASTdatastructure.ASTfunction;
	import ASTdatastructure.ASTliteral;
	import ASTdatastructure.ASTreference;
	import ASTdatastructure.ASTreturn;
	import ASTdatastructure.Nodes;
	
	
public class test4 {
	
	
	
	
	public static List<String> args = Arrays.asList("a"); 			//parameters
	
	
	//for2
	public static Nodes lit3 = new ASTliteral(0);
	public static Nodes endfor2 = new ASTreference("a");
	public static List<Nodes> Body2 = Arrays.asList();
	public static Nodes for2 = new ASTfor("i2",lit3,endfor2,Body2);
	
	
	public static Nodes lit1 = new ASTliteral(0);
	public static Nodes endfor = new ASTreference("a");
	public static List<Nodes> Body = Arrays.asList(for2);
	public static Nodes for1 = new ASTfor("i1",lit1,endfor,Body);
	
	public static Nodes returnref = new ASTreference("a");
	public static Nodes lit2 = new ASTliteral(1);
	public static Nodes add = new ASTadd(returnref,lit2);
	public static Nodes ret = new ASTreturn(add);
	
	public static List<Nodes> body = new LinkedList<Nodes>(Arrays.asList(for1,ret));
	
	public static ASTfunction func1 = new ASTfunction("test4",args,body);
	
	
	
	public static void main(String[] args) {
		System.out.println("before our optimization:");
		func1.ASTCodeGenerator();
		
		func1.Optimizer1();
		System.out.println("after our optimization:");
		func1.ASTCodeGenerator();
		
	}

}

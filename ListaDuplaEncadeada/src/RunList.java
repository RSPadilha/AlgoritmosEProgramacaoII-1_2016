
public class RunList {

	public static void main(String[] args){
		List<String> listString = new List<>();
		List<Integer> listInt = new List<>();
		listString.append("This is a test1");
		listString.append("This is a test2");
		listString.append("This is a test3");
		listString.append("This is a test4");
		listString.append("This is a test5");
		listString.append("This is a test6");
		listString.append("This is a test7");
		System.out.println(listString.mostraProx());//testa segunda e penultima pos
		System.out.println(listString.percorreInvertido());
		System.out.println(listString);
		listInt.append(333);
		System.out.println(listInt+"INT");
		
		listString.insert(1, "inserido na 2");
		System.out.println(listString);
	}

}

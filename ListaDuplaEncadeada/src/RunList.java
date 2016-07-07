
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
		//testa segunda e penultima pos
		System.out.println(listString.mostraProx());
		System.out.println(listString.percorreInvertido());
		System.out.println(listString);
		listInt.append(333);
		listInt.append(3683);
		listInt.append(353);
		System.out.println(listInt+"INT");
		
		listString.insert(2, "na 2");
		listString.insert(3, "na 3");
		listString.insert(4, "na 4");
		listString.insert(5, "na 5");
		listString.insert(100, "inserido com append");
		System.out.println(listString);
		System.out.println("Print");
		listString.print();
		System.out.println("Invertido \n"+listString.percorreInvertido());
		
		System.out.println(listString.has("na 2"));
		listString.remove(50);//remove em qualquer pos. se for maior q o num de elementos, romove o ultimo
		listString.print();
	}

}

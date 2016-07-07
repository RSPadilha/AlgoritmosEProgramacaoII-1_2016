
public class List <T> {

	private Node<T> head, tail;
	private int count = 0;

	public List(){}
	public List(T data){
		head = new Node<T>(data);
		tail = head;
	}
	//criar classe iterator tendo o metodo hasNext()
	//itarator é usado para percorrer a lista

	public void append(T data){//insere no final
		Node<T> actual = new Node<T>(data);
		if(head == null){//isEmpty()
			head = actual;
			tail = head;
			count++;
		}else if(head == tail){//um elemento
			head.setNext(actual);
			tail = actual;
			tail.setPrevious(head);
			count++;
		}else{
			Node<T> iter = head;
			while(iter.getNext() != null){
				iter = iter.getNext();
			}
			iter.setNext(actual);
			tail = actual;
			tail.setPrevious(iter);//possivel inverter a ordem?
		}
	}//fim append

	//teste excluir
	public String mostraProx(){
		//nunca mostar o anterior do head nem o proximo do tail(NullPointerException)
		//tambem cuidar se tiver somente um elemento na lista, nesse caso mostar somente getData()
		return (String) tail.getPrevious().getData() + "tail\n" +head.getNext().getData()+"head";//todos nexts setados
	}
	//teste excluir
	public String percorreInvertido(){//todos previous setados
		String retorno = "";
		Node<T> iter = tail;
		while(iter != null){
			retorno += iter.getData() + "\n";
			iter = iter.getPrevious();
		}
		return retorno; 
	}

	public void insert(int index, T data){
		Node<T> actual = new Node<>(data);
		Node<T> iter = head;
		for(int i = 1; i < index; i++){//percorre ate chegar na pos desejada
			iter = iter.getNext();
		}
		if(iter == head){
			//
			count++;
		}else{
			actual.setPrevious(iter.getPrevious());
			actual.setNext(iter);
			iter.getPrevious().setNext(actual);
			iter.getNext().setPrevious(actual);
			count++;
		}
	}

	public T getNode(int index){
		return null;//implementar
	}

	public void remove(int index){//deixar variavel sem referencia e deixar GarbageColector agir, ou setar Null
		
	}

	public int getSize(){
		return count;
	}

	public boolean has(T data){
		Node<T> iter = head;
		while(iter.getData()!= data){
			iter = iter.getNext();
		}
		if(iter.getData() == data)
			return true;
		return false;//or using .equals //melhorar
	}

	@Override
	public String toString() {
		String retorno = "";
		Node<T> iter = head;
		while(iter != null){
			retorno += iter.getData() + "\n";
			iter = iter.getNext();
			//melhorar usando string.algumacoisa
		}
		return retorno;
	}

}

//criar classe iterator tendo o metodo hasNext()
//itarator é usado para percorrer a lista

public class List <T> {

	private Node<T> head, tail;
	private int count = 0;
	//criar iterator aqui ou dar new dentro de cada metodo

	public List(){}
	public List(T data){
		head = new Node<T>(data);
		tail = head;
	}

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
			tail.setPrevious(iter);
			count++;
		}
	}

	//teste. excluir
	public String mostraProx(){
		//nunca mostar o anterior do head nem o proximo do tail(NullPointerException)
		//tambem cuidar se tiver somente um elemento na lista, nesse caso mostar somente getData()
		return (String) tail.getPrevious().getData() + "tail\n" +head.getNext().getData()+"head";//todos nexts setados
	}
	//teste. excluir
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
			if(index > count){
				append(data);
				return;
			}
			iter = iter.getNext();
		}
		if(iter == head){
			head.setPrevious(actual);
			actual.setNext(head);
			head = actual;
			count++;
		}else if(iter == tail){
			append(data);
			/*tail.getPrevious().setNext(actual);
			actual.setPrevious(tail.getPrevious());
			actual.setNext(tail);
			tail.setPrevious(actual);
			count++;*/
		}else{
			//ou usar construtor (anterior, dado, prox)
			actual.setPrevious(iter.getPrevious());
			actual.setNext(iter);
			actual.getPrevious().setNext(actual);
			actual.getNext().setPrevious(actual);
			count++;
		}
	}

	public void remove(int index){//deixar variavel sem referencia e deixar GarbageColector agir, ou setar Null
		Node<T> iter = head;
		for(int i = 1; i < index && i < count; i++){
			iter = iter.getNext();
		}
		if(iter == head){
			head = head.getNext();
			head.setPrevious(null);
		}else if(iter == tail){
			tail.getPrevious().setNext(null);
			tail = tail.getPrevious();
		}else{
			iter.getPrevious().setNext(iter.getNext());
			iter.getNext().setPrevious(iter.getPrevious());
		}
	}

	public int getSize(){
		return count;
	}

	public boolean has(T data){
		Node<T> iter = head;
		while(iter.getData()!= data && iter.getNext() != null){
			iter = iter.getNext();
		}
		if(iter.getData() == data){//if eh necessario?
			return true;
		}
		else{
			return false;//or using .equals //melhorar
		}
	}

	public void print(){
		Node<T> iter = head;
		while(iter != null){
			System.out.println(iter.getData());
			iter = iter.getNext();
		}
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

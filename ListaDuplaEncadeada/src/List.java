
public class List <T> {

	private Node<T> head, tail;
	private int count = 0;

	public void append(T data){//insere no final
		Node<T> actual = new Node<T>(data);
		if(head == null){
			head = actual;
			return;//acaba funcao ou break
		}
		Node<T> iter = head;
		
	}






	/*
		//add on start
		if(count == 0){
			head = actual;
			tail = head;
			count++;
		}else if(count == 1){
			tail = actual;
			head.setNext(tail);
		}else{

		}
	 */



	public void insert(int index, T data){
		Node<T> actual = new Node<>(data);
		Node<T> iter = head;
		for(int i = 0; i < index; i++){
			iter = iter.getNext();
		}
		iter = new Node(data);//verificar
	}

	public T getNode(int index){
		return null;//implementar
	}

	public void remove(int index){}

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
		return false;//or using .equals
	}

	@Override
	public String toString() {
		return "List [head=" + head.getData() + "]";
	}

}

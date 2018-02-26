package doublyLinkedList;

public class doublyLinkedList<E> {

	Node head;
	Node tail;
	
	doublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	public class Node{
		E data;
		Node next;
		Node prev;
		
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		
		public Node(E newData, int index) {
			Node current = head;
			int counter = 0;
			while(counter != index) {
				current = current.next;
			}
			data = newData;
			this.next = current.next;
			current.next = this;
			this.prev = current.prev;
			current.prev = this;
		}
	}

	public void addFirst(E item) {
		Node newNode = new Node();
		newNode.data = item;
		//Empty LIst
		if (head.next.data == null) {
			head.next = newNode;
			newNode.prev = head;
			newNode.next = tail;
			tail.prev = newNode;
			return;
		}

		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		return;
	}
	
	public void addLast(E item) {
		Node newNode = new Node();	
		newNode.data = item;
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		return;			
	}

	public int size() {
		if(head.next == null) {
			return 0;
		}
		int counter = 1;
		Node current = head.next;
		while(current.next != null) {
			counter++;
			current = current.next;
		}	
		return counter;
	}

	public void add(E item, int index) {
		if(index < 0 || index > size()) {
			System.out.println("Invalid");
			return;
		}
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;

		if(index == 0) {
			addFirst(item);
		}else if(index == size()){
			addLast(item);
		}else {
			Node tempHead = head;
			for(int i = 0; i < index; i++) {
				tempHead = tempHead.next;
			}
			newNode.prev = tempHead;
			newNode.next = tempHead.next;
			tempHead.next.prev = newNode;
			tempHead.next = newNode;
		}
	}

	void removeFirst(){
		if(head == null) {
			return;
		}	

		if(head != null){
			head = head.next;
			head.prev = null;
		}
	}

	void removeLast() {
		if(tail == null) {
			return;
		}	
		if(tail != null) {
			tail = tail.prev;
			tail.next = null;
		}
	}

	void remove(int index) {
		if(index < 0 || index > size()) {
			System.out.println("Not valid");
			return;
		}
		if(index == 0) {
			removeFirst();
		}else if(index == size()){
			removeLast();
		}else {	
			Node newNode = head;

			for(int i = 0; i < index; i++) {
				newNode = newNode.next;
			}
			newNode.prev.next = newNode.next;
			newNode.next.prev = newNode.prev;
			newNode.next = null;
			newNode.prev = null;
		}
	}

	void change(E item, int index) {

		Node current = head.next;
		int counter = 0;
		while(counter != index){
			current = current.next;
			counter++;
		}
		current.data = item;
	}

	public void traverseForward() {
	//	System.out.println("DATA is Still here " + head.data);
		Node current = head.next;
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}

		return;
	}
	
	public void traverseBackward() {
		Node current = tail.prev;
		while(current.prev != null) {
			System.out.println(current.data);
			current = current.prev;
		}
		return;
	}
	
	public static void main(String[] args) {
		
		doublyLinkedList <String> list = new doublyLinkedList<String>();
		System.out.println("Add first:");
		list.addFirst("red");
		list.addFirst("grape");
		list.addFirst("yellow");
		list.add("blue", 1);
		list.traverseForward();
		
		//System.out.println("\nAdd first backwards");
		//list.traverseBackward();
		
		System.out.println("\nAdd last:");
		list.addLast("brown");
		list.addLast("black");
		list.addLast("white");	
		list.traverseForward();
		
		//System.out.println("\nAdd last backwards");
		//list.traverseBackward();
		
		System.out.println("\nRemove first:");
		list.removeFirst();
		list.traverseForward();
		
		//System.out.println("\nRemove first backwards");
		//list.traverseBackward();
		
		System.out.println("\nRemove last:");
		list.removeLast();
		list.traverseForward();
		
		//System.out.println("\nRemove last backwards");
		//list.traverseBackward();
			
		System.out.println("\nRemove at index:");
		list.remove(2);
		list.traverseForward();

		System.out.println("\nRemove at index backwards:");
		list.traverseBackward();
		
		System.out.println("\nChange value at index:");
		list.change("gold", 2);
		list.traverseForward();
		
		System.out.println("\nList backwards:");
		list.traverseBackward();
		

	}
}

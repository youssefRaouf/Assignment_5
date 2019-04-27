package eg.edu.alexu.csd.datastructure.stack.cs78;



public class stack implements IStack {
private	Node top;
	
	public stack() {
		top = null ;
	}
	@Override
	public Object pop() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return null ;
		}
		Node temp ;
		temp = top ;
		top=top.prev ;
		return temp.data ;
		
	}

	@Override
	public Object peek() {
       if(!isEmpty()) {
    	   return top.data ;
       }
       else {
    	   System.out.println("stack is empty");
    	   return null ;
       }
	}

	@Override
	public void push(Object element) {
		Node temp = new Node(element);
		temp.prev=top ;
		top=temp ;
	}

	@Override
	public boolean isEmpty() {
		if(size() ==0) {
			return true ;
		}
		return false ;
		
	}

	@Override
	public int size() {
		Node current = top;
		int i = 0;
		while (current != null) {
			i++;
			current = current.prev;
		}
		return i;
		
	}

}

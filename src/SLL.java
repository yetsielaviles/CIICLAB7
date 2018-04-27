import java.util.ArrayList;

import Classes.Pair;

public class SLL<E> {
	protected static class SNode<T>{
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
		}
	}
     private SNode<E> first = null; 
     private int size = 0; 
     public void addFirst(E e) { 
         SNode<E> nuevo = new SNode<>(e, first); 
         first = nuevo; 
         size++; 
    }
    public String toString() { 
	   String s = ""; 
	   SNode<E> current = first; 
	   while (current != null) { 
	      s += " " + current.getElement(); 
	      current = current.getNext(); 
         }
         return s; 
    }
    
    public void reverse() { 
        if (size > 1) {   // if size is 1, the list is already its reverse...
           SNode<E> c = first, a = first.getNext(), b = null; 
           while (a != null) { 
                  c.setNext(b);
                  b = c; 
                  c = a; 
                  a = a.getNext(); 
           } 
           c.setNext(b);
           first = c; 
        }
    }
    
    private SNode<E> recReverse(SNode<E> b, SNode<E> c) { 
        if  (c==null) return b;
        SNode<E> a=c.getNext(); 
        c.setNext(b);
        return recReverse(c, a);
    }
    
    public void reverse2() { 
    	   if (size > 1) 
    	      first = (recReverse2(first)).first(); 
    	}
	private Pair<SNode> recReverse2(SNode<E> first) {
		// TODO Auto-generated method stub
		if(first.getNext() == null)
		return new Pair(first, null);
		
		Pair<SNode> p = new Pair<SNode>(first, first.getNext());
		p.second().setNext(first);
		return recReverse2(p.second());
	}
	
	
	private void recLessThan(SNode<E> fr, E e, ArrayList<E> result) { 		 
		if (fr != null) { 
			if (((Comparable<E>) fr.getElement()).compareTo(e) < 0)
				result.add(e); 
			recLessThan(fr.getNext(), e, result);  // passing reference to result
	  }
	} 
	
	public ArrayList<E> lessThan(E e) { 
	   ArrayList<E> result = new ArrayList<>();     // and empty ArrayList object
	   if (size > 0) 
	      recLessThan(first, e, result);   // passing only reference to result
	   return result; 
	}

	
	public ArrayList<Pair<E>> consecutiveIncreasingPairs() { 
	   ArrayList<Pair<E>> result = new ArrayList<>();     // and empty ArrayList object
	   if (size > 0) 
	      recCIP(first, result); 
	   return result; 
	}
	private void recCIP(SNode<E> first, ArrayList<Pair<E>> result) {
		// TODO Auto-generated method stub
		if(first != null && first.getNext() != null) {//will stop if it is empty or if you reached the last node
			if(((Comparable<E>) first.getElement()).compareTo(first.getNext().getElement()) < 0) {
				Pair<E> p = new Pair<E>(first.getElement(), first.getNext().getElement());
				result.add(p);
			}
			recCIP(first.getNext(), result);//look at next pair
		}
	}

    // NO NEED FOR OTHER METHODS FOR THE MOMENT...
    //... we will add more methods as part of the exercises below...
}
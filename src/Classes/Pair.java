package Classes;
public class Pair<E> {
	private E first;
	private E second;
	
	
	public Pair(E a, E b) {
		first=a;
		second=b;
	}
	public E first() {
		// TODO Auto-generated method stub
		return first;
	}

	public E second() {
		// TODO Auto-generated method stub
		return second;
	}
	
	public String toString() {
		return "this is the pair: (" + first + ", " + second + ")";
	}

}
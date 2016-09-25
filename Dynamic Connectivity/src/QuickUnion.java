/**
 * This is my implementation of the
 * Quick Union algorithm for solving the dynamic connectivity problem. 
 * It is a lazy algorithm. 
 * @author Kalvin Lam
 *
 */
public class QuickUnion {
	
	public static int[] ids;
	
	/**
	 * Constructor to initialize ids with int array with correct # of ids
	 * @param n number of objects
	 */
	public QuickUnion(int n) {
		ids = new int[n];
		 //initialize array
		for(int i = 0; i < ids.length; i++) {
			ids[i] = i;
		}
	}
	
	/**
	 * 
	 * @param i ith item
	 * @return the root of the ith item
	 */
	public int root(int i) {
		while(i != ids[i]) {
			i = ids[i];
		}
		return i;
	}
	
	/**
	 * Union method to merge components together
	 * Take root of the component containing the first item and 
	 * make it a child of root of component containing second item
	 * @param p index of first component to merge
	 * @param q index of second component to merge
	 */
	public void union(int p, int q) {
		ids[root(p)] = root(q);
	}
	
	/**
	 * Returns true if p and q are connected, false otherwise
	 * P and q are connected if they have the same root
	 * @param p index of first component
	 * @param q index of second component
	 * @return true if p and q are connected, false if not
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public static void main(String[] args) {
		QuickUnion q = new QuickUnion(5);
		q.union(1,2);
		
		for(int i: ids) {
			System.out.println(i);
		}
		System.out.println();
		
		q.union(3,4);
		
		for(int i: ids) {
			System.out.println(i);
		}
		System.out.println();
		
		q.union(1,4);

		for(int i: ids) {
			System.out.println(i);
		}
		
		System.out.println();
		
		System.out.println(q.connected(1,3));
		System.out.println(q.connected(2,3));
		System.out.println(q.connected(4,3));

//		System.out.println(q.root(0));
//		System.out.println(q.root(8));
//		System.out.println(q.connected(0,4));
//		System.out.println(q.connected(1,2));
//		System.out.println(q.connected(2,3));
	}

}

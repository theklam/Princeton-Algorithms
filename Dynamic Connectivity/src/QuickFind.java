/**
 * This is my implementation of the
 * Quick Find algorithm for solving the dynamic connectivity problem. 
 * It is an eager algorithm. 
 * @author Kalvin Lam
 *
 */
public class QuickFind {
	
	public static int[] ids;
	
	/**
	 * Constructor to initialize ids with int array with correct # of ids
	 * @param n number of objects
	 */
	public QuickFind(int n) {
		ids = new int[n];
		 //initialize array
		for(int i = 0; i < ids.length; i++) {
			ids[i] = i;
		}
	}
	
	/**
	 * Union method to merge components together
	 * Will change the id of all elements with id id[p] to id[q]
	 * @param p index of first component to merge
	 * @param q index of second component to merge
	 */
	public void union(int p, int q) {
		int idP = ids[p];
		for(int i = 0; i < ids.length; i++) {
			if(ids[i] == idP) {
				ids[i] = ids[q];
			}
		}
	}
	
	/**
	 * Returns true if p and q are connected, false otherwise
	 * @param p index of first component
	 * @param q index of second component
	 * @return true if p and q are connected, false if not
	 */
	public boolean connected(int p, int q) {
		return ids[p] == ids[q];
	}

	public static void main(String[] args) {
		QuickFind q = new QuickFind(5);
		q.union(0, 4);
		q.union(1, 2);
		q.union(0,1);
		for(int i: ids) {
			System.out.println(i);
		}
		System.out.println(q.connected(0,4));
		System.out.println(q.connected(1,2));
		System.out.println(q.connected(2,3));
	}

}

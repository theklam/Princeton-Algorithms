/**
 * This is my implementation of the Quick Union algorithm for solving the
 * dynamic connectivity problem. It is a lazy algorithm.
 * 
 * @author Kalvin Lam
 *
 */
public class QuickUnionWeighted {

	public static int[] ids;
	public static int[] numObjects;

	/**
	 * Constructor to initialize ids with int array with correct # of ids
	 * 
	 * @param n
	 *            number of objects
	 */
	public QuickUnionWeighted(int n) {
		ids = new int[n];
		numObjects = new int[n];
		// initialize array
		for (int i = 0; i < ids.length; i++) {
			ids[i] = i;
			numObjects[i] = 1;
		}
	}

	/**
	 * 
	 * @param i
	 *            ith item
	 * @return the root of the ith item
	 */
	public int root(int i) {
		while (i != ids[i]) {
			i = ids[i];
		}
		return i;
	}

	/**
	 * Union method to merge components together Take root of the component
	 * containing the first item and make it a child of root of component
	 * containing second item
	 * 
	 * @param p
	 *            index of first component to merge
	 * @param q
	 *            index of second component to merge
	 */
	public void union(int p, int q) {
		if (numObjects[root(p)] > numObjects[root(q)]) {
			numObjects[root(p)] += numObjects[root(q)];
			ids[root(q)] = root(p);
		}

		else {
			numObjects[root(q)] += numObjects[root(p)];
			ids[root(p)] = root(q);
		}
	}

	/**
	 * Returns true if p and q are connected, false otherwise P and q are
	 * connected if they have the same root
	 * 
	 * @param p
	 *            index of first component
	 * @param q
	 *            index of second component
	 * @return true if p and q are connected, false if not
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public static void main(String[] args) {
		QuickUnionWeighted q = new QuickUnionWeighted(5);

		for (int i : ids) {
			System.out.println(i);
		}
		System.out.println();

		q.union(1, 2);

		for (int i : ids) {
			System.out.println(i);
		}
		System.out.println();

		System.out.println("Num Objects Array");

		for (int i : numObjects) {
			System.out.println(i);
		}

		System.out.println();

		q.union(3, 4);

		for (int i : ids) {
			System.out.println(i);
		}
		System.out.println();

		System.out.println("Num Objects Array");

		for (int i : numObjects) {
			System.out.println(i);
		}

		System.out.println("q.union(0,4)");

		q.union(0, 4);

		for (int i : ids) {
			System.out.println(i);
		}

		System.out.println();

		System.out.println("Num Objects Array");

		for (int i : numObjects) {
			System.out.println(i);
		}

		System.out.println();

		q.union(3, 1);

		for (int i : ids) {
			System.out.println(i);
		}

		System.out.println();

		System.out.println();

		System.out.println("Num Objects Array");

		for (int i : numObjects) {
			System.out.println(i);
		}

		System.out.println();

		System.out.println(q.connected(1, 3));
		System.out.println(q.connected(2, 3));
		System.out.println(q.connected(4, 3));

		// System.out.println(q.root(0));
		// System.out.println(q.root(8));
		// System.out.println(q.connected(0,4));
		// System.out.println(q.connected(1,2));
		// System.out.println(q.connected(2,3));
	}

}

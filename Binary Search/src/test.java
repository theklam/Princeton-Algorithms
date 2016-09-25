
public class test {

	public static int mid, lo, hi, counter = 0;
	public static int binarySearch(int[] a, int key) {
		lo = 0; 
		hi = a.length - 1;
		printInfo();
		
		while(lo <= hi) {
			mid = lo + (hi - lo) / 2;
			//mid = (hi - lo) / 2;
			if(counter < 50) {
				printInfo();
			}
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(binarySearch(a,18));
	}
	
	public static void printInfo() {
		System.out.println("lo is " + lo);
		System.out.println("hi is " + hi);
		System.out.println("mid is " + mid);
		System.out.println("counter is " + counter);
		counter++;
		
		System.out.println();
		System.out.println();
	}
	
}

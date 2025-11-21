// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {

		if (x2 > 0) {
				for (int i = 0; i < x2; i++){
				x1++;
				} 	
		}

		else {
			for (int i = 0; i > x2; i--){
			x1--;
			}
		}
	
		return x1;
	}




	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		if (x2 > 0) {
				for (int i = 0; i < x2; i++){
				x1--;
				}
		}

		else {
				for (int i = 0; i > x2; i--){
				x1++;
				}
		}		
		return x1;
	}



	// Returns x1 * x2
	public static int times(int x1, int x2) {

		if (x1 == 0 || x2 == 0) return 0;

		int holder1 = x1;

		if ((x1 > 0 && x2 > 0) ) {

			for (int i = 1; i < x2; i++){

				for (int j = 0; j < holder1; j++){
				x1++;
				}

			}	
			return x1;
		}

		else if ((x1 < 0 && x2 < 0)){
			

			for (int i = 0; i < 2; i++){ // this "if" statement returns the absolute value of the negative int x1"
										 // I wasn't sure if I was allowed to use Math.abs(), that's why I wrote the code like this
				for (int j = 0; j > holder1; j--){
				x1++;
				}

			}	

			for (int i = -1; i > x2 ; i--){ // this one actually multiplies x1 and x2

				for (int j = 0; j > holder1; j--){
				x1++;
				}
			}
		}

		else {

			if (x2 < 0) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
				holder1 = x1;
			}

			for (int i = 1; i < x2 ; i++){ // this one actually multiplies x1 and x2

				for (int j = 0; j > holder1; j--){
				x1--;
				}
			}	
		}
			return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		int result;

		if (n == 0) result = 1;
		
		else result = x;

		for (int i = 1 ; i < n; i++){
			
			result = times(result,x);

		}

		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {

		if (x1 == 0 || x2 == 0) return 0;
		
		int i = 0;

		if (x1 < 0 && x2 > 0) {

			while (times(i, x2) < times(x1, -1)) i++;

			if (times(i, x2) == times(x1, -1)) return times(i, -1);
		
			return plus(times(i, -1),1);
		}

		else if (x1 > 0 && x2 < 0) {

			while (times(i, times(x2, -1)) < x1) i++;

			if (times(i, times(x2, -1)) == times(x1, -1)) return times(i, -1);
		
			return plus(times(i, -1),1);
		}

		else if (x1 > 0 && x2 > 0){

			while (times(i, x2) < x1) i++;

			if (times(i, x2) == x1) return i;
		
			return minus(i,1);
		}

		else {

			while (times(i, times(x2, -1)) < times(x1, -1)) i++;

			if (times(i, x2) == x1) return i;
		
			return minus(i,1);
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {

		int result = minus(x1, times(x2, div(x1, x2)));

		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {

		int a = 0;

		while (times(a, a) < x) a++;

		if (times(a, a) == x) { return a;
			
		}

		return minus(a, 1);

	
	}	  	  
}
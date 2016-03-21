import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;

//Suppose large numbers are stored in a list of integers.  Write
//   functions for adding and subtracting large numbers.
public class Problem2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		int b=10;//set base==10
		System.out.println("Enter Number1");
		int d1= scan.nextInt();
		//store number1 in list 1
		List<Integer> list1=new LinkedList<>();
		putIntoList(d1,list1,b);
		
		System.out.println("Enter Number2");
		int d2= scan.nextInt();
		scan.close();
		
		//store number2 in list 2
		List<Integer> list2=new LinkedList<>();
		putIntoList(d2,list2,b);

		//Addition of Two Numbers
		List<Integer> outList=new LinkedList<Integer>();
		add(list1,list2,outList,b);
		System.out.println("Addition of Numbers = "+printNumber(outList,b));
		
		//Subtraction of two numbers
		List<Integer> outList1=new LinkedList<Integer>();
		subtract(list1,list2,outList1,b);
		System.out.println("Subtraction of Numbers = "+printNumber(outList1,b));
	}//end main method

	//Assumption that x>=y
	private static void subtract(List<Integer> x, List<Integer> y, List<Integer> z, int b) {
		int difference=0;
		Iterator<Integer> itr1=x.iterator();
		Iterator<Integer> itr2=y.iterator();
		Integer a1 =next(itr1); 
		Integer b1=next(itr2);

		while(a1!=null &&b1!=null){
			if(a1>b1){
				difference=(a1-b1);
				z.add(difference);
				a1=next(itr1);
				b1=next(itr2);
			}
			else{
				difference=b+a1-b1;
				z.add(difference);  
				a1=next(itr1)-1;
				b1=next(itr2);
			}
		}
   //first number remaining traversal
	while(a1!=null){
		z.add(a1);
		a1=next(itr1);
	}
	
	}

	private static long printNumber(List<Integer> outList, int b) {
		long number=0;long index=0;
		for(Integer i:outList){
			number+=(i*Math.pow(10, index));
			index++;
		}
		return number;

	}

	private static void putIntoList(int d, List<Integer> list,int b) {
		if(d==0) list.add(d);
		while(d!=0){
			list.add(d%b);
			d=d/b;
		}

	}

	public static void add(List<Integer> x, List<Integer>  y,List<Integer> z, int b) {
		// Return z = x + y.  Numbers are stored using base b.
		// The "digits" are stored in the list with the least
		// significant digit first.  For example, if b = 10, then
		// the number 709 will be stored as 9 -> 0 -> 7.
		// Assume that b is small enough that you will not get any
		// overflow of numbers during the operation.
		int sum=0;
		Iterator<Integer> itr1=x.iterator();
		Iterator<Integer> itr2=y.iterator();
		Integer a1 = next(itr1); 

		Integer b1=next(itr2);

		while(a1!=null &&b1!=null){
			sum+=(a1+b1);
			z.add(sum%b);
			sum=sum/b;		
			a1=next(itr1);
			b1=next(itr2);
		}
		while(a1!=null){
			sum+=(a1+sum);
			z.add(sum%b);
			sum=sum/b;
			a1=next(itr1);
		}
		while(b1!=null){
			sum+=(b1+sum);
			z.add(sum%b);
			sum=sum/b;
			b1=next(itr2);	
		}
		z.add(sum);


	}

	private static Integer next(Iterator<Integer> itr) {
		if(itr.hasNext()){
			return itr.next();
		}
		else return null;
	}





}//end class

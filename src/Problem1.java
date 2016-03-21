//!.Intersection two sets: Input list is implementing sorted set so No duplicates are allowed
//Given two linked lists implementing sorted sets, write functions for
//   union, intersection, and set difference of the sets.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Max element of list#1:");
		int n1= scan.nextInt();
		System.out.println("Enter Max Element limit of list#2:");
		int n2= scan.nextInt();
		scan.close();
		List<Integer> list1=new LinkedList<>();
		List<Integer> list2=new LinkedList<>();
	    List<Integer> out=new LinkedList<>();
	    List<Integer> out1=new LinkedList<>();
		List<Integer> out2=new LinkedList<>();
	    //adding elements in lists
		for(int i=0;i<n1;i+=2){
	    	list1.add(i);	
		
	    }
		for(int i=5;i<n2;i++){
	    		
		    list2.add(i);
	    }
		System.out.println("List1 "+list1);
		System.out.println("List2 "+list2);
		intersect(list1,list2,out);
		System.out.println("Intersection OutputList "+out);
        union(list1,list2,out1);
        System.out.println("Union OutputList "+out1);
        difference(list1,list2,out2);
        System.out.println("Difference OutputList "+out2);
	}

	private static <T extends Comparable<? super T>>boolean BST(List<T> b,int start,int end,T x) {
		while(start<=end){
			int middle=(start+end)/2;
			if(b.get(middle)==x) return true;
			else if(x.compareTo(b.get(middle))<0){
				end=middle-1;
			}
			else{
				start=middle+1;
			}
		}
		
	return false;
	}
	private static <T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
		//performing L1-L2
		
		if(l1.size()==0){ outList=l1;return;} //checking for one of the list is empty
		if(l2.size()==0){ outList=l1;return;}//if list is empty then Union is another List
		Iterator<T> itr1=l1.iterator();
	
		while(itr1.hasNext()){
			T a=itr1.next();
			if(BST(l2, 0, l2.size()-1, a)){
				
			}
			else{
				outList.add(a);
			}
		}	
	}

	private static <T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
		
		if(l1.size()==0){ outList=l2;return;} //checking for one of the list is empty
		if(l2.size()==0){ outList=l1;return;}//if list is empty then Union is another List
		Iterator<T> itr1=l1.iterator();
		Iterator<T> itr2=l2.iterator();
		T a=itr1.next();//store first element
		T b=itr2.next();
		while(itr1.hasNext()&&itr2.hasNext()){
			  
			if(a.compareTo(b)<=0){
				if(!outList.contains(a))
					outList.add(a);
				a=itr1.next();
			
			}
			else if(a.compareTo(b)>0){
				if(!outList.contains(b))
					 outList.add(b);
				b=itr2.next();
			 
			}
			
		}
		if(a.compareTo(b)==0){
			if(!outList.contains(a))
		      outList.add(a);
		}
		while(itr1.hasNext()){
			a=itr1.next();
			if(!outList.contains(a))
		outList.add(a);
		
		
	}
	while(itr2.hasNext()){
		b=itr2.next();
		if(!outList.contains(b)) 
		outList.add(b);   
		
			
		}
	
	
}

	private static <T extends Comparable<? super T>>void intersect(List<T> l1, List<T> l2, List<T> outList) {
		Iterator<T> itr1=l1.iterator();
		Iterator<T> itr2=l2.iterator();
		if(l1.size()==0){ outList=l1;return;} //checking for one of the list is empty
		if(l2.size()==0){ outList=l2;return;}//if list is empty then intersection  is also empty
	
		T a=itr1.next();//store first element
		T b=itr2.next();
			while(itr1.hasNext()&&itr2.hasNext()){
			  
			if(a.compareTo(b)<0){
			a=itr1.next();
			}
			else if(a.compareTo(b)>0){
			 b=itr2.next();
			}
			else if(a.compareTo(b)==0){
				 outList.add(a);
				 a=itr1.next();
				 b=itr2.next();
			}
		}
		
			while(itr1.hasNext()&&a.compareTo(b)<0)	
		      a=itr1.next();
		
		while(itr2.hasNext()&&a.compareTo(b)>0)
			b=itr2.next();
		
		if(a.compareTo(b)==0){
			outList.add(a);
		}
	
		
		
		
	}

}

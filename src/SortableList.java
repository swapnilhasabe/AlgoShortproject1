// merging sorted linked lists 
public class SortableList<T extends Comparable<? super T>>extends SinglyLinkedList<T> {
	 public Entry<T> merge(Entry<T> a,Entry<T> b) {
		Entry<T> mergeList=null;
		  if(a==null) return b;
		        else if(b==null) return a;
		if(a.element.compareTo(b.element)<=0){
			mergeList=a;
			mergeList.next=merge(a.next,b);
		}
		else if(a.element.compareTo(b.element)>0){
			mergeList=b;
			mergeList.next=merge(a,b.next);
		}
		 
		 return mergeList;

	    }

	public void partition(Entry<T> head,Entry<T> front,Entry<T> back){
	Entry<T> temp1=head;
	Entry<T> slow;
	Entry<T> fast;
	if(head==null||head.next==null){
		front=head;
		back=null;
	}
	else{
		slow=head;
		fast=head.next;
	while(fast!=null){
		fast=fast.next;
		if(fast!=null){
			slow=slow.next;
			fast=fast.next;
		}
	}
 front=temp1;
 back=slow.next;	
 }
}
	 
	 public void mergeSort(Entry<T> header) {
      Entry<T> temp=header;
      Entry<T> a=null;
	  Entry<T> b=null; 
	  if(temp==null||temp.next==null){
		    return;  	    
	    }
	 partition(temp,a,b);
	 mergeSort(a);
	 mergeSort(b);
	 header=merge(a,b);	 
	
	 }
	
	public static void main(String[] args) {
		  int n = 10;
		  
	        if(args.length > 0) {
	            n = Integer.parseInt(args[0]);
	        }

	        SortableList<Integer> lst = new SortableList<>();
	      
	        for(int i=1; i<=4; i++) {
	            lst.add(new Integer(n-i));
	        }
	        lst.printList();
	        lst.mergeSort(lst.header);
	        lst.printList();

	}//main method

}//end class

package com.example;



public class HeapSortDemo {

	   public HeapSortDemo()
       {
               System.out.println("Heap Sort");

               		
                       int[] A = new int[] {4,1,3,2,16,9,10,14,8,7};
                       System.out.println("Unsorted array");
                       for (int i : A)
                       {
                               System.out.print(String.format("%5d", i));
                       }
                       System.out.println();
                       heapSort(A);

                       System.out.println("Sorted array");
                       for (int i : A)
                       {
                               System.out.print(String.format("%5d", i));
                       }
                       System.out.println();
               }
	
	   
	
	public  void build_max_heap(int [] arr){
		for(int i=arr.length/2;i>=0;i--){
			max_heapify(arr, arr.length, i);
		}
	}
	
	public  void heapSort(int [] arr){
		//first build the initial max_heap
		build_max_heap(arr);
		int heap_size=arr.length;
		for(int i=arr.length-1;i>=1;i--){
			int exchange=arr[i];
			arr[i]=arr[0];
			arr[0]=exchange;
			//decrease the heap size by 1 
			heap_size--;
			max_heapify(arr, heap_size, 0);
		}
		
	}
	
	public void max_heapify(int [] arr, int heapsize,int index){
		
		int left=left(index);
		int right=right(index);
		int largest;
		if(left<heapsize && arr[index]>arr[left])
			largest=index;
			else
			largest=left;
		if(right<heapsize && arr[largest]<arr[right])
			largest=right;
		if(largest!=index){
			//swap arr[index] and arr[largest]
			 int exchange = arr[index];
             arr[index] = arr[largest];
             arr[largest] = exchange;

			//perform max_heapify with index as largest
			max_heapify(arr,heapsize, largest);
		}
		
	}
	
	
	public  int left(int i){
		return i*2;
	}
	public  int right(int i){
		return 2*i+1;
	}
	
	public  int parent(int i){
		return i/2;
	}
	   public static void main(String[] args) {
			int[] arr = new int[] {4,1,3,2,16,9,10,14,8,7};
			new HeapSort();
			
		}
		

}

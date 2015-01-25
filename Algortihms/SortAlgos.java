package com.example;

public class SortAlgos {

	
	// merge sort
	
	
	void merge(int arr[],int l,int m,int r){
		int i,j,k;
		int n1=m-l+1;
		int n2=r-m;
		
		int[] L=new int[n1];
		int [] R=new int[n2];
		
		for(i=0;i<n1;i++){
			L[i]=arr[l+i];
		}
		
		for(j=0;j<n2;j++){
			R[j]=arr[j+m+1];	
		}
		
		i=0;j=0;k=1;
		
		
		while(i<n1 && j<n2){
			
			if(L[i]<=R[j]){
				
				arr[k]=L[i];
				i++;
			}
			else{
				arr[k]=R[j];
				j++;
			}
			
			k++;
		}
		
		while(i<n1){
			
			
		arr[k]=L[i];
		i++;
		k++;
			
			
		}
		
		while(j<n2){
			
			arr[k]=R[j];
			k++;
			j++;
			
		}
		
		
		
		
	}
	
	void mergeSort(int[] arr,int l,int r){
		
		
		if(l<r){
			// find middle element 
			int m=l+(r-l)/2;
			//sort the array according to the mergesort 
			mergeSort(arr,l,m);
			// sort the array according to the mergesort
			mergeSort(arr, m+1, r);
			
			//merge the 2 half
			merge(arr,l,m,r);
			
		}
	}

	void selectionSort(int [] arr){
	
		// selection sort procedure find the min element  and then swaps it with the first element 
		
		int length=arr.length;
		for(int i=0;i<length-1;i++){
			int min_idx=i;
			for(int j=i+1;j<length;j++)
				if(arr[j]<arr[min_idx]){
					min_idx=j;	
			}
			
			int temp=arr[min_idx];
			arr[min_idx]=arr[i];
			arr[i]=temp;
		}
		
		
	}
	
	
	static void bubbleSort(int []arr){
		
		for(int i=0;i<arr.length;i++){
			
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
		
	}
	
	void printArray(int [] arr){
		for(int i=0;i<=arr.length-1;i++){
			System.out.println("arr["+i+"]=="+arr[i]);
		}
	}
	
	public static void main(String[] args) {
		
		
		SortAlgos sa=new SortAlgos();
		int []arr=new int[]{1,5,3,7,87,34,31,0,6};
		sa.selectionSort(arr);
		//sa.printArray(arr);
		
		bubbleSort(arr);
		sa.printArray(arr);
		

	}
	}
	

	
	
//}

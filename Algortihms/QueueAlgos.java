package com.example;

class Queue{
	
	int front ,rear,size;
	int capacity ;
	int [] arr;
	
	
}
public class QueueAlgos {

	
	public static Queue createQueue(int capacity){
		Queue q=new Queue();
		q.capacity=capacity;
		q.front=0;
		q.size=0;
		q.rear=capacity-1;
		q.arr=new int[capacity];
		
		return q;
	}
	
	public static boolean isFull(Queue queue){
		return (queue.size==queue.capacity);
	}
	
	public static boolean isempty(Queue queue){
		return (queue.size==0);
		
	}
	 static void enqueue(Queue queue,int item){
		
		if(isFull(queue))
			return;
		queue.rear=(queue.rear+1)%queue.capacity;
		queue.arr[queue.rear]=item;
		queue.size=queue.size+1;
		System.out.println("item "+item+"enqueued to the queue");
		
	}
	public static int dequeue(Queue queue)
	{
		if(isempty(queue)){
			return Integer.MIN_VALUE;
		}
		int item=queue.arr[queue.front]; 
		queue.front=(queue.front+1)%queue.capacity;
		queue.size=queue.size-1;
		return item;
		
	}
	
	static int front( Queue queue)
	{
	    if (isempty(queue))
	        return Integer.MIN_VALUE;
	    return queue.arr[queue.front];
	}
	 
	// Function to get rear of queue
	static int rear( Queue queue)
	{
	    if (isempty(queue))
	        return Integer.MIN_VALUE;
	    return queue.arr[queue.rear];
	}
	
	public static void main(String[] args) {
		
		
		   Queue queue = QueueAlgos.createQueue(1000);
		  
		   QueueAlgos. enqueue(queue, 10);
		    enqueue(queue, 20);
		    enqueue(queue, 30);
		    enqueue(queue, 40);
		 
		    System.out.println("dequeued from queue\n"+dequeue(queue));
		 
		    System.out.println("Front item is:"+ front(queue));
		   System.out.println("Rear item is :"+rear(queue));
		 
		    

		
		
	}

}

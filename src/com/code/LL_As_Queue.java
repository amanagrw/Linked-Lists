package com.code;

public class LL_As_Queue {
    private LinkedList queue;

    public LL_As_Queue(){
        this.queue = new LinkedList();
    }

     public int size(){
        return this.queue.getSize();
     }

     public boolean isEmpty(){
        return this.queue.isEmpty();
     }

     public void enqueue(int item){
        this.queue.addLast(item);
     }

     public int dequeue() throws Exception{
        return this.queue.removeFirst();
     }

     public int front() throws Exception{
        return  this.queue.getFirst();
     }

     public void display(){
        this.queue.display();
     }
}

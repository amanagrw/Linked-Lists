package com.code;

public class LL_As_Stack {
    private LinkedList stack;

    public LL_As_Stack(){
        this.stack = new LinkedList();
    }

    public void push(int item){
        this.stack.addFirst(item);
    }

    public int pop() throws Exception{
        return this.stack.removeFirst();
    }

    public int getTop() throws Exception{
        return this.stack.getFirst();
    }

    public int size(){
        return this.stack.getSize();
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }

    public void display(){
        this.stack.display();
    }
}

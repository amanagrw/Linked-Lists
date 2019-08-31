package com.code;

public class LinkedList {

    private class Node{
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    //O(n)
    public void display(){

        System.out.println("=====================");
        Node temp = this.head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //O(n)
    public int getAt(int idx) throws Exception {

        if(this.size == 0){
            throw new Exception("Empty Linked List");
        }

        if(idx < 0 || idx >= this.size){
            throw new Exception("Invalid Index");
        }

        Node temp = this.head;
        for (int i = 1; i <= idx; i++) { //the point at which temp leaves loop it will have desired data
            temp = temp.next;
        }

        return temp.data;
    }

    //method made private so that user doesn't get access to address of any node
    //O(n)
    private Node getNodeAt(int idx) throws Exception {

        if(this.size == 0){
            throw new Exception("Empty Linked List");
        }

        if(idx < 0 || idx >= this.size){
            throw new Exception("Invalid Index");
        }

        Node temp = this.head;
        for (int i = 1; i <= idx; i++) { //the point at which temp leaves loop it will have desired data
            temp = temp.next;
        }

        return temp;
    }

    //O(n)
    public void addAt(int idx, int item) throws Exception {

        if(idx < 0 || idx > size){
            throw new Exception("Invalid Index");
        }

        if(idx == 0){
            addFirst(item);
        }else if(idx == this.size){
            addLast(item);
        }else{

            //create new node
            Node nn = new Node();
            nn.data = item;
            nn.next = null;

            //attach
            Node nm1 = getNodeAt(idx - 1);
            Node np1 = nm1.next;

            nm1.next = nn;
            nn.next = np1;

            //update summary object
            this.size++;
        }
    }

    //O(1)
    public int removeFirst() throws Exception {

        if(this.size == 0){
            throw new Exception("Linked List is empty.");
        }

        //Capture data
        int rv = head.data;

        //Update according to two cases
        if(this.size == 1){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }else{
            this.head = this.head.next;
            this.size--;
        }
        return rv;
    }

    //O(1)
    public int getFirst() throws Exception {

        //Condition to avoid Null Pointer Exception
        if(this.size == 0){
            throw new Exception("Linked List is empty.");
        }
        return this.head.data;
    }

    //O(1) - benefit of using tail
    public int getLast() throws Exception {

        //Condition to avoid Null Pointer Exception
        if(this.size == 0){
            throw new Exception("Linked List is empty.");
        }
        return this.tail.data;
    }

    //O(1)
    public void addLast(int item){

        Node nn = new Node();

        nn.data = item;
        nn.next = null;

        if(this.size > 0){
            this.tail.next = nn;
        }

        if(this.size == 0){
            this.head = nn;
            this.tail = nn;
            this.size++;
        }else{
            this.tail = nn;
            this.size++;
        }
    }

    //O(1)
    public void addFirst(int item){

        //Create new node
        Node nn = new Node();
        nn.data = item;
        nn.next = null;

        //attach if size > 0
        if(this.size > 0){
            nn.next = this.head;
        }

        //update summary object
        if(this.size > 0){
            this.head = nn;
            this.size++;
        }else{
            this.head = nn;
            this.tail = nn;
            this.size++;
        }
    }


}

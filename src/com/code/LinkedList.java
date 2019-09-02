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

        Node temp = this.head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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
            Node nm1 = getNodeAt(idx - 1);   //makes overall complexity of method as O(n)
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

        //Update summary objects according to two cases
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

    //upto O(n) as getNodeAt() is being used
    public int removeLast() throws Exception {

        if(this.size == 0){
            throw new Exception("Linked List is empty.");
        }

        int rv = this.tail.data;

        if(this.size == 1){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }else{
            Node nm1 = getNodeAt(size - 2);

            //detach
            nm1.next = null;

            //update summary object
            this.tail = nm1;
            this.size--;
        }
        return rv;
    }

    //Upto O(n)
    public int removeAt(int idx) throws Exception{

        if(this.size == 0){
            throw new Exception("Empty Linked List");
        }

        if(idx < 0 || idx >= this.size){
            throw new Exception("Invalid Index");
        }

        if(idx == 0){
            return removeFirst();
        }else if(idx == size - 1){
            return removeLast();
        }else{
            Node nm1 = getNodeAt(idx - 1);
            Node n = nm1.next;
            Node np1 = n.next;

            //detach
            nm1.next = np1;

            //update summary object
            this.size--;

            return n.data;
        }
    }

    //First method to reverse a linked list without affecting pointers
    //Use two variables - left and right
    public void reverseData() throws Exception{

        int left = 0;
        int right = this.size - 1;

        while(left < right){

            Node ln = getNodeAt(left);
            Node rn = getNodeAt(right);

            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;

            left++;
            right--;
        }
    }

    //Second method to reverse a linked list
    //Use three pointers - prev, current and ahead
    public void reversePointers(){

        Node prev = this.head;
        Node current = prev.next;

        while(current != null){
            Node ahead = current.next;
            current.next = prev;

            prev = current;
            current = ahead;
        }

        //Swap head and tail
        Node t = this.head;
        this.head = this.tail;
        this.tail = t;

        this.tail.next = null;
    }

    public int getMidNodeData(){
        Node slow = this.head;
        Node fast = this.head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
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

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.size == 0)
            return true;
        else
            return false;
    }

}

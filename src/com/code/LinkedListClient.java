package com.code;

public class LinkedListClient {
    public static void main(String[] args) throws Exception{

        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        System.out.println(ll.removeLast());
        ll.display();


    }
}

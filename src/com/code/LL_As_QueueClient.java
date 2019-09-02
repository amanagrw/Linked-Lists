package com.code;

public class LL_As_QueueClient {
    public static void main(String[] args) throws Exception {
        LL_As_Queue q = new LL_As_Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        q.dequeue();
        q.display();

        System.out.println(q.front());
        System.out.println(q.isEmpty());

    }
}

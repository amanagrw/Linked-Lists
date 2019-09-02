package com.code;

public class LL_As_StackClient  {

    public static void main(String[] args) throws Exception {
        LL_As_Stack s = new LL_As_Stack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.display();

        s.pop();
        s.display();

        System.out.println(s.getTop());

    }

}

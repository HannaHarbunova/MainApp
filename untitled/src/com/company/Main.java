package com.company;

//public class Main {
//
//    public static void main(String[] args) {
//	// write your code here
//    }
//}
public class Main {
    public int CalcMe(int n)
    {
        return n < 1 ? 1 : n*CalcMe(n-1);
    }

}


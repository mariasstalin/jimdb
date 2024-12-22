package com.stanrnd.jimdb;

public class SimpleLoop {
 
    public static void main(String[] args) {
        int N = 2;
        
        int counter = 0;
        for (int i = 0; i < N; i = i + 1) {
        	counter = counter + 1;
        }
        
        assert(counter == N);
    }                           

}
package com.stanrnd.jimdb;

public class SimpleFalsePositive {
 
    public static void main(String[] args) {
        int N = 10;
        
        int counter = 0;
        for (int i = 0; i < N; i = i + 1) {
        	counter = counter + 1;
        }
        
        assert(counter == N - 1);
    }                           

}
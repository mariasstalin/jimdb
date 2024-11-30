/*
The following is a simple file (copied from https://www.cprover.org/jbmc/)
to validate repo setup and ensure that JBMC is able to run
*/
package com.stanrnd.jimdb;
 
public class Simple {
 
    public static void main(String[] args) {
        String s = new String("Abc");
        String u = "bc";
        assert(!s.contains(u));
        // This assert failure should be found by JBMC!
    }                           

}
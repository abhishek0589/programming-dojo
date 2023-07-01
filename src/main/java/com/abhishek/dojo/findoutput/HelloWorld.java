package com.abhishek.dojo.findoutput;

public class HelloWorld {
	 
    public static void main(String []args){
       System.out.println("Hello World");
       trouble();
    }
   
    public static void trouble() {
        try {
            Object myObject = createMeObject();
            throw new Exception();
        } catch (Exception ex) {
            trouble();
        }
    }
   
    public static Object createMeObject() {
        return new Object();
    }
}

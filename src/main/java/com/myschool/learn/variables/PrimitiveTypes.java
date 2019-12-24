package com.myschool.learn.variables;

public class PrimitiveTypes {
    public static void main(String[] args) {
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Integer Minimum Value : " + myMinIntValue);
        System.out.println("Integer Maximum Value : " + myMaxIntValue);

    }
}



/*
Wrapper Classes -
Java uses the concept of a wrapper class for all 8 primitive types - In the case of an int,
we can use Integer and by doing that it give us ways to perform operations on an int.
Integer.MIN_VALUE;
Integer.MAX_VALUE;
In this case, we are using the MIN_VALUE and MAX_VALUE to get java to tell us the minimum
and maximum ranges of numbers that can be stored.
 */
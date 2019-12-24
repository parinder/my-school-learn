package com.myschool.learn.basic;

public class FirstProgram {

    private String message = "This is my First Program in Java - Dec 1, 2019 12:22 PM";

    public static void main(String[] args) {

        System.out.println("This is my First Program in Java - Dec 1, 2019 12:22 PM");
    }

    public String getMessage() {

        return message;
    }
}
/*
#3
public- The public java keyword is an access modifier. An access modifier allows us to define the scope or how other parts of
your code or even some else's code can access this code.

class - Defining a class. The class keyword is used to define the a class with the name following the keyword
"FirstProgram" in this case and left & right curly braces to define the class block.

#5
What is method ? -It's a collection of statements that perform an operation.

main - We are using special method called the main method that java looks for when running a program.
It's the entry point of any java code

public -  The Public java keyword is an access modifier. An access modifier allows us to define the scope or how other parts of
your code or even some else's code can access this code.

static - No need Object to run this class

void - Void is yet another keyword used to indicate that the method will not return anything.

 */

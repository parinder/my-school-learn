package com.myschool.learn.variables.challenge;

/*

Create Additional Variables
Declare the following variables and add to our program.
mySecondNumber which is an int and assign a value of 12 to it.
myThirdNumber, also an int with a value of 6.
Add all the 3 variables and print.

Create a new Variable call myLastOne.
We want the value to be 1000 less the current value of myTotal - the data type is an int.
Print out the value of myLastOne

 */

public class FirstVariableChallenge {
    public static void main(String[] args) {
        int myFirstVariable = (10 + 5) + (2 * 10);
        int mySecondVariable = 12;
        int myThirdVariable = 6;
        int myTotal = myFirstVariable + mySecondVariable + myThirdVariable;
        int myLastOne=1000-myTotal;
        System.out.println("Sum of all variable is : " + myTotal);
        System.out.println("The value of myLastOne variable is :"+myLastOne);

    }
}

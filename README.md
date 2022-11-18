Submit your code to this folder!Testing

This week we will be focusing on using and creating tests to make sure that your code works as intended.

💀 Deadline

This work should be completed before the exercise on Friday 18th November.

👩‍🏫 Instructions

For instructions on how to do and submit the assignment, please see the assignments section of the course instructions.

📝 Preparation

Read Module 9: Testing
If you have not done so, goto https://kth.oli.cmu.edu/, signup and register for the course key dd1337-ht22
Additionally, in order to complete this week's assignment you must also be able to run unit tests on your computer. You can run the unit tests either in the terminal or from your editor, following the guides below:

Running JUnit4 from the command line
Using IntelliJ with JUnit4
Note: Visual Studio Code also has support for JUnit4, but unfortunately we have not had the time to make a video tutorial of that.
Important: We use JUnit 4.12 in the INDA courses. Using later or earlier versions of JUnit most likely will not work with our test classes.
Important: It can often be a bit difficult to get up and running with JUnit4. Make sure that you have tried to run the provided test classes as early as possible, and if you can't get it to work, make sure to follow the steps of the 🚨 Troubleshooting Guide.
✅ Learning Goals

This week's learning goals include:

Running JUnit tests
Using failing test cases to identify and remedy bugs
Writing unit tests
Using test driven development
Refactoring code
Optimizing code
🚨 Troubleshooting Guide

If you have any questions or problems, follow this procedure: 

Look at this week's posted issues. Are other students asking about your problem?
If not, post a question yourself by creating a New Issue. Add a descriptive title, beginning with "Task x: summary of problem here"
Ask a TA in person during the weekly lab. Check your schedule to see when the next lab is.
We encourage you to discuss with your course friends, but do not share answers!

🏛 Assignment

You will probably have realized that writing good code that does exactly what you intended can be hard. Even the best programmers have experienced that code that they thought was designed and written correctly still gives the wrong result. Even worse are regressions, where a change you make somewhere in your program causes some other part to stop working.

To detect and be able to solve problems like this, we have the field of software testing. Tests come in many shapes and forms, but a very common form are unit tests, designed to test that a particular method or combination of methods work the way you want.

From this point onwards, testing will be a vital component of the weekly tasks, and you will be asked to both create your own tests and run existing tests on your code before submitting your work. This mimics the way software development is often done in practice, and can help you detect problems in your code

Exercise 9.0 -- Where's that bug?

In the src folder you can find a class called Calculator, which represents a very basic calculator that can add, subtract, multiply and divide. You can also find the test class CalculatorTest, which contains basic unit tests for verifying that the program works as intended.

Your first task is to run these unit tests, following the instructions in the 📝 Preparation section. You should find that most test cases pass, but there is one failing test. Identify which method causes this issue and fix the relevant code in the Calculator class. Run the tests again to make sure everything works correctly.

Assistant's note: Don't remember how to throw exceptions? Have a look at How to throw exceptions!
Exercise 9.1 -- Test driven development

You will soon be adding a new method to the Calculator class, but let's first write the test cases for this method. This way of writing the tests before the actual program code is called test-driven development, and can be very useful. By having the test cases in place before you start, you can see right away when your implementation is working. A potential issue is the temptation to write the code just so that it passes those particular test cases. Remember that no test suite can prove that your code is completely bug free, and can only cover a limited amount of potential inputs.

Add four new test cases for an inverse method in CalculatorTest. This method takes no arguments and give you the multiplicative inverse of the current value stored by the calculator. As an example, if the value is 10, inverse should return 0.1 (1/10).

The tests should verify the following:

inverse gives a correct result for positive values.
inverse gives a correct result for negative values.
inverse throws an IllegalArgumentException when the value is zero.
Applying inverse twice should leave the value unchanged. That is, if value is 7, the result of calling the inverse method twice should set the value to (1/7) / (1/7) = 7.
Take a look at the existing tests to get an idea of how you can write and name your test methods. You can read more about how to write tests for methods that should throw an exception below.

 📚 Testing for exceptions
Using JUnit, a very neat way of asserting an exception is like this:

@Test(expected=IllegalArgumentException.class)
public void aSimpleTestWhereWeExpectAnException() {
    // Test code
}
An important thing to note here is that using this syntax to assert an exception is only appropriate if your test consists of a single act (i.e. one call to the method under @Test), and maybe some trivial arrangement that cannot possibly throw an exception. If there is complex arrangement and several different method calls, the expected exception may be thrown in the wrong place, so the test passes even though it didn't do what you wanted it to. In the case where the test is more complex, it is more appropriate to use a try/catch like this:

@Test
public void moreComplexTestInWhichWeExpectAnException() {
    // Possible arrangement code
    try {
        // The following method call should result in an exception
        someObject.someMethod();
        // If no exception is thrown, we fall through to this fail
        fail("Expected some exception!");
    } catch (SomeException e) {
        // Exception thrown, all good!
    }
    // Possible assert code
}
The tests you write for this task should be simple enough, so you may use the syntax of the first example without worry.

Exercise 9.2 -- Implementing your method

Now that you have written the tests, it is time to actually implement the method. The method should have the header

public double inverse()
Make sure that your method passes the tests you wrote earlier. If a test should fail, remember to also consider the possibility of a bug in your test code, as opposed to in the inverse method itself.

Exercise 9.3 -- The Sieve of Eratosthenes

The Sieve of Eratosthenes (Wikipedia link) is a classic algorithm for finding out which numbers are prime, and which are not. It does so by first assuming that all numbers are prime, and then, starting from 2 (the first prime), marking all multiples (i.e. 4, 6, 8, 10 etc) as not prime, since a multiple of a prime is not a prime (apart from multiplying with 1). After this, it finds the next number that is not a multiple of 2 (3 in this case). This number must be a prime, since it's not a multiple of any smaller prime number, and so we can mark all multiples of 3 as not prime. The process then continues with 5, 7 and so on. The animation below is taken from the Wikipedia entry, and visually illustrates this process:

Sieve animation

Image by Wikipedia user SKopp
In this exercise, you will be given a working but not quite bulletproof implementation of the Sieve algorithm. Your task is to test it, fix the bugs, refactor it, and finally make an optimization.

 🛠 The sieve of Eratosthenes algorithm
Take some time to read through the code, look at the animation and the description and try to get a rough idea of how the algorithm works. A JUnit4 test class with a few tests has also been provided at src/SieveTest.java, and the type of each test (e.g. negative, positive, boundary) is noted.

Once you feel that you have some understanding of the code, let's move on to implementing more tests. In the SieveTest class, there are only positive tests, which test valid inputs. But what happens if we pass values that are not even reasonable to consider for prime status? Implement two tests, isPrimeExceptionWhenNumberIsOne (negative border test) and isPrimeExceptionWhenNumberIsMinusTen (negative test), that assert that isPrime throws an IllegalArgumentException when passed 1 and -10 respectively.

Exercise 9.4 -- Fixing more bugs

If you did Exercise 9.3 correctly, you will notice that isPrime does not throw any exception all when passed 1 (in fact, it thinks that 1 is prime, can you figure out why?), and throws the wrong exception when passed -10. Modify the implementation of isPrime so that it throws an IllegalArgumentException when passed a value less than 2. Make sure to pass along an appropriate error message as well, so the user knows what went wrong.

Exercise 9.5 -- Large primes

The Sieve algorithm has one major weakness: it cannot handle large primes as it is dependent on an array the size of the prime being checked. There are several optimizations that can be implemented to combat this problem, but we will simply set a hard limit of 226 (230 should be safe on most systems and JVMs, but the unit tests would then run for a few seconds more than is optimal). Modify your isPrime method so that the hard limit is imposed and implement the following three tests to test this new boundary:

isPrimeFalseWhenNumberIs2Pow26: Should assert that isPrime returns false when passed 226 (because it is not a prime). This is a positive boundary test.
isPrimeExceptionWhenNumberIs2Pow26Plus1: Should assert that an IllegalArgumentException is thrown when the value 226 + 1 is passed to isPrime. This is a negative boundary test.
isPrimeExceptionWhenNumberIs2Pow28: Should assert that isPrime throws an IllegalArgumentException when passed the value 228. This is just to see that nothing goes wrong after the boundary. This is a negative test.
Assistant's note: To calculate the maximum value, as well as the test values, you may use Math.pow and cast the result to int. It is appropriate to have the maximum allowed value as a private static final field instead of recalculating it on each method call.
Exercise 9.6 -- Refactoring

isPrime is doing a lot right now and is starting to get fairly bloated, so it should be refactored. There are two major and largely unrelated tasks that can be identified:

Error-handling on the input (all of your exception-throwing)
Calculating the prime array.
Write two new helper methods to handle these tasks, with the following headers:

private void exceptionIfIllegalArg(int number)
This method should take care of all exception handling for the number and throw your exceptions as per usual.
private boolean[] sieve(int number)
This method should perform the sieve algorithm and return the prime array.
Your isPrime method should then look like this:

public boolean isPrime(int number) {
    exceptionIfIllegalArg(number);
    boolean[] prime = sieve(number);
    return prime[number];
}
Make sure to run your tests after refactoring to make sure that everything works as before. This is one major advantage of having a test suite, it allows us to refactor and improve our code while still being sure that the existing behavior is preserved.

Exercise 9.7 -- Optimizations

Now it's time to start thinking about how we can optimize our code. Right now, every time isPrime is called, we need to recalculate the prime array. This is very inefficient if we want to check several different numbers. We can solve this by caching the prime array, storing it so that it can be reused. To do this, you need to add primeCache as a field to Sieve, and initialize it as an empty array (whether you do it in a constructor or in-line is up to you). When isPrime(number) is called, you need to check if number >= primeCache.length (but first do the error checking as usual!). If it is, then the number is not an index of the primeCache, and you need to calculate a new array of appropriate size. If number < primeCache.length, you may simply return primeChache[number].

Run your test suite to ensure that the optimization did not break anything (and fix the breakage if it did!).

Exercise 9.8 -- Ideas for more optimizations

As a final exercise, you should try to come up with one or more additional optimizations that could be made to the algorithm. These could be optimizations that would make the code faster or reduce the amount of space required to store the primeCache. You do not need to implement these optimizations (but feel free to do so as long as your updated code still passes the tests). Instead, you should write down your ideas in docs/README.md.

Of course, if you want to implement your ideas you are free to do so as long as your implementation still passes the tests.

Assistant's note: There are several optimizations that can be made to the array and how it is cached. Prime numbers also exhibit some recurring patterns that may be exploited to check fewer numbers.
🐞 Bugs and errors?

If you find any inconsistencies (spelling errors, grammatically incorrect sentences et c) or errors in this exercise, please open a New Issue with the title "Task x Error: summary of error here". Found bugs will be rewarded by mentions in the acknowledgment section.

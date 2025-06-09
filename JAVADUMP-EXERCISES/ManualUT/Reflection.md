-----Reflection Questions-----
1. What did you learn from writing and running your own tests?
   I learned how to create manual unit tests that check whether the method selectDrink returns the expected output for different inputs. 
Writing tests helped me catch logic errors, especially with case sensitivity, and it showed the importance of checking both valid ("happy path") and invalid ("edge case") inputs.

2. How did debugging with print statements help you understand the code flow?
   The System.out.println statements allowed me to trace how the input string was processed inside the method. 
By printing:

the received input,

the lowercased version,

and the final result,

I was able to see exactly how the method responded step-by-step, which made it easier to understand what was going wrong when the tests failed (like with "WATER").

3. Why is it important to test both expected and unexpected inputs?
   Testing both ensures the program behaves correctly under all conditions. 
Expected inputs confirm normal functionality, while unexpected inputs help ensure the program doesn’t crash or return incorrect results. 
This kind of testing helps build robust and user-friendly applications.

4. How does using a loop for input validation improve the user experience?
The loop prevents the program from exiting on invalid input and gives users as many tries as needed to provide valid input. 
This makes the program more interactive and forgiving, improving usability without requiring the user to restart the program on every mistake.
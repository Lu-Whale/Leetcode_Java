# Leetcode

- ✅ I made a java file name generator in the root directory which used to generate the java file name (Since I always copy the problem name from Leetcode and used it as a file name, but it contains space or illegal characters) Feel free to use it :)


- Leetcode75
- Top Interview 150


# Note:

## Dynamic Programing (DP):

### When solving Dynamic Programming (DP) problems, it is usually necessary to follow a series of steps. The following is the general logic for solving DP problems:

1. Define the Problem: First, clearly define the problem, including what the input and output of the problem are and how to measure the optimization goal of the problem. This step typically involves breaking down the original problem into **smaller subproblems** to make it manageable.
2. Find Optimal Substructure: Determine if the problem exhibits the property of optimal substructure, where the optimal solution of the problem can be constructed from **the optimal solutions of its subproblems**. This is a key feature of DP problems.
3. Recursively Define States: Once the problem is divided into subproblems, define the state(s) for each subproblem. A state is a description of the subproblem's information and is typically represented by one or more variables that uniquely identify the subproblem.
4. Build the **State Transition Equation**: The state transition equation describes the relationship between subproblems, indicating how to transition from one subproblem's solution to the next. This is the core part of DP problems.
5. **Initialize Boundary Conditions:** In DP problems, it is often necessary to initialize one or more initial states with boundary conditions. These boundary conditions represent the base cases of the problem and are usually the solutions to the simplest subproblems.
6. Compute Bottom-Up or Apply Memoization: There are two common methods to solve DP problems. One approach is bottom-up, starting from the smallest subproblems and gradually computing solutions for larger subproblems until the solution for the original problem is obtained. Another approach is memoization, which involves using recursion to solve the problem but storing the solutions for each subproblem in a data structure to avoid redundant calculations.
7. Return the Final Solution: Once the solution to the original problem is computed, return it as the answer to the problem.

### Tips:
- Add extra spaces for dp array to handle edge cases without additional check.
  - int[ ] dp = new int[n + 2];
- Transtion Equation could be more than one, depending on different situation need to be considered.
  - Refer to 1143, there are two parts to the transition equation, depending on whether the current characters being considered are the same or not.

## Binary Search

### Handling boundary conditions properly in binary search is crucial to avoid infinite loops or missing the target element. Here are some key points to consider:

1. Loop Condition:
   - Binary search is typically performed within a while (left <= right) loop. Using < instead of <= can cause a failure to find edge elements.
   - At the end of the search, left will be greater than right, which indicates that the search space is empty.
2. Midpoint Calculation:
   - Correctly calculating the midpoint can prevent integer overflow, such as int mid = left + (right - left) / 2;.
3. Narrowing Down the Search Space:
   - When the target is less than the value at mid, i.e., target < array[mid], adjust the right boundary to mid - 1.
   - When the target is greater than the value at mid, i.e., target > array[mid], adjust the left boundary to mid + 1.
   - If you're dealing with a standard binary search problem to find an exact value, when target == array[mid], you can return mid or proceed as necessary.
4. Return Condition:
   - If the target value is found in the array, return its index.
   - If the loop ends (i.e., left > right), it indicates that the target value is not in the array, and depending on the function's expectation, you can return a special value, such as -1 or null.
5. Handling Special Cases:
   - Special cases when the array is empty or has only one element.
   - Handling when the target value is less than all elements in the array or greater than all of them.
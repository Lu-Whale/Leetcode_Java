# Leetcode

- Record Leetcode Practice from Oct 21, 2023, previous practices are not include in this repo.

- Leetcode75 


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
    -  int[ ] dp = new int[n + 2]; )


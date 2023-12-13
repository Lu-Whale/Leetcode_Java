## Lucas's Leetcode Practice record 😊

- ✅ I made a java file name generator in the root directory which used to generate the java file name (Since I always copy the problem name from Leetcode and used it as a file name, but it contains space or illegal characters) Feel free to use it :)


- Leetcode75
- Top Interview 150
- Problem List


# Note:

## Dynamic Programing (DP):

#### When solving Dynamic Programming (DP) problems, it is usually necessary to follow a series of steps. The following is the general logic for solving DP problems:

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
### Example Problem
  - [300. Longest Increasing Subsequence](LeetCode75/DP_1D/_300_LongestIncreasingSubsequence.java)

## Binary Search

#### Handling boundary conditions properly in binary search is crucial to avoid infinite loops or missing the target element. Here are some key points to consider:

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

## Priority Queue

#### An unbounded priority queue based on a priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used. A priority queue does not permit null elements. A priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in ClassCastException).

1. `PriorityQueue()`
   - Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
2. `PriorityQueue(Comparator<? super E> comparator)`
   - Creates a PriorityQueue with the default initial capacity and whose elements are ordered according to the specified comparator.
3. `PriorityQueue(int initialCapacity, Comparator<? super E> comparator)`
   - Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.

Example of how to use lambda expressions to define ascending (min-heap) and descending (max-heap) order for a PriorityQueue:

- #### Ascending Order (Min-Heap):
   `PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);`
- #### Descending Order (Max-Heap):
   `PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);`

### Comparator

In Java, the return value of the compare method in a Comparator defines the ordering relationship between two objects. The signature of the compare method is as follows:

`int compare(T o1, T o2);`

Here, o1 and o2 are the objects to be compared, and T is the type of the objects. The method returns an integer that has three possible outcomes:

1. Negative Number: If the return value is negative, it indicates that the first argument o1 is "less than" the second argument o2. In sorting structures, o1 should appear before o2.
2. Zero: If the return value is zero, it indicates that the two arguments are considered equal. In most sorting structures, this means their order is not significant, and they can be interchanged without affecting the sort order.
3. Positive Number: If the return value is positive, it indicates that the first argument o1 is "greater than" the second argument o2. In sorting structures, o1 should appear after o2.

When you use a Comparator in sorting structures like PriorityQueue or Collections.sort(), the internal sorting algorithms of these structures use the compare method to determine the order of elements. For example:
```
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
   @Override
   public int compare(Integer a, Integer b) {
      return a - b; // Negative if a < b, zero if a == b, positive if a > b
   }
});
```
In this example, we create a PriorityQueue where the elements are Integers. We provide a Comparator that defines the ordering between integers by simply subtracting a from b. This Comparator will cause the queue to sort the integers in ascending order (the smallest element has the highest priority).

In Java 8 and above, Comparator creation is often done using lambda expressions or method references for more concise code:

```
// Using a lambda expression to define a Comparator
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
```
Or if you are sorting based on an attribute of an object, you can use the Comparator.comparing method:
```
// Assuming the Person class has a method getAge
PriorityQueue<Person> personPriorityQueue = new PriorityQueue<>(Comparator.comparing(Person::getAge));
```
Here, the PriorityQueue will sort Person objects based on their age. A Person with a lower age returned by the getAge method will be considered to have a higher priority in the queue.

## Merge sort
#### Merge sort is a divide-and-conquer algorithm, Here's a simple explanation of how it works:

1. Divide: The array is divided into two halves (subarrays).
2. Conquer: Each half is sorted recursively using merge sort, breaking down the subarrays until they are small enough to be considered sorted (arrays of one element are always sorted).
3. Combine: The sorted subarrays are merged together to form a single, sorted array.

### Example Problem
[148. Sort List](Problem_List/_148_Sort_List.java) 

## Deep First Search

#### Follow these steps to develop when try to solve depth-first search (DFS) algorithm problems:

1. Understand the Problem: First, fully understand the requirements and objectives of the problem. This might involve traversing a graph, finding paths, solving puzzles, etc.
2. Decide on Graph Representation: Based on the needs of the problem, decide how to represent the graph. This could be an adjacency matrix, adjacency list, or other forms.
3. Design the DFS Recursive Function: Write a recursive function to perform DFS. Common elements to consider include:
   - Visited Marking: To mark nodes that have been visited to prevent revisiting.
   - Path Recording: If needed, record the path from the starting point to the current node.
   - Termination Condition: Decide when to stop the recursion.
4. Handle Special Cases: Consider and handle special cases in the graph, such as cycles, disconnected components, or other specific requirements.
5. Recursive Traversal: Start the DFS from one or multiple starting points and recursively traverse the graph.
6. Collect and Return Results: If the problem requires returning specific results, ensure these are correctly collected during the recursion.
7. Optimization and Debugging:
   - Check for any possible optimizations, such as pruning conditions, to reduce unnecessary recursive calls.
   - Debug the code to ensure it handles various test cases correctly.
8. Code Review and Refactoring: Finally, review the code to ensure clarity and efficiency. If necessary, refactor to improve the readability and performance of the code.

### Tips:

1. When using a variable to track a global maximum or minimum in a recursive function, there are typically two approaches:
   - Global Variable: Define a class-level variable (like maxLen). This variable remains constant throughout all recursive calls and can be updated and accessed accordingly.
   - Function Parameter: By passing the current maximum as a parameter to the recursive function and then returning the updated maximum. 

### Example Problem
[1372. Longest ZigZag Path in a Binary Tree](LeetCode75/Binary_Tree_DFS/_1372_Longest_ZigZag_Path_in_a_Binary_Tree.java)

## Backtracking

#### Backtracking used for finding solutions to problems incrementally, one step at a time, and removing those solutions that fail to satisfy the constraints of the problem at any point of time.
How backtracking works:
1. Choose: 
   - Start by choosing an option at a decision point.
2. Constraint Check: 
   - After making a choice, check if the current partial solution satisfies the problem's constraints. If it violates any constraint, discard this partial solution and backtrack (i.e., return to the previous step).
3. Goal Check: 
   - Check if the current solution satisfies the goal of the problem. If it does, return this solution.
4. Recursion: 
   - If the current partial solution neither violates the constraints nor satisfies the goal, recursively apply these steps to extend the solution further.
5. Backtrack: 
   - If none of the options work out, backtrack to the previous decision point and try a different path.

### Example Problem
[17. Letter Combinations of a Phone Number](LeetCode75/Backtracking/_17_Letter_Combinations_of_a_Phone_Number.java)

## Prefix sum with Hashmap
1. We know the sum of subarray at interval(i,j) can be got by sum[j] - sum[i] = SumOfSubArray
2. Then we just need to use hashmap to store how many sum[i] satisfied this equation when iterate to j
3. Note that be careful the edge case where sum[j] should include the element j and sum[i] should exclude the element i when calculate the exact interval from i to j, but sometimes it can be simplified since it same as sum[j] - sum[i-1]

### Example Problem
[930. Binary Subarrays With Sum](Problem_List/_930_Binary_Subarrays_With_Sum.java)
[560. Subarray Sum Equals K](Problem_List/_560_Subarray_Sum_Equals_K.java)
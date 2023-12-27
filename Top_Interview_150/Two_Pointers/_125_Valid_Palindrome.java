package Top_Interview_150.Two_Pointers;

public class _125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int leftPointer = 0;
        int rightPointer = n - 1;

        while (leftPointer < rightPointer) {
            char left = s.charAt(leftPointer);
            char right = s.charAt(rightPointer);

            if(!Character.isAlphabetic(left) && !Character.isDigit(left)) {
                leftPointer++;
                continue;
            }
            if(!Character.isAlphabetic(right) && !Character.isDigit(right)) {
                rightPointer--;
                continue;
            }

            if( Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}

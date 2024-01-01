package Top_Interview_150.Binary_Search;

public class _74_Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if(matrix[mid][0] <= target) {
                left = mid;
            }else {
                right = mid -1;
            }
        }

        int row = right;

        if(matrix[row][0] == target) {
            return true;
        }
        if(matrix[row][0] > target) {
            return false;
        }
        left = 0;
        right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if(matrix[row][mid] <= target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }

        int colum = right;

        return matrix[row][colum] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(matrix, 11));

    }
}

package Algorithms;

import java.util.Arrays;
import java.util.Random;

class QuickSort {
    /* 该方法接受一个数组以及数组的起始和结束索引作为参数，对指定范围的数组进行排序 */
    void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 主方法来测试排序算法
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}


class RandomizedQuickSort {

    void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = randomizedPartition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    // 随机化分区函数
    private int randomizedPartition(int[] arr, int begin, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - begin + 1) + begin;
        int swapTemp = arr[pivotIndex];
        arr[pivotIndex] = arr[end];
        arr[end] = swapTemp;

        return partition(arr, begin, end);
    }

    // 主方法来测试排序算法
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        RandomizedQuickSort ob = new RandomizedQuickSort();
        ob.quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}


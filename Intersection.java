import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two integer arrays nums1 and nums2, return an array of their
intersection
. Each element in the result must be unique and you may return the result in any order.
 */

public class Intersection {
  /**
   * help function to determine if the arrays contain the element binary search tree increase the
   * time efficiency
   *
   * @param arr sorted array to identify if another array contains the same element
   * @param key number that is in common
   * @return true only if it finds the same element, false otherwise
   */
  private static boolean binarySearch(int[] arr, int key) {
    int head = 0;
    int end = arr.length - 1;
    // binary search algorithm
    while (head <= end) {
      int mid = (head + end) / 2;
      if (arr[mid] == key) {
        return true;
      } else if (arr[mid] < key) {
        head = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }

  /**
   * Function that detect if two arrays contain the same element and return it
   *
   * @param arr1 unsorted array
   * @param arr2 sorted array use to detect if arr1 contains the same element
   * @return a sorted array that contains the same element
   */
  public static int[] intersection(int[] arr1, int[] arr2) {
    // use array helper function to sort arr2
    Arrays.sort(arr2);

    // create a new arraylist to keep the same element
    List<Integer> list = new ArrayList<>();

    // find the same element
    for (int num : arr1) {
      if (binarySearch(arr2, num)) {
        // Confirm if there is no duplicate element
        if (!list.contains(num)) {
          list.add(num);
        }
      }
    }

    // create a new array to convert arraylist and keep the elements
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    // return the array that keep the same elements
    return result;
  }

  /**
   * main function to run test cases
   */
  public static void main(String[] args) {
    int[] arr1 = new int[] {2, 3, 99, 8, 7, 5};
    int[] arr2 = new int[] {2, 4, 9, 9, 8, 1, 0};
    int[] result = intersection(arr1, arr2);
    System.out.println(Arrays.toString(result));
  }

}

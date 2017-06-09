import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Zejian Zhong (zzz0065@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2017-05-28
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int min = a[0];
      for (int i = 1; i < a.length; i++) {
         if (a[i] < min) {
            min = a[i];
         }
      }
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int max = a[0];
      for (int i = 1; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i];
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int isDistinct = 1;
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < i; j++) {
            if (a[i] != a[j]) {
               isDistinct++;
            }
         }
      }
      if (k > isDistinct) {
         throw new IllegalArgumentException();
      }
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      int kmin = 0;
      if (b.length < 2) {
         kmin = b[k - 1];
      }
      else {
         int j = 0;
         int i = 1;
         while (i < b.length) {
            if (b[i] == b[j]) {
               i++;
            }
            else {
               j++;
               b[j] = b[i];
               i++;
            }
         }
         int[] c = Arrays.copyOf(b, j + 1);
         kmin = c[k - 1];
      }
      return kmin;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int isDistinct = 1;
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < i; j++) {
            if (a[i] != a[j]) {
               isDistinct++;
            }
         }
      }
      if (k > isDistinct) {
         throw new IllegalArgumentException();
      }
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      for (int i = 0; i < b.length / 2; i++) {
         int temp = b[i];
         b[i] = b[b.length - 1 - i];
         b[b.length - 1 - i] = temp;
      }
      int kmax = 0;
      if (b.length < 2) {
         kmax = b[k - 1];
      }
      else {
         int j = 0;
         int i = 1;
         while (i < b.length) {
            if (b[i] == b[j]) {
               i++;
            }
            else {
               j++;
               b[j] = b[i];
               i++;
            }
         }
         int[] c = Arrays.copyOf(b, j + 1);
         kmax = c[k - 1];
      }
      return kmax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int num = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            num++;
         }
      }
      int[] b = new int[num];
      int c = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            b[c] = a[i];
            c++;
         }
      }
      return b;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int num = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= key) {
            num++;
         }
      }
      if (num > 0) {
         int[] b = new int[num];
         int c = 0;
         for (int i = 0; i < a.length; i++) {
            if (a[i] >= key) {
               b[c] = a[i];
               c++;
            }
         }
         int min = b[0];
         for (int d = 1; d < b.length; d++) {
            if (b[d] < min) {
               min = b[d];
            }
         }
         return min;
      }
      else {
         throw new IllegalArgumentException();
      }
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int num = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= key) {
            num++;
         }
      }
      if (num > 0) {
         int[] b = new int[num];
         int c = 0;
         for (int i = 0; i < a.length; i++) {
            if (a[i] <= key) {
               b[c] = a[i];
               c++;
            }
         }
         int max = b[0];
         for (int d = 1; d < b.length; d++) {
            if (b[d] > max) {
               max = b[d];
            }
         }
         return max;
      }
      else {
         throw new IllegalArgumentException();
      }
   }

}

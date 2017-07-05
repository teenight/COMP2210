import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
/**
 * SortingLabClient.java
 *
 * Provides a simple example client of SortingLab.java.
 *
 * NOTE: The generic type of SortingLab must be bound
 *       to a Comparable type. The sorting methods in
 *       SortingLab use the natural ordering of the
 *       elements in the parameter array.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2017-06-21
 *
 */
public final class SortingLabClient {

   /** Drives execution. */
   public static void main(String[] args) {

      // instantiate the SortingLab class
      // using your Banner ID number as the key value
      int key = 903907977;
      SortingLab<String> sls = new SortingLab<String>(key);

      // run each sort a few times before trying to
      // collect timing data
      //String[] as = {"D", "B", "A", "C", "E"};
      //for (int i = 0; i < 10; i++) {
         //sls.sort1(as);
         //sls.sort2(as);
         //sls.sort3(as);
         //sls.sort4(as);
         //sls.sort5(as);
      //}

      // generate timing data for one sort method using
      // the "doubling strategy" from lecture and lab
      SortingLab<Integer> sli = new SortingLab<Integer>(key);
      int M = 800000; // max capacity for array
      int N = 2000;   // initial size of array
      double start;
      double elapsedTime;
      for (; N < M; N *= 2) {
         Integer[] ai = getIntegerArrayO(N, Integer.MAX_VALUE);
         start = System.nanoTime();
         sli.sort2(ai);
         elapsedTime = (System.nanoTime() - start) / 1000000000d;
         System.out.print(N + "\t");
         System.out.printf("%4.3f\n", elapsedTime);
      }
      
      SortingLab<Test> t = new SortingLab<Test>(key);
      Test[] stable = {new Test(4, 1), new Test(2, 2), new Test(1, 3), new Test(4, 4), 
                       new Test(2, 5), new Test(1, 6), new Test(4, 7)};
      t.sort5(stable);
   }
   
   /** return an array of random integer values. */
   private static Integer[] getIntegerArray(int N, int max) {
      Integer[] a = new Integer[N];
      java.util.Random rng = new java.util.Random();
      for (int i = 0; i < N; i++) {
         a[i] = rng.nextInt(max);
      }
      return a;
   }
   
   /** return an ordered array of random integer values. */
   private static Integer[] getIntegerArrayO(int N, int max) {
      Integer[] a = new Integer[N];
      java.util.Random rng = new java.util.Random();
      for (int i = 0; i < N; i++) {
         a[i] = rng.nextInt(max);
      }
      Arrays.sort(a);
      return a;
   }
   
   /** return a reversed array of random integer values. */
   private static Integer[] getIntegerArrayR(int N, int max) {
      Integer[] a = new Integer[N];
      java.util.Random rng = new java.util.Random();
      for (int i = 0; i < N; i++) {
         a[i] = rng.nextInt(max);
      }
      Arrays.sort(a);
      Integer[] b = new Integer[N];
      for (int i = 0; i < N; i++) {
         b[i] = a[N - i - 1];
      }
      return b;
   }
   
   /*class Test implements Comparable<Test> {
      private int val1;
      private int val2;
      
      public Test(int a, int b)
      {
         val1 = a;
         val2 = b;
      }
      
      
      public int compareTo(Test that)
      {
         if (this.val1 < that.val1)
         {
            return -1;
         }
         else if (this.val1 > that.val1)
         {
            return 1;
         }
         else 
            return 0;
      }
   }*/
}

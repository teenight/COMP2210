class Test implements Comparable<Test> {
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
}

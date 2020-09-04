public class CodingBatArray3 {
    public boolean canBalance(int[] nums) {
        int sum1=0;
        for (int i =0;i<nums.length;i++)
        {
          sum1+=nums[i];
          int sum2=0;
          for(int j =nums.length-1;j>i;j--)
          {
            sum2+=nums[j];
          }
          
          if(sum1==sum2)
          {
            return true;
          }
          
        }
        return false;
    }

    public int maxMirror(int[] nums) {
        int count= 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
          count=0;
          for (int j = nums.length-1; i + count < nums.length && j > -1; j--){
            if(nums[i+count] == nums[j]){
              count++;
            }
            else{
              if (count > 0){
                max = Math.max(count,max);
                count = 0;
              }
            }
          }
          max = Math.max(count,max);
        }
        return max;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int len = 0;
        for (int i=0;i<inner.length;i++)
        {
          for(int j =0;j<outer.length&&len<inner.length;j++)
          {
            if(inner[i]==outer[j])
            {
              len++;
              break;
            }
          }
          
        }
        if(len==inner.length)
        {
          return true;
        }
        return false;
    }
  
    public int[] seriesUp(int n) {
      int[] array= new int[(n*(n+1)/2)];
      int x=0;
      for(int i=1;i<=n;i++)
      {
        
        for(int j=1;j<=i;j++)
        {
          array[x++]= j;
          
        }
      }
      return array;
    }

    public int[] squareUp(int n) {
      int[] result = new int[n * n];
      int pass = 1, index = 0;
      if(n == 0) { return result; }
      for(int i = n-1; i < result.length; i+=n) {
         index = i;
         for(int k = 1; k <= pass; k++) {
           result[index] = k;
           index--;
         }
         pass++;
      }
      return result;
    }


      
      
}
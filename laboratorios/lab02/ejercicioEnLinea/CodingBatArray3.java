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


      
      
}
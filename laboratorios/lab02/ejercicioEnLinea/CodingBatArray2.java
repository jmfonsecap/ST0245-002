public class CodingBatArray2{

    public boolean only14(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
          if(nums[i]!=1&&nums[i]!=4)
          {
            return false;
          }
        }
        return true;
    }

    public boolean has22(int[] nums) {
  
        for(int i = 0;i<nums.length-1;i++)
        {
          if(nums[i]==2&&nums[i+1]==2)
          {
            return true;
          }
        }
        return false;
    }

    public int[] evenOdd(int[] nums) {
        int[] nums2 = new int[nums.length];
        int j=0;
        int k=0;
          for(int i=0;i<nums.length;i++)
          {
            if (nums[i]%2!=0)
            {
              nums2[(nums.length-1)-k]= nums[i];
              k++;
            }
            else
            {
              nums2[j]=nums[i];
              j++;
            }
          }
        return nums2;
    }

    public int[] zeroMax(int[] nums) {
        for(int i =0;i<nums.length;i++)
        {
          if(nums[i]==0)
          {
            int max=0;
            for(int j= i+1;j<nums.length;j++)
            {
              if(max<nums[j]&&nums[j]%2!=0)
              {
                max= nums[j];
              }
            }
            nums[i]=max;
          }
        }
        return nums;
    }
    public int sum67(int[] nums) {
        int sum=0;
        int annul7=0;
        for (int i =0 ; i <nums.length;i++)
        {
          if(nums[i] == 6)
          {
            for( int j = i; nums[j] != 7;j++)
            {
              nums[j] = 0;
              annul7 = j;
            }
            nums[annul7+1] =0;
          }
          else
            sum += nums[i];
        }
        return sum;
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
      
      
      
    
      
      
}
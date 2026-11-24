class Solution {
    public int cntsplit(int[] nums,int mid){
        int cnt = 0;
        int nos = 1;
        for(int n : nums){
            if(cnt + n <= mid){
              cnt += n;

            }
            else{
                cnt = n;
                nos++;
            }

        }
        return nos;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int n : nums){
            low = Math.max(low,n);
            high += n;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(cntsplit(nums,mid) <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
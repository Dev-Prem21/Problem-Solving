class Solution {
    public int numOfSubarrays(int[] arr) {
        long MOD =1_000_000_007L;
        int n = arr.length;
        long odd = 0;
        long even = 1;
        long count = 0;
        long pref = 0;
        for(int i=0;i<n;i++){
            pref+=arr[i];
            if(pref%2==0){
                count=(count+odd)%MOD;
                even++;
            }
            if(pref%2==1){
                count=(count+even)%MOD;
                odd++;
            }
        }
        return (int)count;
    }
}
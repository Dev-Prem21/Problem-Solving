class Solution {
    int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((a / gcd(a, b)) * b);
    }
    public int maxLength(int[] nums) {
        int maxi = 1;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int g = nums[i];
            int l = nums[i];
            int prod =nums[i];
            for(int j=i+1;j<n;j++){
                g = gcd(g,nums[j]);
                l = lcm(l,nums[j]);
                prod*=nums[j];
                if(prod==g*l){
                    maxi= Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }
}
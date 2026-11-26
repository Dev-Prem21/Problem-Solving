class Solution {
    public boolean canAliceWin(int n) {
        int x = n;
        for(int i=10;i>0;i--){
            if(i%2==0 && i>x){
                return false;
            }
            if(i%2==1 && i>x){
                return true;
            }
            x-=i;
        }
        return true;
    }
}
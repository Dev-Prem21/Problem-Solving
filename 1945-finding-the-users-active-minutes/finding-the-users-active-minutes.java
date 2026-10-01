class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int n = logs.length;
        int[] ans = new int[k];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] x : logs){
            map.putIfAbsent(x[0],new HashSet<>());
        }
        for(int i=0;i<n;i++){
            map.get(logs[i][0]).add(logs[i][1]);
        }
        for(Map.Entry<Integer,Set<Integer>> entry : map.entrySet()){
            int x = entry.getValue().size();
            ans[x-1]++;
        }
        return ans;
    }
}
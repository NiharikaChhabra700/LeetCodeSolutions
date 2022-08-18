class Solution {
    public int numWays(String[] words, String t) {
        int M = (int)1e9+7, n = words[0].length();
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; i++){
            for (String s : words){
                cnt[i][s.charAt(i)-'a']++;
            }
        }
        long[] dp = new long[n];
        for (int i = 0; i < n; i++){ // base case.
            dp[i]=cnt[i][t.charAt(0)-'a'];
        }
        for (int i = 1; i < t.length(); i++){
            long pre = 0; // prefix sum
            for (int j = 0; j<n; ++j){
                long tmp = dp[j];
                dp[j]=cnt[j][t.charAt(i)-'a']*pre;
                pre+=tmp;
                pre%=M;
            }
        }
        return (int)(Arrays.stream(dp).sum()%M);
    }
}
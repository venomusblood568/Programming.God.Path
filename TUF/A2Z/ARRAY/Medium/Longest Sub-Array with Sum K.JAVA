class Solution{
    public static int lenOfLongSubarr(int a[], int N, int K) {
        int len = 0;
        for(int  i = 0; i < N; i++){
            long sum = 0;
            for(int j = i; j < N; j++){
                sum += a[j];

                if(sum == K){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;

    }
}
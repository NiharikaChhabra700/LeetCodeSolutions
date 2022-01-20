class Solution {
    public double largestTriangleArea(int[][] points) {
        double max=0;
        int n=points.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    double area=calc(points[i],points[j],points[k]);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
    public double calc(int[]a,int[]b,int[]c){
        double t=(a[0]*(b[1]-c[1])-b[0]*(a[1]-c[1])+c[0]*(a[1]-b[1]))/2.0;
        return t > 0 ? t : -t;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        
        int lo=0;
        int hi=n-1;
        int mid=0;
        
        while(lo<=hi)
        {
            mid=(lo+hi)/2;
            
            if(arr[mid]==x)
            {
                break;
            }
            else if(arr[mid]<x)
            {
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        
        int l=Math.max(0,mid-1);
        int r=l+1;
        
        while(l>=0 && r<n && k>0)
        {
            if(Math.abs(arr[l]-x) <= Math.abs(arr[r]-x))
            {
                list.add(arr[l]);
                l--;
                k--;
            }
            else
            {
                list.add(arr[r]);
                r++;
                k--;
            }
        }
        
        while(k>0 && l>=0)
        {
            list.add(arr[l]);
                l--;
                k--;
            
        }
        
        while(k>0 && r<n)
        {
            list.add(arr[r]);
                r++;
                k--;
            
        }
        Collections.sort(list);
        return list;
        
        
    }
}
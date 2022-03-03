// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static class Marks implements Comparable<Marks> {
        int phy;
        int chem;
        int maths;
        
        Marks(){
            
        }
        
        Marks(int phy,int chem,int maths)
        {
            this.phy=phy;
            this.chem=chem;
            this.maths=maths;
        }
        
        public int compareTo(Marks o)
        {
            if(this.phy != o.phy)
            {
                return this.phy-o.phy;
            }
            else if(this.chem !=o.chem)
            {
                return o.chem-this.chem;
            }
            else
            {
                return this.maths-o.maths;
            }
        }
        
        
    }
    public void customSort (int phy[], int chem[], int maths[], int N)
    {
        int n=phy.length;
        Marks[] arr=new Marks[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=new Marks(phy[i],chem[i],maths[i]);
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++)
        {
            phy[i]=arr[i].phy;
            chem[i]=arr[i].chem;
            maths[i]=arr[i].maths;
        }
    }
}

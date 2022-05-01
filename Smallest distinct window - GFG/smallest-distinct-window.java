// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        
        int[] freq=new int[128];
        int count=0;
        
        for(int i=0;i<s.length();i++)
        {
            if(freq[s.charAt(i)]==0)
            {
                freq[s.charAt(i)]++;
                count++;
            }
        }
        
        
        int ei=0,si=0,len=(int)1e9;
        
        while(ei<s.length())
        {
            if(freq[s.charAt(ei++)]-- >0)
            {
                count--;
            }
            
            while(count==0)
            {
                len=Math.min(len,ei-si);
                
                if(freq[s.charAt(si++)]++ == 0)
                {
                    count++;
                }
            }
        }
        
        return len;
    }
}
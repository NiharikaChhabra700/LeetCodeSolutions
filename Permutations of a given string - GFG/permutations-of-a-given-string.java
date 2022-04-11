// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    
    
    public String swap(String S,int i ,int j)
    {
        StringBuilder sb=new StringBuilder(S);
        sb.setCharAt(i,S.charAt(j));
        sb.setCharAt(j,S.charAt(i));
        return sb.toString();
    }
    
    public void permute(String S,int l, int r,List<String> ans)
    {
        if(l>=r)
        {
            ans.add(S);
            return;
        }
        
        
        for(int i=l;i<=r;i++)
        {
            S=swap(S,l,i);
            permute(S,l+1,r,ans);
            S=swap(S,l,i);
        }
    }
    
    
    
    
    public List<String> find_permutation(String S) {
        
        List<String> ans=new ArrayList<>();
        permute(S,0,S.length()-1,ans);
        Collections.sort(ans);
        return ans;
        
        
    }
}
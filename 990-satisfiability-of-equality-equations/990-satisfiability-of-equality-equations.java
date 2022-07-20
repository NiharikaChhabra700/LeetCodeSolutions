class Solution {
    int[] par;
    
    public int findPar(int u)
    {
        if(par[u] == u)
        {
            return u;
        }
        else
        {
            return par[u] = findPar(par[u]);
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        
        par = new int[26];
        
        for(int i=0; i < 26 ; i++)
        {
            par[i] = i;
        }
        
        for(int i=0; i<equations.length; i++)
        {
            String s = equations[i];
            
            if(s.charAt(1) == '=')
            {
                int p1 = findPar(s.charAt(0) - 'a');
                int p2 = findPar(s.charAt(3) - 'a');
                
                if(p1!=p2)
                {
                    par[p1] = p2;
                }
            }
           
        }
        
        for(int i=0; i<equations.length; i++)
        {
            String s = equations[i];
            
            if(s.charAt(1) == '!')
            {
                int p1 = findPar(s.charAt(0) - 'a');
                int p2 = findPar(s.charAt(3) - 'a');
                
                if(p1 == p2)
                {
                    return false;
                }
            }
           
        }
        
        return true;
        
        
    }
}
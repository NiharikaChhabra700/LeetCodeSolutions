class Solution {
    
    
    public void backtracking(List<String> list,int open,int closed,StringBuilder str,int n)
    {
        if(closed>open)
        {
            return;
        }
        
        if(closed==open && str.length()==2*n)
        {
            list.add(str.toString());
            return;
        }
        
        if(open<n)
        {
            str.append("(");
            backtracking(list,open+1,closed,str,n);
            str.deleteCharAt(str.length()-1);
        }
        
        if(closed<open)
        {
            str.append(")");
            backtracking(list,open,closed+1,str,n);
            str.deleteCharAt(str.length()-1);
            
        }
    }
    
    
    
    
    public List<String> generateParenthesis(int n) {
        
        List<String> list=new ArrayList<>();
        
        backtracking(list,0,0,new StringBuilder(),n);
        
        return list;
        
    }
}
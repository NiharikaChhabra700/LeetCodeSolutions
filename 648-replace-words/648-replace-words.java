import java.util.StringTokenizer;
class Solution {

        public class Node
        {
            
        Node[] childs;
        String str;
        
        Node()
          {
            childs=new Node[26];
          }
        }
        
        public void insert(String word,Node root)
        {
            
            Node curr=root;
            for(int i=0;i<word.length();i++)
            {
                char ch=word.charAt(i);
                if(curr.childs[ch-'a']==null)
                {
                    curr.childs[ch-'a']=new Node();
                }
                
                curr=curr.childs[word.charAt(i)-'a'];
                
                
            }
            
            curr.str=word;
        }
        
        public String findPrefix(String word,Node root)
        {
            Node curr=root;
            StringBuilder ans=new StringBuilder();
            
            for(int i=0;i<word.length();i++)
            {
                char ch=word.charAt(i);
                if(curr.childs[ch-'a']==null)
                {
                    return null;                    
                }
                
                curr=curr.childs[ch-'a'];
                if(curr.str!=null)
                {
                    return curr.str;
                }
                    
            }
            
            return null;
        }
    
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Node root=new Node();
        
        for(String str:dictionary)
        {
            insert(str,root);
        }
        
        StringBuilder ans=new StringBuilder();
        StringTokenizer st=new StringTokenizer(sentence);
        
        while(st.hasMoreTokens()){
            String word=st.nextToken();
            
            String prefix=findPrefix(word,root);
            
            if(prefix==null)
            {
                ans.append(word);
            }
            else
            {
                ans.append(prefix);
            }
            ans.append(" ");
        }
        
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
        
        
        
        
        
    }
}
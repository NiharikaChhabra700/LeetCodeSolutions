class Solution {
    
    public void matchstring(LinkedList<String> que,String w,HashMap<String,Boolean> vmap)
    {
        
        for(int i=0;i<w.length();i++)
        {
            char[] word=w.toCharArray();
            
            for(int j=0;j<26;j++)
            {
                char ch=(char)('a'+j);
                word[i]=ch;
                String str=String.valueOf(word);
                
                if(vmap.containsKey(str) && vmap.get(str)==false )
                {
                    que.addLast(str);
                    vmap.put(str,true);
                }
            }
        }
    }
    
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(wordList.contains(endWord)==false) return 0;
        
        HashMap<String,Boolean> vmap=new HashMap<>();
        
        for(int i=0;i<wordList.size();i++)
        {
            vmap.put(wordList.get(i),false);
        }
        
        LinkedList<String> que=new LinkedList<>();
        
        que.addLast(beginWord);
        vmap.put(beginWord,true);
        int length=1;
        
        while(que.size()!=0)
        {
            int size=que.size();
            while(size-->0)
            {
                String str=que.removeFirst();
                
                if(str.equals(endWord))
                {
                    return length;
                }
                
                matchstring(que,str,vmap);
            }
            
            length++;
        }
        
        return 0;
        
    }
}
class Solution {
    public int myAtoi(String str) {
        int i=0;
        while(i<str.length() && str.charAt(i)==' ')
        {
            i++;
        }
        if(i>=str.length())
        {
            return 0;
        }
        int sign=1;
        
        if(str.charAt(i)=='+' || str.charAt(i)=='-' )
        {
            sign=(str.charAt(i)=='+') ? 1: -1;
            i++;
        }
        if(i>=str.length())
        {
            return 0;
        }
        int num=0;
        for(;i<str.length() && (str.charAt(i)-'0' >=0 && str.charAt(i)-'0'<=9); i++)
        {
            if(num>Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && str.charAt(i)-            '0'>Integer.MAX_VALUE%10) )        
               {
                   return (sign==1) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
               num=num*10+str.charAt(i)-'0';
        }
               
               return num*sign;
        
    }
}
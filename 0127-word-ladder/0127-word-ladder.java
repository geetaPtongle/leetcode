class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
         Queue<Pair>q= new LinkedList<>();
 
         Pair p = new Pair( beginWord , 1);
 
         q.add( p );
 
         HashSet<String> mp = new HashSet<>( wordList );
 
         mp.remove( beginWord );
 
         while( q.size()>0 )
         {
             Pair pp = q.remove();
 
             String curr = pp.word;
             int step = pp.step;
 
             if( curr.equals(endWord)==true )
             {
                 return step;
             }
 
 
             for( int i=0 ; i< curr.length(); i++)
             {
                 char arr[] = curr.toCharArray();
 
                  for( char ch ='a'; ch<='z'; ch++)
                  {
                       arr[i]= ch;
 
                       String temp = new String( arr );
 
                       if( mp.contains( temp ) ==true)
                       {
                            Pair x = new Pair( temp , step+1);
                            q.add( x );
                            mp.remove( temp );
                       }
                  }
             }
 
         }
 
        return 0;
    }
}

class Pair
{
    String word;
    int step;
 
    Pair( String word, int step)
    {
        this.word = word;
        this.step= step;
    }
}
class Solution {
    public String makeLargestSpecial(String S) {
        Tree t = new Tree(S);
       // System.out.println("MADE");
        return t.gimme();
    }
    public static class Tree implements Comparable<Tree>
    {
        TreeSet<Tree> kids = new TreeSet<>();
//        String made="10";
        public Tree(String S)
        {
            //if(S.length()==2)
            //{
            //    return;
            //}
            int counter = 0;
            int startpos = 0;
            for(int i=0;i<S.length();i++)
            {
                if(S.charAt(i)=='1')
                {
                    counter++;
                }else
                {
                    counter--;
                }
                if(counter==0)
                {
                 //   System.out.println("kid of" +S.substring(startpos+1,i) );
                    if((startpos==0)&&(i==S.length()-1))
                    {
                     kids.add(new Tree(S.substring(startpos+1,i)))   ;
                    }else{
                    kids.add(new Tree(S.substring(startpos,i+1)));
                    }
                    startpos= i+1;
                }
            }
        }
        
        public String gimme()
        {
            //if (kids.isEmpty())
             //   return "";
            String allkids = "";
            for(Tree t : kids)
            {
                allkids+=t.gimme();
            }
                                   // System.out.println("gimme of" +"1"+allkids+"0"+" many "+kids.size() );
            if(kids.size()==1)
            return ("1"+allkids+"0");
            else
            return allkids;
        }
        public int compareTo(Tree o)
        {
            if(0!=-this.gimme().compareTo(o.gimme()))
                return -this.gimme().compareTo(o.gimme());
            else
                return this.toString().compareTo(o.toString());
        }
    }
}
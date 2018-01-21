class Solution {
    public String minWindow(String S, String T) {
        if(T.length()==0){
            return "";
        }
        TreeSet<Integer>[] indexes=new TreeSet[26];
        for(int i=0;i<26;i++){
            indexes[i]=new TreeSet<Integer>();
        }
        Set<Character> needed=new HashSet<Character>();
        for(int i=0;i<T.length();i++){
            needed.add(T.charAt(i));
        }
        for(int i=0;i<S.length();i++){
            if(needed.contains(S.charAt(i))){
                indexes[S.charAt(i)-'a'].add(i);
            }
        }
        String[] res={""};
        int[] minLen={Integer.MAX_VALUE};
        char ch=T.charAt(0);
        for(int start:indexes[ch-'a']){
            findMin(indexes,1,T,S,start,start,minLen,res);
        }
        return res[0];
    }
    public void findMin(TreeSet<Integer>[] indexes,int tIndex,String T,String S,int startIndex,int endIndex,int[] minLen,String[] res){
        if(minLen[0]==T.length()){
            return;
        }
        if(tIndex==T.length()){
            if(endIndex-startIndex+1<minLen[0]){
                res[0]=S.substring(startIndex,endIndex+1);
                minLen[0]=endIndex-startIndex+1;
            }
            return;
        }
        char ch=T.charAt(tIndex);
        Integer newEnd=indexes[ch-'a'].ceiling(endIndex+1);
        if(newEnd==null){
            return;
        }
        findMin(indexes,tIndex+1,T,S,startIndex,newEnd,minLen,res);
    }
}
public class Solution {
    public int countArrangement(int N) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=N;i++){set.add(i);}
        return search(set,1,N);
    }
    private int search(HashSet<Integer> set, int index, int N){
        if(index==N+1)return 1;
        int num=0;
         for(int i=1;i<=N;i++){
            if((index%i==0||i%index==0)&&set.contains(i)){
                set.remove(i);
                num+=search(set,index+1,N);
                set.add(i);
            }
         }
        return num;
    }
    
}
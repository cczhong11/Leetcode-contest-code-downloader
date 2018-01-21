class Solution {
    public String makeLargestSpecial(String S) {
        String[][] strs=new String[S.length()+1][S.length()];
        for(int i=0;i<S.length();i++){
            int count1=0;
            int count0=0;
            for(int j=i;j<S.length();j++){
                if(S.charAt(j)=='1'){
                    count1++;
                }
                else{
                    count0++;
                }
                if(count0==count1){
                    strs[j-i+1][i]=S.substring(i,j+1);
                }
                if(count0>count1){
                    break;
                }
            }
        }
        for(int len=4;len<=S.length();len=len+2){
            for(int start=0;start+len-1<S.length();start++){
                int end=start+len-1;
                String curr=strs[len][start];
                for(int mid=start+2;mid<=end-1;mid=mid+2){
                    if(strs[mid-start][start]!=null&&strs[len-mid+start][mid]!=null){
                        String temp1=strs[mid-start][start]+strs[len-mid+start][mid];
                        String temp2=strs[len-mid+start][mid]+strs[mid-start][start];
                        if(temp1.compareTo(curr)>0){
                            curr=temp1;
                        }
                        if(temp2.compareTo(curr)>0){
                            curr=temp2;
                        }
                    }
                }
                int tempIndex1=start;
                int tempIndex2=end;
                while(tempIndex1<tempIndex2&&S.charAt(tempIndex1)=='1'&&S.charAt(tempIndex2)=='0'){
                    if(strs[tempIndex2-tempIndex1-1][tempIndex1+1]==null){
                        break;
                    }
                    String temp=S.substring(start,tempIndex1+1)+strs[tempIndex2-tempIndex1-1][tempIndex1+1]+S.substring(tempIndex2,end+1);
                    if(temp.compareTo(curr)>0){
                        curr=temp;
                    }
                    tempIndex1++;
                    tempIndex2--;
                }
                strs[len][start]=curr;
            }
        }
        String res=strs[S.length()][0];
        if(res.equals(S)){
            return res;
        }
        return makeLargestSpecial(res);
    }
}
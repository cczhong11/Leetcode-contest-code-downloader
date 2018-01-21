public class Solution {
    public String solveEquation(String equation) {
        String[] s=equation.split("=");
        if(s.length<2||s[0].length()==0||s[1].length()==0){
            return "No solution";
        }
        int[] index1=findIndex(s[0]);
        int[] index2=findIndex(s[1]);
        if(index1[0]==index2[0]){
            if(index1[1]==index2[1]){
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x="+(index2[1]-index1[1])/(index1[0]-index2[0]);
    }
    public int[] findIndex(String s){
        if(s.charAt(0)!='+'&&s.charAt(0)!='-'){
            s="+"+s;
        }
        int index=1;
        int xCount=0;
        int numCount=0;
        int start=0;
        while(index<s.length()){
            while(index<s.length()&&s.charAt(index)!='x'&&s.charAt(index)!='+'&&s.charAt(index)!='-'){
                index++;
            }
            String temp=s.substring(start,index);
            if(temp.length()==1){
                temp=temp+"1";
            }
            int num=Integer.parseInt(temp);
            if(index<s.length()&&s.charAt(index)=='x'){
                index=index+2;
                start=index-1;
                xCount=xCount+num;
            }
            else{
                start=index;
                index++;
                numCount=numCount+num;
            }
        }
        return new int[]{xCount,numCount};
    }
}
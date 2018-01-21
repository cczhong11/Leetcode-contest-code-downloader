public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int[] result=new int[s.length()+1];
        int mod=(int)Math.pow(10,9)+7;
        result[0]=1;
        for(int i=1;i<=s.length();i++){
            char ch=s.charAt(i-1);
            if(ch=='0'){
                if(i-2>=0&&(s.charAt(i-2)=='1'||s.charAt(i-2)=='2')){
                    result[i]=result[i-2];
                }
                else if(i-2>=0&&s.charAt(i-2)=='*'){
                    result[i]=(result[i-2]+result[i-2])%mod;
                }
            }
            else if(ch=='*'){
                for(int k=1;k<=9;k++){
                    result[i]=(result[i]+result[i-1])%mod;
                }
                if(i-2>=0&&(s.charAt(i-2)=='1'||s.charAt(i-2)=='*')){
                    for(int j=1;j<=9;j++){
                        result[i]=(result[i]+result[i-2])%mod;
                    }
                }
                if(i-2>=0&&(s.charAt(i-2)=='2'||s.charAt(i-2)=='*')){
                    for(int j=1;j<=6;j++){
                        result[i]=(result[i]+result[i-2])%mod;
                    }
                }
            }
            else{
                result[i]=result[i-1];
                if(i-2>=0&&(s.charAt(i-2)=='1'||s.charAt(i-2)=='*')){
                    result[i]=(result[i]+result[i-2])%mod;
                }
                if(i-2>=0&&(s.charAt(i-2)=='2'||s.charAt(i-2)=='*')&&ch>='1'&&ch<='6'){
                    result[i]=(result[i]+result[i-2])%mod;
                }
            }
        }
        return result[s.length()];
    }
}
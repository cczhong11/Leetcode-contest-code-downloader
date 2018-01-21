class Solution {
    public List<String> removeComments(String[] source) {
        boolean inblock=false;
        List<String> res=new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<source.length;i++){
            String curr=source[i];
            for(int j=0;j<curr.length();j++){
                if(!inblock){
                    if(j+1<curr.length()&&curr.substring(j,j+2).equals("//")){
                        break;
                    }
                    else if(j+1<curr.length()&&curr.substring(j,j+2).equals("/*")){
                        inblock=true;
                        j++;
                    }
                    else{
                        sb.append(curr.charAt(j));
                    }
                }
                else{
                    if(j+1<curr.length()&&curr.substring(j,j+2).equals("*/")){
                        inblock=false;
                        j++;
                    }
                }
            }
            if(!inblock&&sb.length()>0){
                res.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        return res;
    }
}
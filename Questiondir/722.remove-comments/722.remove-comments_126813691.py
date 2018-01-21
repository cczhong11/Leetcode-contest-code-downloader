class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        source='\n'.join(source)
        isinblock=False
        hasline=False
        result=''
        i=0
        n=len(source)
        while i<len(source):
            # print [result]
            if source[i]=='/':
                if i!=n-1:
                    if source[i+1]=='/':
                        while i<n and source[i]!='\n':
                            i+=1
                        continue
                    if source[i+1]=='*':
                        i=i+2
                        while i<n-2 and source[i:i+2]!='*/':
                            i+=1
                        i+=2
                        continue
                    else:
                        result+=source[i]
                else:
                    result+=source[i]
            else:
                result+=source[i]
            i+=1
        return [i for i in result.split('\n') if i!='']
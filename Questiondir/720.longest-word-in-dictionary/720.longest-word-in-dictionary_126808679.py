class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        output=""
        have=set([])
        
        for w in words:
            have.add(w)
            
        for w in words:
            b=""
            can=True
            for c in w:
                b=b+c
                
                if not b in have:
                    can=False
                    break
            if can:
                if len(w)>len(output):
                    output=w
                elif len(w)==len(output) and w<output:
                    output=w
        return output
                
            
        
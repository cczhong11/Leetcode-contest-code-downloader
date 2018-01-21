class Solution:
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        
        mymap = {}
        for w in words:
            l = len(w)
            if not l in mymap:
                mymap[l] = set()
            mymap[l].add(w)
            
        i = 2
        while i in mymap:
            prev = mymap[i-1]
            #print(mymap[i])
            okw = {w for w in mymap[i] if w[:-1] in prev}
            mymap[i] = okw
            
            if not okw:
                break
            i += 1
            
        lastok = sorted(list(mymap[i-1]))
        return lastok[0]
        
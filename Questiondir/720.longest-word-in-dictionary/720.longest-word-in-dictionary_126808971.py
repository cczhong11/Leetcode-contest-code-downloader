class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        wordlength=[len(i) for i in words]
        wordmap={}
        for i in words:
        	wordmap[len(i)]=wordmap.get(len(i),[])+[i]
        lengthset=set(wordlength)
        if 1 not in lengthset:
        	return ""
        select=wordmap[1]
        for i in range(2,max(lengthset)+1):
        	newselect=[]
        	if i not in wordmap.keys():
        		return sorted(select)[0]
        	for j in wordmap[i]:
        		if any([j.find(i)==0 for i in select]):
        			newselect.append(j)
        	if newselect==[]:
        		return sorted(select)[0]
        	else:
        		select=newselect
        return sorted(select)[0]
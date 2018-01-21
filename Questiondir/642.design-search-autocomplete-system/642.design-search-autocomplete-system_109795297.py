from collections import defaultdict
class AutocompleteSystem(object):

    def __init__(self, sentences, times):
        """
        :type sentences: List[str]
        :type times: List[int]
        """
        self.sdict = defaultdict(lambda: defaultdict(int))
        self.cur_search = []
        
        for sentence, time in zip(sentences, times):
            for idx in range(1, len(sentence)+1):
                self.sdict[sentence[:idx]][sentence] = time

    def input(self, c):
        """
        :type c: str
        :rtype: List[str]
        """
        if c == '#':
            s = ''.join(self.cur_search)
            self.cur_search = []
            for idx in range(1, len(s)+1):
                self.sdict[s[:idx]][s] += 1
            return []
        else:
            self.cur_search.append(c)
            s = ''.join(self.cur_search)
            result = []
            if s in self.sdict:
                candidates = []
                for k, v in self.sdict[s].iteritems():
                    candidates.append((v, k))
                candidates.sort(key=lambda x: (-x[0], x[1]))
                for i in range(min(3, len(candidates))):
                    result.append(candidates[i][1])
            return result
                    
                
            
            
        


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)
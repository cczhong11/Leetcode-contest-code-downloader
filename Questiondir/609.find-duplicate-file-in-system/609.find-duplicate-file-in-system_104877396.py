from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dic = defaultdict(list)
        for info in paths:
            ff = info.split()
            pp = ff[0]
            for item in ff[1:]:
                pos = item.find('(')
                full_path = pp + '/' + item[:pos]
                content = item[pos+1:-1]
                dic[content].append(full_path)
        ans = [v for k,v in dic.items() if len(v) > 1]
        return ans
        

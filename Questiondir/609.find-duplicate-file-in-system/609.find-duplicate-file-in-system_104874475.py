from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        cnt_group = defaultdict(list)
        for dir_info in paths:
            spl = dir_info.split()
            dirn = spl[0]
            for i in xrange(1, len(spl)):
                fname, cnt = spl[i][:-1].split('(')
                cnt_group[cnt].append("{}/{}".format(dirn, fname))
        return [v for v in cnt_group.values() if len(v) > 1]
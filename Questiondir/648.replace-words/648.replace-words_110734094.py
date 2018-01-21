class Solution(object):
    def replaceWords(self, D, S):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = {}
        for word in D:
            node = trie
            for s in word:
                node = node.setdefault(s, {})
                if 'data' in node:
                    break
            node['data'] = 1
        ret = S.split()
        for i in xrange(len(ret)):
            node = trie
            found = False
            path = ''
            for s in ret[i]:
                if not s in node:
                    break
                path += s
                node = node[s]
                if 'data' in node:
                    found = True
                    break
            if found:
                ret[i] = path
        return ' '.join(ret)


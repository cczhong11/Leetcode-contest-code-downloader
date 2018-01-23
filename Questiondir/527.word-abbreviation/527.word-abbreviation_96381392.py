def getprefixmap(words, prefixlen):
    mapping = {}
    for word in words:
        mapping[word[:prefixlen]] = mapping.get(word[:prefixlen], [])
        mapping[word[:prefixlen]].append(word)
    return mapping

class Solution(object):
    def wordsAbbreviation(self, d):
        """
        :type dict: List[str]
        :rtype: List[str]
        """
        # word -> abbr
        abbmap = {}
        longwords = []
        for word in d:
            if len(word) <= 3:
                abbmap[word] = word
            else:
                longwords.append(word)
        # (len, lastchar) -> words
        cache = {}
        for word in longwords:
            key = (len(word), word[-1])
            cache[key] = cache.get(key, [])
            cache[key].append(word)
        
        for key, words in cache.iteritems():
            #if len(words) == 1:
            #    word = words[0]
            #    abbmap[word] = word[0] + str(len(word)-2) + word[-1]
            #    continue
            prefixlen = 1
            currwords = words
            while prefixlen < key[0]-2:
                prefixmap = getprefixmap(currwords, prefixlen)
                for prefix in prefixmap.keys():
                    if len(prefixmap[prefix]) == 1:
                        word = prefixmap[prefix][0]
                        abbmap[word] = prefix + str(len(word)-len(prefix)-1) + word[-1]
                        del prefixmap[prefix]
                if len(prefixmap) == 0:
                    break
                prefixlen += 1
                currwords = []
                for prefix in prefixmap:
                    currwords.extend(prefixmap[prefix])
            else:
                for word in currwords:
                    abbmap[word] = word
        return [abbmap[word] for word in d]
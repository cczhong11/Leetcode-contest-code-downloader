from collections import Counter
class Solution(object):
    def shortestCompletingWord(self, a, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        a = a.lower()
        a = filter(lambda x: x.isalpha(), list(a))
        a_cnt = Counter(a)
        def check(a_cnt, cnt):
            for key in a_cnt:
                if a_cnt[key] > cnt[key]:
                    return False
            return True
        ans = None
        for word in words:
            s_word = word.lower()
            cnt = Counter(list(s_word))
            if check(a_cnt, cnt):
                if ans is None:
                    ans = word
                elif len(word) < len(ans):
                    ans = word
        return ans

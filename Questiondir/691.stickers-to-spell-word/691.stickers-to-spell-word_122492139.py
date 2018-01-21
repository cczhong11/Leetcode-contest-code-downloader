import functools

class Solution:
  def minStickers(self, stickers, target):
    """
        :type stickers: List[str]
        :type target: str
        :rtype: int
        """
    set_stickers = set()
    for s in stickers:
      set_stickers |= set(s)
    set_target = set(target)
    if not set_target.issubset(set_stickers):
      return -1

    tp_stickers = [Solution.letterCount(s) for s in stickers]
    tp_target = Solution.letterCount(target)

    @functools.lru_cache(maxsize=None)
    def recur(tp_tgt, i, cnt):
      while i < 26 and tp_tgt[i] == 0:
        i += 1
      if i == 26:
        return 0
      return min([recur(Solution.minus(tp_tgt, tp), i, cnt+1)
                  for tp in tp_stickers if tp[i] > 0]) + 1

    return recur(tp_target, 0, 0)
    
  @staticmethod
  def letterCount(s):
    cnt = [0] * 26
    for c in s:
      cnt[ord(c) - ord('a')] += 1
    return tuple(cnt)

  @staticmethod
  def minus(tp_a, tp_b):
    return tuple([tp_a[i] - tp_b[i] if tp_a[i] - tp_b[i] > 0 else 0
                  for i in range(26)])

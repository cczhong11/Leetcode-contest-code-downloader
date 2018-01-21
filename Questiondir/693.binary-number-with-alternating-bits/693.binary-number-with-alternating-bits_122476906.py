class Solution(object):
  def hasAlternatingBits(self, n):
    """
        :type n: int
        :rtype: bool
        """
    while n:
      if (n & 0x3) not in (0x2, 0x1):
        return False
      n >>= 1
    return True

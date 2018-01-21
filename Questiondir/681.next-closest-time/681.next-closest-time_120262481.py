class Solution(object):
    def nextClosestTime(self, time):
        """
        :type time: str
        :rtype: str
        """
        hh, mm = time.split(':')
        h1, h2 = int(hh[0]), int(hh[1])
        m1, m2 = int(mm[0]), int(mm[1])
        tmp_s = set([h1, h2, m1, m2])

        best = None
        b_diff = None
        for h1 in tmp_s:
          for h2 in tmp_s:
            for m1 in tmp_s:
              for m2 in tmp_s:
                hh = h1 * 10 + h2
                mm = m1 * 10 + m2
                if hh < 24 and mm < 60:
                  hh, mm = str(hh), str(mm)
                  if len(hh) == 1: hh = '0' + hh
                  if len(mm) == 1: mm = '0' + mm
                  time2 = hh + ':' + mm
                  diff_ = self.diff(time, time2)
                  if b_diff is None or diff_ < b_diff:
                    b_diff = diff_
                    best = time2
        return best
        
    def diff(self, time1, time2):
        hh1, mm1 = time1.split(':')
        hh2, mm2 = time2.split(':')
        hh1, mm1 = int(hh1), int(mm1)
        hh2, mm2 = int(hh2), int(mm2)
        if hh1 < hh2 or (hh1 == hh2 and mm1 < mm2):
          diff = (hh2-hh1)*60 + mm2 - mm1
        else:
          diff = hh2 * 60 + mm2
          diff += (24-hh1) * 60 - mm1
        return diff
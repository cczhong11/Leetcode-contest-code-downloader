class Solution(object):
	def to_idx(self, time):
		h, m = time.split(':')
		return 60 * int(h) + int(m)
	def to_str(self, time):
		h = int(time / 60)
		m = time % 60
		h = '0' + str(h) if h < 10 else str(h)
		m = '0' + str(m) if m < 10 else str(m)
		return h + ':' + m

	def nextClosestTime(self, time):
		t1 = self.to_idx(time)
		for i in range(1, 1441):
			match = True
			tmp = self.to_str((i + t1) % 1440)
			for c in tmp:
				if c not in time:
					match = False
					break
			if match:
				return tmp
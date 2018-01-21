class Solution(object):
	def calPoints(self, ops):
		points = []
		for o in ops:
			if o == '+':
				if len(points) > 1:
					points.append(points[-1] + points[-2])
			elif o == 'D':
				if points:
					points.append(2 * points[-1])
			elif o == 'C':
				if points:
					points.pop()
			else:
				points.append(int(o))
		return sum(points)
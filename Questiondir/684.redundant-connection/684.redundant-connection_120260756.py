class Solution(object):
	class UnionFind(object):
		def __init__(self, keys):
			self.size = len(keys)
			self.parent = {}
			self.rank = {}
			for n in keys:
				self.parent[n] = n
				self.rank[n] = 0

		def find(self, i):
			if self.parent[i] != self.parent[self.parent[i]]:
				self.parent[i] = self.find(self.parent[i])
			return self.parent[i]


		def union(self, i, j):
			i_root = self.find(i)
			j_root = self.find(j)
			if i_root == j_root:
				return
			if self.rank[i_root] > self.rank[j_root]:
				self.parent[j_root] = i_root
			elif self.rank[i_root] < self.rank[j_root]:
				self.parent[i_root] = j_root
			else:
				self.parent[i_root] = j_root
				self.rank[j_root] += 1

		def count(self):
			return len(set(self.find(i) for i in range(self.size)))
	
	def findRedundantConnection(self, edges):
		to_remove = []
		all_node = set()
		for e in edges:
			all_node.add(e[0])
			all_node.add(e[1])
		uf = self.UnionFind(all_node)

		for e in edges:
			start = e[0]
			end = e[1]
			if uf.find(start) != uf.find(end):
				uf.union(start, end)
			else:
				to_remove.append(e)
		return to_remove[-1]
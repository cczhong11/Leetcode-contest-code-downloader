from itertools import combinations

def flip(v):
	return 1-v

def flip_all(arr):
	return [flip(v) for v in arr]

def flip_ev(v, i):
	return 1-v if i%2 == 0 else v

def flip_o(v, i):
	return 1-v if i%2==1 else v

def flip_3(v, i):
	return 1-v if i%3==0 else v

def flip_even(arr):
	return [flip_ev(arr[i], i) for i in xrange(len(arr))]

def flip_odd(arr):
	return [flip_o(arr[i], i) for i in xrange(len(arr))]

def flip_3k(arr):
	return [flip_3(arr[i], i) for i in xrange(len(arr))]

funcs = [flip_all, flip_even, flip_odd, flip_3k]

def exact_m_movs(m):
	return list(combinations(funcs, m))

def m_movs(m):
    all_movs = []
    for i in xrange(m, -1, -2):
        if i <= 4:
            all_movs.extend(exact_m_movs(i))
    return all_movs


class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        arr = [1 for _ in xrange(n)]
        all_final = set()
        for f_list in m_movs(m):
            a = arr[:]
            for f in f_list:
                a = f(a)
            all_final.add(tuple(a))
        return len(all_final)


            
        
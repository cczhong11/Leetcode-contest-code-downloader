import copy as deepcopy
import re
px = 0
class Solution(object):
    def evaluate(self, e):
        """
        :type expression: str
        :rtype: int
        """
        nodes = []
        token = ''
        for i in e:
            if i == '(' or i == ')':
                if len(token) > 0:
                    nodes.append(token)
                    token = ''
                nodes.append(i)
            elif i == ' ':
                if len(token) > 0:
                    nodes.append(token)
                    token = ''
            else:
                token += i
        if len(token) > 0:
            nodes.append(token)
        print nodes
        global px
        px = 0
        def evalx(nodes, env):
            global px
            if nodes[px] != "(":
                px += 1
                if re.match('^[\-\+]*[0-9]+$', nodes[px-1]) is not None:
                    return int(nodes[px-1])
                else:
                    return int(env[nodes[px-1]])
            px += 1
            if nodes[px] == "let":
                px += 1
                while nodes[px+1] != ")" and re.match('^[a-z][a-z0-9]*$', nodes[px]) is not None:
                    name = nodes[px]
                    px += 1
                    env[name] = evalx(nodes, deepcopy.deepcopy(env))
                res = evalx(nodes, env)
            elif nodes[px] == "add":
                px += 1
                x1 = evalx(nodes, deepcopy.deepcopy(env))
                x2 = evalx(nodes, deepcopy.deepcopy(env))
                res = x1 + x2
            elif nodes[px] == "mult":
                px += 1
                x1 = evalx(nodes, deepcopy.deepcopy(env))
                x2 = evalx(nodes, deepcopy.deepcopy(env))
                res = x1 * x2
            px += 1
            return res
        return evalx(nodes, {})

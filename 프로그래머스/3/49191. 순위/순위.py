from collections import defaultdict


def solution(n, results):
    def dfsUp(start):
        if len(parents[start]) == 0:
            return 0

        result = 0
        for p in parents[start]:
            if not visited[p]:
                visited[p] = True
                result += dfsUp(p) + 1

        return result

    def dfsDown(start):
        if len(childs[start]) == 0:
            return 0

        result = 0
        for c in childs[start]:
            if not visited[c]:
                visited[c] = True
                result += dfsDown(c) + 1

        return result

    parents = defaultdict(list)
    childs = defaultdict(list)

    for a, b in results:
        parents[b].append(a)
        childs[a].append(b)

    answer = 0
    for start in range(1, n + 1):
        visited = [False] * (n + 1)
        res = dfsUp(start) + dfsDown(start)
        if res + 1 == n:
            answer += 1

    return answer

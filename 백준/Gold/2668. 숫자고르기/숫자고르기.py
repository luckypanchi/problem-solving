import sys

input = sys.stdin.readline


def dfs(curr, visitedIdx, visitedValue):
    visitedIdx.add(curr)
    nxt = numbers[curr]
    visitedValue.add(nxt)
    if numbers[curr] not in visitedIdx:
        return dfs(nxt, visitedIdx, visitedValue)
    else:
        return (visitedIdx, visitedValue)


n = int(input())
numbers = [0] + [int(input()) for _ in range(n)]

results = set()
for num in range(1, n + 1):
    visitedIdx, visitedValue = dfs(num, set(), set())
    if visitedIdx == visitedValue:
        results = results.union(visitedIdx)

results = list(results)
results.sort()

print(len(results))
for res in results:
    print(res)
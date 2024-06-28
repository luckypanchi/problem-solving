import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def dfs(curr, start, depth):
    nextNode = array[curr]

    if not visited[nextNode]:
        visited[nextNode] = True
        return dfs(nextNode, start, depth + 1)
    elif visited[nextNode] and nextNode == start:
        return depth


n = int(input())
array = list(map(int, input().split()))

sortedArray = sorted(array)
rank = defaultdict(int)
for i in range(n):
    rank[sortedArray[i]] = i

array = [rank[num] for num in array]

visited = [False] * n
groupSizes = []
for start in range(n):
    if not visited[start]:
        visited[start] = True
        groupSizes.append(dfs(start, start, 1))

answer = sum(groupSizes) - len(groupSizes)

print(answer)
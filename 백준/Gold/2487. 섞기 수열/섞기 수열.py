import sys

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def dfs(curr, start, depth):
    nextNode = array[curr]

    if not visited[nextNode]:
        visited[nextNode] = True
        return dfs(nextNode, start, depth + 1)
    elif visited[nextNode] and nextNode == start:
        return depth


n = int(input())
array = [0] + list(map(int, input().split()))

visited = [False] * (n + 1)
groupSizes = []
for start in range(1, n + 1):
    if not visited[start]:
        visited[start] = True
        groupSizes.append(dfs(start, start, 1))

answer = groupSizes[0]
for sz in groupSizes:
    answer = answer * sz // gcd(answer, sz)

print(answer)
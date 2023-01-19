import sys

input = sys.stdin.readline


n = int(input())
nodes = [[] for _ in range(n)]
parent = list(map(int, input().split()))
head = 0
for i in range(n):
    p = parent[i]
    if p != -1:
        nodes[p].append(i)
    else:
        head = i

target = int(input())


def count(n):
    if len(nodes[n]) == 0:
        return 1

    cnt = 0
    for c in nodes[n]:
        cnt += count(c)

    return cnt


if target == head:
    print(0)

else:
    nodes[parent[target]].remove(target)

    print(count(head))

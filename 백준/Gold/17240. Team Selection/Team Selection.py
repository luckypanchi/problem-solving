import sys

input = sys.stdin.readline


def solve(curr, prevPoint):
    global answer
    if curr == 5:
        answer = max(answer, prevPoint)
        return

    for i in range(5):
        if not isRoleSelected[i]:
            isRoleSelected[i] = True
            for point, mem in roles[i]:
                if not isMemberSelected[mem]:
                    isMemberSelected[mem] = True
                    solve(curr + 1, prevPoint + point)
                    isMemberSelected[mem] = False
                    break
            isRoleSelected[i] = False


n = int(input())
members = [list(map(int, input().split())) for _ in range(n)]

roles = [[] for _ in range(5)]

for i in range(n):
    for j in range(5):
        roles[j].append((members[i][j], i))

for r in roles:
    r.sort(reverse=True)

isRoleSelected = [False] * 5
isMemberSelected = [False] * n

answer = -1

solve(0, 0)

print(answer)
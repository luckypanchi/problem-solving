import sys
from collections import deque

input = sys.stdin.readline


def solve():
    s = a + b + c
    if s % 3 != 0:
        return 0

    check = [[False] * 1501 for _ in range(1501)]
    que = deque()

    check[a][b] = True
    que.append((a, b))

    while que:
        x, y = que.popleft()

        arr = [x, y, s - x - y]

        for i in range(3):
            for j in range(3):
                if i != j and arr[i] < arr[j]:
                    tmp = [x, y, s - x - y]
                    tmp[i] += arr[i]
                    tmp[j] -= arr[i]
                    if not check[tmp[0]][tmp[1]]:
                        check[tmp[0]][tmp[1]] = True
                        que.append((tmp[0], tmp[1]))

    if check[s // 3][s // 3]:
        return 1
    else:
        return 0


a, b, c = map(int, input().split())

answer = solve()

print(answer)
import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


target = "123456780"

string = ""
for _ in range(3):
    string += "".join(input().split())

curr = 0
for i in range(9):
    if string[i] == "0":
        curr = i
        break

que = deque()
visited = set()

que.append((string, curr, 0))

while que:
    s, idx, cnt = que.popleft()

    y = idx // 3
    x = idx % 3

    if s == target:
        print(cnt)
        sys.exit()

    str_arr = list(s)

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < 3 and 0 <= nx < 3:
            nidx = ny * 3 + nx
            str_arr[idx], str_arr[nidx] = str_arr[nidx], str_arr[idx]
            next_s = "".join(str_arr)
            if next_s not in visited:
                visited.add(next_s)
                que.append((next_s, nidx, cnt + 1))
            str_arr[idx], str_arr[nidx] = str_arr[nidx], str_arr[idx]

print(-1)
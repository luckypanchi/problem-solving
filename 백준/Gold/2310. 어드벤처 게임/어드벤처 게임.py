import sys
from collections import deque

input = sys.stdin.readline


while True:
    n = int(input())
    if n == 0:
        break

    mazes = [[]] + [list(input().split()) for _ in range(n)]

    que = deque()
    que.append((1, 0))
    visited = [False] * (n + 1)

    while que:
        curr_door, money = que.popleft()
        curr = mazes[curr_door]

        curr_type = curr[0]
        price = int(curr[1])
        next_doors = list(map(int, curr[2:-1]))

        if curr_type == "L":
            money = max(money, price)
        elif curr_type == "T":
            if money < price:
                continue
            else:
                money -= price

        visited[curr_door] = True

        for next_door in next_doors:
            if not visited[next_door]:
                que.append((next_door, money))

    if visited[n]:
        print("Yes")
    else:
        print("No")
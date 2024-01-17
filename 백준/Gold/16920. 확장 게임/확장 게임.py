import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def bfs(player):
    que = deque()
    cnt = 0

    while queList[player]:
        startY, startX = queList[player].popleft()
        que.append((startY, startX, 0))

    while que:
        y, x, moveCount = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (
                0 <= ny < n
                and 0 <= nx < m
                and moveCount < moveLimit[player]
                and board[ny][nx] == "."
            ):
                board[ny][nx] = player
                cnt += 1
                que.append((ny, nx, moveCount + 1))

                if moveCount + 1 == moveLimit[player]:
                    queList[player].append((ny, nx))

    if cnt == 0:
        return False

    answers[player] += cnt
    return True


n, m, p = map(int, input().split())
moveLimit = [0] + list(map(int, input().split()))
board = [list(input().strip()) for _ in range(n)]

queList = [deque() for _ in range(p + 1)]
answers = [0] * (p + 1)

for i in range(n):
    for j in range(m):
        if board[i][j] != "." and board[i][j] != "#":
            board[i][j] = int(board[i][j])
            queList[board[i][j]].append((i, j))
            answers[board[i][j]] += 1

while True:
    flag = False
    for currPlayer in range(1, p + 1):
        if bfs(currPlayer):
            flag = True

    if not flag:
        break

print(*answers[1:])


"""
// General case

2 3 1
2
1..
...

답 6

2 5 3
2 2 1
1....
..3.2

답 5 4 1

3 9 9
1 1 1 1 1 1 1 1 1
123456789
.#......#
#######..

답 2 1 2 2 2 2 2 4 1

4 10 1
1000000000
1.........
1.........
1.........
1.........

답 40

4 10 4
1000000000 1 100 99999
1#........
#.........
2#.......#
3#......#4

답 1 1 1 1

// 반례1

3 4 4
1 1 1 1
.#..
#..#
1234

답 1 2 4 1

// 반례2

3 4 2
2 1
1...
1..2
....

답 9 3

5 10 4
1 2 1 2
1........2
.....44...
......4...
2.........
....3.....

답 5 21 4 20

5 7 2
4 1
...1...
.......
.......
.......
1....2.

답 32 3

반례1의 경우, 빈 칸을 방문하지 못하는 경우가 있을때,

반례2는 경로를 다른 성이 막고 있어서 확장해야 할 곳을 제대로 확장하지 못할 때 입니다.
"""
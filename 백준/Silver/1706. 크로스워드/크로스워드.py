import sys

input = sys.stdin.readline


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]

words = []

for i in range(r):
    s = ""
    cursor = 0
    while cursor < c:
        if board[i][cursor] == "#":
            if 1 < len(s):
                words.append(s)
            s = ""
        else:
            s += board[i][cursor]
        cursor += 1

    if 1 < len(s):
        words.append(s)


for i in range(c):
    s = ""
    cursor = 0
    while cursor < r:
        if board[cursor][i] == "#":
            if 1 < len(s):
                words.append(s)
            s = ""
        else:
            s += board[cursor][i]
        cursor += 1

    if 1 < len(s):
        words.append(s)

words.sort()
print(words[0])
import sys

input = sys.stdin.readline


def flip(char):
    if char == "H":
        return "T"
    else:
        return "H"


n = int(input())
matrix = [list(input().strip()) for _ in range(n)]

answer = n * n
state = 0

while state < (1 << n):
    result = 0
    for i in range(n):
        cnt = 0
        for j in range(n):
            char = matrix[i][j]
            if state & (1 << j):
                char = flip(char)
            if char == "T":
                cnt += 1
        result += min(cnt, n - cnt)
    answer = min(answer, result)
    state += 1

print(answer)

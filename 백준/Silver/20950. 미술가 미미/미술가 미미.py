import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, count, r, g, b):
    global answer

    if count == 7 or curr == n:
        if count < 2:
            return

        r //= count
        g //= count
        b //= count

        answer = min(answer, abs(r - gomduri[0]) + abs(g - gomduri[1]) + abs(b - gomduri[2]))
        return

    solve(curr + 1, count + 1, r + colors[curr][0], g + colors[curr][1], b + colors[curr][2])
    solve(curr + 1, count, r, g, b)


n = int(input())
colors = [list(map(int, input().split())) for _ in range(n)]
gomduri = list(map(int, input().split()))

isSelected = [False] * n
answer = INF

solve(0, 0, 0, 0, 0)

print(answer)
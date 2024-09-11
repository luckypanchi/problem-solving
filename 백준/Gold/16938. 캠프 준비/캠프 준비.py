import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, _min, _max, _sum):
    global answer
    if curr == n:
        if L <= _sum <= R and X <= _max - _min:
            answer += 1
        return

    solve(curr + 1, min(_min, givens[curr]), max(_max, givens[curr]), _sum + givens[curr])
    solve(curr + 1, _min, _max, _sum)


n, L, R, X = map(int, input().split())
givens = list(map(int, input().split()))

answer = 0
solve(0, INF, -INF, 0)

print(answer)
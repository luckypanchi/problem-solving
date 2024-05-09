import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, flavor1, flavor2, count):
    if curr == n:
        if count == 0:
            return INF
        return abs(flavor1 - flavor2)

    return min(
        solve(curr + 1, flavor1 * flavors[curr][0], flavor2 + flavors[curr][1], count + 1),
        solve(curr + 1, flavor1, flavor2, count),
    )


n = int(input())
flavors = [list(map(int, input().split())) for _ in range(n)]


print(solve(0, 1, 0, 0))
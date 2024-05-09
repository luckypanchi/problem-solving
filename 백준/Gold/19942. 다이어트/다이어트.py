import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, prevProtein, prevFat, prevCarbs, prevVitamin, prevCost, selected):
    if curr == n:
        if prevProtein >= mp and prevFat >= mf and prevCarbs >= ms and prevVitamin >= mv:
            return (prevCost, selected)
        return (INF, [])

    cost = INF
    selectedArray = []

    c, array = solve(curr + 1, prevProtein, prevFat, prevCarbs, prevVitamin, prevCost, selected)

    if c < cost:
        cost = c
        selectedArray = [array]
    elif c == cost:
        selectedArray.append(array)

    c, array = solve(
        curr + 1,
        prevProtein + nutrients[curr][0],
        prevFat + nutrients[curr][1],
        prevCarbs + nutrients[curr][2],
        prevVitamin + nutrients[curr][3],
        prevCost + nutrients[curr][4],
        selected + [curr + 1],
    )

    if c < cost:
        cost = c
        selectedArray = [array]
    elif c == cost:
        selectedArray.append(array)

    selectedArray.sort()

    return (cost, selectedArray[0])


n = int(input())
mp, mf, ms, mv = map(int, input().split())
nutrients = [list(map(int, input().split())) for _ in range(n)]

cost, selected = solve(0, 0, 0, 0, 0, 0, [])

if cost == INF:
    print(-1)
else:
    print(cost)
    print(*selected)
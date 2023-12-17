import sys

input = sys.stdin.readline


def dfs(players, positions, prevSum, playerIndex):
    if playerIndex == 11:
        return prevSum

    results = [0]

    for i in range(11):
        ability = players[playerIndex][i]
        if ability != 0 and not positions[i]:
            positions[i] = True
            results.append(dfs(players, positions, prevSum + ability, playerIndex + 1))
            positions[i] = False

    return max(results)


tc = int(input())
for _ in range(tc):
    players = [list(map(int, input().split())) for _ in range(11)]

    positions = [False] * 11
    answer = dfs(players, positions, 0, 0)

    print(answer)
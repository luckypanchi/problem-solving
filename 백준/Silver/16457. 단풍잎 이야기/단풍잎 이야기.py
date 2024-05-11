import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, start):
    if curr == n:
        count = 0
        for quest in quests:
            flag = False
            for skill in quest:
                if not isSelected[skill]:
                    flag = True
                    break
            if not flag:
                count += 1
        return count

    result = 0
    for i in range(start, 2 * n + 1):
        isSelected[i] = True
        result = max(result, solve(curr + 1, i + 1))
        isSelected[i] = False

    return result


n, m, k = map(int, input().split())
quests = [list(map(int, input().split())) for _ in range(m)]

isSelected = [False] * (2 * n + 1)

print(solve(0, 1))
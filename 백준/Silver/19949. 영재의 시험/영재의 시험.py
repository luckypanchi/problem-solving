import sys

input = sys.stdin.readline


def solve(curr, prevList, correctCount):
    if curr == 10:
        if correctCount >= 5:
            return 1
        return 0

    result = 0

    for ans in range(1, 6):
        if len(prevList) >= 2 and prevList[-1] == ans and prevList[-2] == ans:
            continue

        count = correctCount
        if exams[curr] == ans:
            count += 1

        result += solve(curr + 1, prevList + [ans], count)

    return result


exams = list(map(int, input().split()))

print(solve(0, [], 0))
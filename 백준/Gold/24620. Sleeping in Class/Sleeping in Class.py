import sys

input = sys.stdin.readline

INF = float("inf")


def check(targetSum, targetCount):
    count = 0
    start = 0
    for end in range(1, n + 1):
        currSum = prefixSum[end] - prefixSum[start]
        if currSum == targetSum:
            count += 1
            start = end
        elif currSum > targetSum:
            return False

    return count == targetCount


tc = int(input())
for _ in range(tc):
    n = int(input())
    numbers = [0] + list(map(int, input().split()))
    prefixSum = [0] * (n + 1)
    for i in range(1, n + 1):
        prefixSum[i] = numbers[i] + prefixSum[i - 1]
    totalSum = prefixSum[-1]

    if totalSum == 0:
        print(0)
        continue

    answer = INF

    for i in range(1, int(totalSum**0.5) + 1):
        if totalSum % i == 0:
            if check(i, totalSum // i):
                answer = min(answer, n - totalSum // i)

            if check(totalSum // i, i):
                answer = min(answer, n - i)

    print(answer)

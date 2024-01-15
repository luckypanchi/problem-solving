import sys
import math

input = sys.stdin.readline


def solve(currLength, visited, remainder):
    if visited == (1 << n) - 1:
        return 1 if remainder == 0 else 0

    if dp[visited][remainder] != -1:
        return dp[visited][remainder]

    result = 0

    for i in range(n):
        if visited & (1 << i) == 0:
            result += solve(
                currLength + numberLength[i],
                visited | (1 << i),
                (remainders[i][currLength] + remainder) % k,
            )

    dp[visited][remainder] = result
    return dp[visited][remainder]


n = int(input())
numbers = [int(input()) for _ in range(n)]
k = int(input())

dp = [[-1] * k for _ in range(1 << n)]
numberLength = [len(str(number)) for number in numbers]
remainders = [[0] * sum(numberLength) for _ in range(n)]
for i in range(n):
    for j in range(sum(numberLength)):
        remainders[i][j] = (numbers[i] * 10**j) % k

answer = solve(0, 0, 0)

total = math.factorial(n)
gcd = math.gcd(answer, total)

print(f"{answer // gcd}/{total // gcd}")
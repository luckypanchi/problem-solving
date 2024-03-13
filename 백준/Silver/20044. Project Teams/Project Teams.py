import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
numbers = sorted(list(map(int, input().split())))

answer = INF
for i in range(n):
    answer = min(answer, numbers[i] + numbers[2 * n - 1 - i])

print(answer)
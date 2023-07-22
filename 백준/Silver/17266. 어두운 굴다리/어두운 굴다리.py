import sys
import math

input = sys.stdin.readline


n = int(input())
m = int(input())
lights = list(map(int, input().split()))

answer = lights[0]
answer = max(answer, n - lights[m - 1])

for i in range(1, m):
    length = math.ceil((lights[i] - lights[i - 1]) / 2)
    answer = max(answer, length)


print(answer)
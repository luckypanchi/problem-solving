import sys

input = sys.stdin.readline


n = int(input())
tools = sorted(list(map(int, input().split())))

if n % 2 == 0:
    answer = 0
    for i in range(n // 2):
        answer = max(tools[i] + tools[n - 1 - i], answer)

else:
    answer = tools[n - 1]
    for i in range(n // 2):
        answer = max(tools[i] + tools[n - 2 - i], answer)

print(answer)

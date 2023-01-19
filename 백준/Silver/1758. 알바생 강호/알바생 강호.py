import sys

input = sys.stdin.readline


n = int(input())
tips = sorted([int(input()) for _ in range(n)], reverse=True)

answer = 0

for idx, tip in enumerate(tips):
    answer += 0 if (tip - idx) < 0 else tip - idx

print(answer)

import sys

input = sys.stdin.readline


n = int(input())

answer = 0
for a in range(1, n):
    for b in range(1, n):
        for c in range(1, n):
            if a + b + c != n:
                continue
            if c < b + 2:
                continue
            if a % 2 != 0:
                continue

            answer += 1

print(answer)

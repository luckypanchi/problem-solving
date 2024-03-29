import sys

input = sys.stdin.readline


s = input().strip()
p = input().strip()

start = 0
answer = 0
for end in range(1, len(p)):
    if s.find(p[start : end + 1]) == -1:
        answer += 1
        start = end

print(answer + 1)
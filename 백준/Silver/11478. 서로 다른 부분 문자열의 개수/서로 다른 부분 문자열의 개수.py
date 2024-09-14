import sys
from collections import defaultdict

input = sys.stdin.readline


s = list(input().strip())
flag = defaultdict(bool)

answer = 0
for start in range(len(s)):
    for end in range(start + 1, len(s) + 1):
        curr = "".join(s[start:end])
        if not flag[curr]:
            flag[curr] = True
            answer += 1


print(answer)
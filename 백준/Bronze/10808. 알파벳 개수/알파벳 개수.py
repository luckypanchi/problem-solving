import sys

input = sys.stdin.readline


string = input().strip()
answer = [0] * 26

for s in string:
    answer[ord(s) - ord("a")] += 1

print(*answer)

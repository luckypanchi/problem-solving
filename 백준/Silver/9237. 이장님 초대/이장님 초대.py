import sys

input = sys.stdin.readline


n = int(input())
trees = sorted(list(map(int, input().split())), reverse=True)

answer = 0
for idx, tree in enumerate(trees):
    answer = max(answer, idx + tree + 2)

print(answer)

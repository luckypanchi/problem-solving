import sys
from collections import defaultdict

input = sys.stdin.readline


n, k = map(int, input().split())
student = [len(input().strip()) for _ in range(n)]

store = defaultdict(int)
answer = 0

for i in range(n):
    if k < i:
        store[student[i - k - 1]] -= 1
    answer += store[student[i]]
    store[student[i]] += 1

print(answer)
import sys
from collections import Counter, defaultdict

input = sys.stdin.readline


n, c = map(int, input().split())
numbers = list(map(int, input().split()))

show = defaultdict(int)
counter = Counter(numbers)
for i in range(n):
    if show[numbers[i]] == 0:
        show[numbers[i]] = i + 1

numbers.sort(key=lambda x: (-counter[x], show[x]))
print(*numbers)
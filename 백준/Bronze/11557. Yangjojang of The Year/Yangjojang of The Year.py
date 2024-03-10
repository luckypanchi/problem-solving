import sys
from collections import defaultdict

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    counter = defaultdict(int)
    n = int(input())
    for _ in range(n):
        a, b = input().split()
        counter[a] += int(b)

    array = list(counter.items())
    array.sort(key=lambda x: x[1], reverse=True)
    print(array[0][0])

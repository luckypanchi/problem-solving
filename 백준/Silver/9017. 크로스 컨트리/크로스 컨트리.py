import sys
from collections import defaultdict, Counter

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    teams = defaultdict(list)
    n = int(input())
    array = list(map(int, input().split()))
    counter = Counter(array)

    point = 1
    for i in range(n):
        if counter[array[i]] == 6:
            teams[array[i]].append(point)
            point += 1

    _sort = []
    for t in teams:
        _sort.append((sum(teams[t][:4]), teams[t][4], t))

    _sort.sort(key=lambda x: (x[0], x[1]))
    print(_sort[0][2])
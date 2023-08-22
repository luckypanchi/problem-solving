import sys
from collections import defaultdict

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    string = input().strip()
    n = len(string)
    k = int(input())
    index_list = defaultdict(list)

    for i in range(n):
        index_list[string[i]].append(i)

    answer1 = n + 1
    answer2 = -1

    for s in index_list:
        length = len(index_list[s])
        if length < k:
            continue

        for start in range(length - k + 1):
            end = start + k - 1
            answer1 = min(answer1, index_list[s][end] - index_list[s][start] + 1)
            answer2 = max(answer2, index_list[s][end] - index_list[s][start] + 1)

    if (answer1, answer2) == (n + 1, -1):
        print(-1)
    else:
        print(answer1, answer2)

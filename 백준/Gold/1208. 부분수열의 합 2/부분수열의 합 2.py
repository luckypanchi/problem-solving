import sys
from itertools import combinations
from collections import defaultdict

input = sys.stdin.readline


def get_subset_sum(array):
    sum_list = defaultdict(int)

    for k in range(1, len(array) + 1):
        combs = list(combinations(array, k))
        for comb in combs:
            sum_list[sum(list(comb))] += 1

    return sum_list


n, s = map(int, input().split())
numbers = sorted(list(map(int, input().split())))

left = numbers[: n // 2]
right = numbers[n // 2 :]


left = get_subset_sum(left)
right = get_subset_sum(right)

answer = 0

answer += left[s]

answer += right[s]

for left_key in left:
    answer += left[left_key] * right[s - left_key]

print(answer)

"""
40 0
100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000

137846528819

5 0
0 0 0 0 0

# ans
31

# wrong output
17

input :
5 5
1 2 3 4 5

output :
2
correct ans :
3
"""
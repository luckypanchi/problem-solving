import sys

input = sys.stdin.readline


n = int(input())
_min = list(map(int, input().split()))
_max = _min.copy()

for _ in range(n - 1):
    row = list(map(int, input().split()))
    tmp_min = [0] * 3
    tmp_max = [0] * 3
    tmp_min[0] = row[0] + min(_min[0], _min[1])
    tmp_min[1] = row[1] + min(_min)
    tmp_min[2] = row[2] + min(_min[1], _min[2])

    tmp_max[0] = row[0] + max(_max[0], _max[1])
    tmp_max[1] = row[1] + max(_max)
    tmp_max[2] = row[2] + max(_max[1], _max[2])

    _min = tmp_min
    _max = tmp_max

print(max(_max), min(_min))
import sys

input = sys.stdin.readline
INF = int(1e9)


tc = int(input())

for _ in range(tc):
    n = int(input())
    array = sorted(list(map(int, input().split())))
    new_array = [0] * n
    left = 0
    right = n - 1
    for i in range(n):
        if i % 2 == 0:
            new_array[left] = array[i]
            left += 1
        else:
            new_array[right] = array[i]
            right -= 1
    MAX = -INF
    for i in range(n):
        MAX = max(MAX, abs(new_array[i] - new_array[(i + 1) % n]))
    print(MAX)

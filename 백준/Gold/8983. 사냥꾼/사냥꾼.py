import sys

input = sys.stdin.readline


m, n, l = map(int, input().split())
shots = sorted(list(map(int, input().split())))

answer = 0

for _ in range(n):
    x, y = map(int, input().split())

    _max = x - y + l
    _min = x + y - l

    start = 0
    end = len(shots) - 1

    while start <= end:
        mid = (start + end) // 2
        if _min <= shots[mid] <= _max:
            answer += 1
            break
        elif _max < shots[mid]:
            end = mid - 1
        else:
            start = mid + 1

print(answer)
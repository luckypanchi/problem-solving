import sys
import math

input = sys.stdin.readline


n, length = map(int, input().split())
pools = [list(map(int, input().split())) for _ in range(n)]
pools.sort(key=lambda x: x[0])

end = 0
answer = 0

for poolStart, poolEnd in pools:
    if poolEnd <= end:
        continue

    start = max(end + 1, poolStart)
    d = poolEnd - start
    cnt = math.ceil(d / length)
    answer += cnt
    end = start + cnt * length - 1

print(answer)

"""
3 10
1 6
7 8
11 15


"""
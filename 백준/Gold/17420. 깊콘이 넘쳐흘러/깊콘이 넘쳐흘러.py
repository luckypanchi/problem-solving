import sys
import math

input = sys.stdin.readline


n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
array = [[i, j] for i, j in zip(a, b)]

array.sort(key=lambda x: (x[1], x[0]))

p = array[0][0]  # 남은 기한
th = array[0][1]  # 사용 계획
answer = 0
for i in range(n):
    if array[i][0] < th:
        t = math.ceil((th - array[i][0]) / 30)
        answer += t
        array[i][0] += 30 * t

    p = max(p, array[i][0])

    if i + 1 < n and array[i][1] != array[i + 1][1]:
        th = max(p, array[i + 1][1])

print(answer)
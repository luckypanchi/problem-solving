import sys

input = sys.stdin.readline


n, c = map(int, input().split())
m = int(input())
boxes = [list(map(int, input().split())) for _ in range(m)]

boxes.sort(key=lambda x: x[1])

capa = [c] * n
answer = 0
for s, e, box in boxes:
    _min = c
    for i in range(s, e):
        _min = min(_min, capa[i])
    _min = min(_min, box)
    answer += _min
    for i in range(s, e):
        capa[i] -= _min

print(answer)

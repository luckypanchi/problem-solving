import sys

input = sys.stdin.readline

answer = ["D", "C", "B", "A", "E"]


for _ in range(3):
    s = sum(list(map(int, input().split())))
    print(answer[s])
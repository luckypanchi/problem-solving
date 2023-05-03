import sys

input = sys.stdin.readline


x, y = input().split()


answer = str(int(x[::-1]) + int(y[::-1]))[::-1]
print(int(answer))
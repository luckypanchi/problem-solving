import sys

input = sys.stdin.readline


numbers = list(map(int, input().strip()))
numbers.sort(reverse=True)
answer = "".join(map(str, numbers))
print(answer)

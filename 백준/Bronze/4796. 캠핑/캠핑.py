import sys

input = sys.stdin.readline

answer = []

while True:
    a, b, c = map(int, input().split())

    if a == 0 and b == 0 and c == 0:
        break

    answer.append(a * (c // b) + min(c % b, a))


for i in range(len(answer)):
    print(f"Case {i+1}: {answer[i]}")

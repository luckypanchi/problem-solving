import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))
a, b = map(int, input().split())


answer = n
for number in numbers:
    number -= a
    if number > 0:
        if number % b:
            answer += (number // b) + 1
        else:
            answer += (number // b) 

print(answer)
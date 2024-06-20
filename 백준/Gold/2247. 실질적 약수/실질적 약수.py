# import sys

# input = sys.stdin.readline

# MOD = 1000000


# def SOD(num):
#     result = 0
#     for i in range(2, int(num**0.5) + 1):
#         if num % i == 0:
#             result += i
#             if num // i != i:
#                 result += num // i
#     return result


# n = int(input())

# answer = 0
# for num in range(1, n + 1):
#     answer += SOD(num) % MOD

# print(answer)

import sys

input = sys.stdin.readline

MOD = 1000000


n = int(input())

answer = 0
for num in range(2, n):
    answer = (answer + num * ((n // num) - 1)) % MOD

print(answer)
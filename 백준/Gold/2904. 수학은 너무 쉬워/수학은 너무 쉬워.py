import sys
from collections import defaultdict

input = sys.stdin.readline


def factorization(target):
    counter = defaultdict(int)
    for i in range(2, int(target**0.5) + 1):
        while target % i == 0:
            counter[i] += 1
            target //= i

    if target != 1:
        counter[target] += 1

    return counter


n = int(input())
numbers = list(map(int, input().split()))

totalCounter = defaultdict(int)
counterList = []
for number in numbers:
    counter = factorization(number)
    counterList.append(counter)
    for num in counter:
        totalCounter[num] += counter[num]

answer1 = 1
answer2 = 0
for num in totalCounter:
    if totalCounter[num] < n:
        continue

    needed = totalCounter[num] // n
    answer1 *= num**needed

    for counter in counterList:
        if counter[num] < needed:
            answer2 += needed - counter[num]


print(answer1, answer2)
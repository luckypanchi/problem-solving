import sys

input = sys.stdin.readline


n = int(input())
prices = list(map(int, input().split()))
numbers = [(i, prices[i]) for i in range(n)]
total = int(input())

noZeroList = numbers[1:]
numbers.sort(key=lambda x: x[1])
noZeroList.sort(key=lambda x: x[1])

if n == 1 or total < noZeroList[0][1]:
    print("0")
    sys.exit()

minCost1 = noZeroList[0][1]
minCost2 = numbers[0][1]

answer = str(noZeroList[0][0])
total -= noZeroList[0][1]

answer += str(numbers[0][0]) * (total // numbers[0][1])
total -= (total // numbers[0][1]) * numbers[0][1]

answer = list(answer)
numbers.sort(key=lambda x: x[0], reverse=True)
noZeroList.sort(key=lambda x: x[0], reverse=True)

for i in range(len(answer)):
    if i == 0:
        for j in range(n - 1):
            num, cost = noZeroList[j]
            if total + minCost1 - cost >= 0:
                answer[i] = str(num)
                total += minCost1 - cost
                break
    else:
        for j in range(n):
            num, cost = numbers[j]
            if total + minCost2 - cost >= 0:
                answer[i] = str(num)
                total += minCost2 - cost
                break

print("".join(answer))
import sys

input = sys.stdin.readline


tcs = int(input())

for tc in range(1, tcs + 1):
    kids = list(map(int, input().split()))[1:]
    result = 0
    array = [kids[0]]
    for i in range(1, len(kids)):
        flag = True
        for j in range(len(array)):
            if kids[i] < array[j]:
                result += len(array[j:])
                array = array[:j] + [kids[i]] + array[j:]
                flag = False
                break

        if flag:
            array.append(kids[i])

    print(f"{tc} {result}")
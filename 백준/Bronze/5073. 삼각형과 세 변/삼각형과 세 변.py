import sys

input = sys.stdin.readline


while True:
    array = list(map(int, input().split()))

    if sum(array) == 0:
        break

    array.sort()

    if array[0] + array[1] <= array[2]:
        print("Invalid")
    elif array[0] == array[1] == array[2]:
        print("Equilateral")
    elif array[0] == array[1] or array[1] == array[2] or array[2] == array[0]:
        print("Isosceles")
    else:
        print("Scalene")
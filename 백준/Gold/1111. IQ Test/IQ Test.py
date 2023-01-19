import sys

input = sys.stdin.readline


def main():
    n = int(input())
    numbers = list(map(int, input().split()))

    if n == 1:
        print("A")

    elif n == 2:
        if numbers[0] == numbers[1]:
            print(numbers[0])
        else:
            print("A")

    else:
        if numbers[0] == numbers[1]:
            for i in range(2, n):
                if numbers[i] != numbers[0]:
                    print("B")
                    return
            print(numbers[0])
        else:
            a = (numbers[2] - numbers[1]) / (numbers[1] - numbers[0])
            b = (numbers[1] ** 2 - numbers[0] * numbers[2]) / (numbers[1] - numbers[0])
            if a % 1 != 0 or b % 1 != 0:
                print("B")
                return
            a = int(a)
            b = int(b)
            for i in range(3, n):
                if numbers[i] != numbers[i - 1] * a + b:
                    print("B")
                    return
            print(numbers[-1] * a + b)


main()

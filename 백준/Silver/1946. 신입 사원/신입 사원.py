import sys

input = sys.stdin.readline


def main():
    tc = int(input())

    answer = []

    for _ in range(tc):
        n = int(input())
        matrix = [list(map(int, input().split())) for _ in range(n)]
        matrix.sort(key=lambda x: x[0])

        minimum = float("inf")
        result = 0

        for _, num in matrix:
            if num < minimum:
                minimum = num
            else:
                result += 1

        answer.append(n - result)

    for result in answer:
        print(result)


main()

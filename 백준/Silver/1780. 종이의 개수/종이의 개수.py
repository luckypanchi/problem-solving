import sys

input = sys.stdin.readline


def main():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    def check(y, x, length):
        start = matrix[y][x]
        for i in range(length):
            for j in range(length):
                if start != matrix[y + i][x + j]:
                    return False
        return True

    answers = [0] * 3

    def check_and_divide(y, x, length):
        if check(y, x, length):
            answers[matrix[y][x] + 1] += 1
            return
        else:
            new_length = length // 3
            for i in range(3):
                for j in range(3):
                    check_and_divide(y + i * new_length, x + j * new_length, new_length)

    check_and_divide(0, 0, n)

    for answer in answers:
        print(answer)


main()

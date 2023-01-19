import sys

input = sys.stdin.readline


def main():
    n, l = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    def check(arr):
        mark = [False] * n
        for i in range(n - 1):
            if arr[i] == arr[i + 1]:
                continue
            if abs(arr[i] - arr[i + 1]) > 1:
                return False
            if arr[i] > arr[i + 1]:
                pivot = arr[i + 1]
                for j in range(i + 1, i + 1 + l):
                    if 0 <= j < n:
                        if arr[j] != pivot or mark[j] is True:
                            return False
                        mark[j] = True
                    else:
                        return False
            else:
                pivot = arr[i]
                for j in range(i, i - l, -1):
                    if 0 <= j < n:
                        if arr[j] != pivot or mark[j] is True:
                            return False
                        mark[j] = True
                    else:
                        return False
        return True

    answer = 0

    for i in range(n):
        if check(matrix[i]):
            answer += 1

    for j in range(n):
        column = []
        for i in range(n):
            column.append(matrix[i][j])

        if check(column):
            answer += 1

    print(answer)


main()

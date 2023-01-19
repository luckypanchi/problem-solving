import sys
input = sys.stdin.readline


def main():
    n = int(input())

    answer = []

    for _ in range(n):
        len = int(input())
        matrix = list(map(int, input().split()))

        tmp_arr = [0]*len

        tmp_arr[0] = matrix[0]

        for idx in range(1, len):
            tmp_arr[idx] = max(matrix[idx], tmp_arr[idx-1]+matrix[idx])

        answer.append(max(tmp_arr))

    for i in answer:
        print(i)


main()
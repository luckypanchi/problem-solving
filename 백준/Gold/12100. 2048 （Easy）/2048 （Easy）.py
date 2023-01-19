import sys

input = sys.stdin.readline


def get_max(n, matrix):
    result = 0
    for i in range(n):
        for j in range(n):
            result = max(result, matrix[i][j])
    return result


def move(n, matrix, d):
    new_board = [[0] * n for _ in range(n)]

    if d == 0:  # 위
        for x in range(n):
            idx = 0
            for y in range(n):
                if new_board[idx][x] == 0 and matrix[y][x] != 0:
                    new_board[idx][x] = matrix[y][x]
                elif new_board[idx][x] != 0 and matrix[y][x] != 0:
                    if new_board[idx][x] == matrix[y][x]:
                        new_board[idx][x] *= 2
                        idx += 1
                    else:
                        idx += 1
                        new_board[idx][x] = matrix[y][x]

    elif d == 1:  # 아래
        for x in range(n):
            idx = n - 1
            for y in range(n - 1, -1, -1):
                if new_board[idx][x] == 0 and matrix[y][x] != 0:
                    new_board[idx][x] = matrix[y][x]
                elif new_board[idx][x] != 0 and matrix[y][x] != 0:
                    if new_board[idx][x] == matrix[y][x]:
                        new_board[idx][x] *= 2
                        idx -= 1
                    else:
                        idx -= 1
                        new_board[idx][x] = matrix[y][x]

    elif d == 2:  # 왼쪽
        for y in range(n):
            idx = 0
            for x in range(n):
                if new_board[y][idx] == 0 and matrix[y][x] != 0:
                    new_board[y][idx] = matrix[y][x]
                elif new_board[y][idx] != 0 and matrix[y][x] != 0:
                    if new_board[y][idx] == matrix[y][x]:
                        new_board[y][idx] *= 2
                        idx += 1
                    else:
                        idx += 1
                        new_board[y][idx] = matrix[y][x]

    elif d == 3:  # 오른쪽
        for y in range(n):
            idx = n - 1
            for x in range(n - 1, -1, -1):
                if new_board[y][idx] == 0 and matrix[y][x] != 0:
                    new_board[y][idx] = matrix[y][x]
                elif new_board[y][idx] != 0 and matrix[y][x] != 0:
                    if new_board[y][idx] == matrix[y][x]:
                        new_board[y][idx] *= 2
                        idx -= 1
                    else:
                        idx -= 1
                        new_board[y][idx] = matrix[y][x]

    return new_board


def main():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    answer = 0

    def solve(n, board, cnt):
        nonlocal answer

        if cnt == 5:
            answer = max(answer, get_max(n, board))
            return

        for i in range(4):
            new_board = move(n, board, i)
            solve(n, new_board, cnt + 1)

    solve(n, matrix, 0)

    print(answer)


main()

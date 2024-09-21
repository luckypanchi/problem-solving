import sys

input = sys.stdin.readline


def dfs(curr):
    if curr == len(zero_spots):
        for row in board:
            print(*row)
        sys.exit()
        return

    y, x = zero_spots[curr]
    square_number = 3 * (y // 3) + x // 3

    for num in range(1, 10):
        if (
            not is_selected_by_col[x][num]
            and not is_selected_by_row[y][num]
            and not is_selected_by_square[square_number][num]
        ):
            is_selected_by_col[x][num] = True
            is_selected_by_row[y][num] = True
            is_selected_by_square[square_number][num] = True
            board[y][x] = num
            dfs(curr + 1)
            is_selected_by_col[x][num] = False
            is_selected_by_row[y][num] = False
            is_selected_by_square[square_number][num] = False


board = [list(map(int, input().split())) for _ in range(9)]
is_selected_by_row = [[False] * 10 for _ in range(9)]
is_selected_by_col = [[False] * 10 for _ in range(9)]
is_selected_by_square = [[False] * 10 for _ in range(9)]

zero_spots = []

for y in range(9):
    for x in range(9):
        if board[y][x] == 0:
            zero_spots.append((y, x))
            continue

        number = board[y][x]
        square_number = 3 * (y // 3) + x // 3

        is_selected_by_row[y][number] = True
        is_selected_by_col[x][number] = True
        is_selected_by_square[square_number][number] = True


dfs(0)
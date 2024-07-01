def checkWin(board, target):
    for i in range(3):
        flag = True
        for j in range(3):
            if board[i][j] != target:
                flag = False
                break

        if flag:
            return True

    for j in range(3):
        flag = True
        for i in range(3):
            if board[i][j] != target:
                flag = False
                break

        if flag:
            return True

    flag = True
    for i in range(3):
        if board[i][i] != target:
            flag = False
            break

    if flag:
        return True

    flag = True
    for i in range(3):
        if board[i][2 - i] != target:
            flag = False
            break

    if flag:
        return True

    return False


def solution(board):
    n = 3
    m = 3

    count1 = 0
    count2 = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == "O":
                count1 += 1
            elif board[i][j] == "X":
                count2 += 1

    if not (count1 == count2 or count1 == count2 + 1):
        return 0

    if checkWin(board, "O") and count1 == count2:
        return 0

    if checkWin(board, "X") and count1 == count2 + 1:
        return 0

    return 1

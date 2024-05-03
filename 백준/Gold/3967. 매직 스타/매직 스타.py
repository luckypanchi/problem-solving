import sys
from collections import deque

ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

input = sys.stdin.readline


def check():
    ops = [
        [0, 2, 5, 7],
        [0, 3, 6, 10],
        [1, 2, 3, 4],
        [1, 5, 8, 11],
        [4, 6, 9, 11],
        [7, 8, 9, 10],
    ]

    for op in ops:
        result = 0
        for i in op:
            result += numbers[i]
        if result != 26:
            return False

    return True


def printAnswer():
    que = deque(numbers)
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] != ".":
                board[i][j] = ALPHABETS[que.popleft() - 1]

    for row in board:
        print("".join(row))


def solve(curr):
    if curr == 12:
        if check():
            printAnswer()
            sys.exit()
        return

    if numbers[curr] != 0:
        solve(curr + 1)
    else:
        for i in range(1, 13):
            if not isSelected[i]:
                isSelected[i] = True
                numbers[curr] = i
                solve(curr + 1)
                numbers[curr] = 0
                isSelected[i] = False


board = [list(input().strip()) for _ in range(5)]
numbers = []
for i in range(len(board)):
    for j in range(len(board[0])):
        if board[i][j] == "x":
            numbers.append(0)
        elif board[i][j] != ".":
            numbers.append(ALPHABETS.index(board[i][j]) + 1)


isSelected = [False] * 13
for num in numbers:
    isSelected[num] = True

solve(0)

import sys
from itertools import permutations

input = sys.stdin.readline


n, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
kyunghee = list(map(int, input().split()))
minho = list(map(int, input().split()))


def dfs(player1, player2):
    if win[0] == k:
        print(1)
        sys.exit()
    if win[1] == k or win[2] == k:
        return
    if idx_list[0] == n:
        return

    player3 = 3 - (player1 + player2)
    result1 = player[player1][idx_list[player1]] - 1
    result2 = player[player2][idx_list[player2]] - 1
    idx_list[player1] += 1
    idx_list[player2] += 1
    if board[result1][result2] == 2 or (board[result1][result2] == 1 and player1 > player2):
        win[player1] += 1
        dfs(player1, player3)
    elif board[result1][result2] == 0 or (board[result1][result2] == 1 and player1 < player2):
        win[player2] += 1
        dfs(player2, player3)


for jiwo in permutations(list(range(n))):
    player = [jiwo, kyunghee, minho]
    idx_list = [0, 0, 0]
    win = [0, 0, 0]
    dfs(0, 1)

print(0)
import sys

input = sys.stdin.readline

INF = float("inf")


# player1이 이기는 경우 1 반환, 지거나 비기는 경우 0 반환
def play(player1, player2):
    if (
        (player1 == "H" and player2 == "S")
        or (player1 == "S" and player2 == "P")
        or (player1 == "P" and player2 == "H")
    ):
        return 1
    else:
        return 0


n = int(input())
john = [0] + [input().strip() for _ in range(n)]

h = [0] * (n + 1)
p = [0] * (n + 1)
s = [0] * (n + 1)

for i in range(1, n + 1):
    h[i] = play("H", john[i]) + h[i - 1]
    p[i] = play("P", john[i]) + p[i - 1]
    s[i] = play("S", john[i]) + s[i - 1]

answer = -INF
answer = max(answer, h[-1])
answer = max(answer, p[-1])
answer = max(answer, s[-1])
for i in range(2, n):
    answer = max(answer, h[i] + p[n] - p[i])
    answer = max(answer, h[i] + s[n] - s[i])
    answer = max(answer, p[i] + h[n] - h[i])
    answer = max(answer, p[i] + s[n] - s[i])
    answer = max(answer, s[i] + h[n] - h[i])
    answer = max(answer, s[i] + p[n] - p[i])

print(answer)

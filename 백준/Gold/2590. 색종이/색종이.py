import sys
import math

input = sys.stdin.readline


cards = [0] + [int(input()) for _ in range(6)]
answer = 0

answer += cards[6]

answer += cards[5]
cards[1] = max(cards[1] - (6 * 6 - 5 * 5) * cards[5], 0)

for _ in range(cards[4]):
    left = 6 * 6 - 4 * 4
    answer += 1
    size2 = min(5, cards[2])
    cards[2] -= size2
    cards[1] = max(cards[1] - (left - 2 * 2 * size2), 0)

answer += cards[3] // 4
cards[3] %= 4
if cards[3] != 0:
    answer += 1
    left = 6 * 6 - 3 * 3 * cards[3]
    if cards[3] == 1:
        size2 = min(cards[2], 5)
    elif cards[3] == 2:
        size2 = min(cards[2], 3)
    elif cards[3] == 3:
        size2 = min(cards[2], 1)

    cards[2] -= size2
    cards[1] = max(cards[1] - (left - 2 * 2 * size2), 0)

answer += cards[2] // 9
cards[2] %= 9
if cards[2] != 0:
    answer += 1
    cards[1] = max(cards[1] - (6 * 6 - 2 * 2 * cards[2]), 0)

answer += math.ceil(cards[1] / 36)

print(answer)
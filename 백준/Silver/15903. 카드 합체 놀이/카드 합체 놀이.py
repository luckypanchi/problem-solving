import sys
import heapq

input = sys.stdin.readline


n, m = map(int, input().split())
cards = list(map(int, input().split()))


heapq.heapify(cards)
for _ in range(m):
    num1 = heapq.heappop(cards)
    num2 = heapq.heappop(cards)
    heapq.heappush(cards, num1 + num2)
    heapq.heappush(cards, num1 + num2)

answer = 0
for card in cards:
    answer += card

print(answer)
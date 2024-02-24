import sys

input = sys.stdin.readline


N = int(input())
M = int(input())
busLines = []
for i in range(1, M + 1):
    a, b = map(int, input().split())
    if a < b:
        busLines.append((a, b, i))
        busLines.append((a + N, b + N, i))
    else:
        busLines.append((a, b + N, i))

busLines.sort(key=lambda x: (x[0], -x[1]))

end = -1
visited = [True] * (M + 1)
for busStart, busEnd, busNumber in busLines:
    if end < busEnd:
        end = busEnd
    else:
        visited[busNumber] = False

for busNumber in range(1, M + 1):
    if visited[busNumber]:
        print(busNumber, end=" ")
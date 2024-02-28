import sys

input = sys.stdin.readline


P, M = map(int, input().split())
rooms = []

for _ in range(P):
    lvl, n = input().split()
    lvl = int(lvl)

    flag = False
    for room in rooms:
        if len(room) < M and abs(lvl - room[0][0]) <= 10:
            room.append([lvl, n])
            flag = True
            break

    if not flag:
        rooms.append([[lvl, n]])

for room in rooms:
    room.sort(key=lambda x: x[1])

for room in rooms:
    if len(room) == M:
        print("Started!")
    else:
        print("Waiting!")

    for lvl, n in room:
        print(lvl, n)
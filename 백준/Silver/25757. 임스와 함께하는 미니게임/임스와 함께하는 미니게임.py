import sys

input = sys.stdin.readline


def getLimit(game):
    return ["", "Y", "F", "O"].index(game)


n, game = input().split()
people = set()
for _ in range(int(n)):
    people.add(input().strip())

limit = getLimit(game)
print(len(people) // limit)
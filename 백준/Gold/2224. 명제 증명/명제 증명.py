import sys

input = sys.stdin.readline

INF = int(1e9)
alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"


def convertAlpha(alpha):
    return alphabets.index(alpha)


def convertIdx(idx):
    return alphabets[idx]


graph = [[False] * 52 for _ in range(52)]
n = int(input())
for _ in range(n):
    a, _, b = input().split()
    a = convertAlpha(a)
    b = convertAlpha(b)
    graph[a][b] = True

for k in range(52):
    for a in range(52):
        for b in range(52):
            if graph[a][k] and graph[k][b]:
                graph[a][b] = True


answers = []
for a in range(52):
    for b in range(52):
        if a != b and graph[a][b]:
            answers.append(f"{convertIdx(a)} => {convertIdx(b)}")

print(len(answers))
for answer in answers:
    print(answer)
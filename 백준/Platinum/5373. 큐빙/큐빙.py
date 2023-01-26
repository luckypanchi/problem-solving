import sys

input = sys.stdin.readline

faces = {
    "U": 0,
    "F": 1,
    "R": 2,
    "B": 3,
    "L": 4,
    "D": 5,
}

cube = None


def rotate_neighbors(face):
    if face == 0:
        tmp = [cube[3][0][0], cube[3][0][1], cube[3][0][2]]
        cube[3][0][0], cube[3][0][1], cube[3][0][2] = cube[4][0][0], cube[4][0][1], cube[4][0][2]
        cube[4][0][0], cube[4][0][1], cube[4][0][2] = cube[1][0][0], cube[1][0][1], cube[1][0][2]
        cube[1][0][0], cube[1][0][1], cube[1][0][2] = cube[2][0][0], cube[2][0][1], cube[2][0][2]
        cube[2][0][0], cube[2][0][1], cube[2][0][2] = tmp
    elif face == 1:
        tmp = [cube[0][2][2], cube[0][2][1], cube[0][2][0]]
        cube[0][2][2], cube[0][2][1], cube[0][2][0] = cube[4][0][2], cube[4][1][2], cube[4][2][2]
        cube[4][0][2], cube[4][1][2], cube[4][2][2] = cube[5][0][0], cube[5][0][1], cube[5][0][2]
        cube[5][0][0], cube[5][0][1], cube[5][0][2] = cube[2][2][0], cube[2][1][0], cube[2][0][0]
        cube[2][2][0], cube[2][1][0], cube[2][0][0] = tmp
    elif face == 2:
        tmp = [cube[0][0][2], cube[0][1][2], cube[0][2][2]]
        cube[0][0][2], cube[0][1][2], cube[0][2][2] = cube[1][0][2], cube[1][1][2], cube[1][2][2]
        cube[1][0][2], cube[1][1][2], cube[1][2][2] = cube[5][0][2], cube[5][1][2], cube[5][2][2]
        cube[5][0][2], cube[5][1][2], cube[5][2][2] = cube[3][2][0], cube[3][1][0], cube[3][0][0]
        cube[3][2][0], cube[3][1][0], cube[3][0][0] = tmp
    elif face == 3:
        tmp = [cube[0][0][0], cube[0][0][1], cube[0][0][2]]
        cube[0][0][0], cube[0][0][1], cube[0][0][2] = cube[2][0][2], cube[2][1][2], cube[2][2][2]
        cube[2][0][2], cube[2][1][2], cube[2][2][2] = cube[5][2][2], cube[5][2][1], cube[5][2][0]
        cube[5][2][2], cube[5][2][1], cube[5][2][0] = cube[4][2][0], cube[4][1][0], cube[4][0][0]
        cube[4][2][0], cube[4][1][0], cube[4][0][0] = tmp
    elif face == 4:
        tmp = [cube[0][2][0], cube[0][1][0], cube[0][0][0]]
        cube[0][2][0], cube[0][1][0], cube[0][0][0] = cube[3][0][2], cube[3][1][2], cube[3][2][2]
        cube[3][0][2], cube[3][1][2], cube[3][2][2] = cube[5][2][0], cube[5][1][0], cube[5][0][0]
        cube[5][2][0], cube[5][1][0], cube[5][0][0] = cube[1][2][0], cube[1][1][0], cube[1][0][0]
        cube[1][2][0], cube[1][1][0], cube[1][0][0] = tmp
    else:
        tmp = [cube[1][2][2], cube[1][2][1], cube[1][2][0]]
        cube[1][2][2], cube[1][2][1], cube[1][2][0] = cube[4][2][2], cube[4][2][1], cube[4][2][0]
        cube[4][2][2], cube[4][2][1], cube[4][2][0] = cube[3][2][2], cube[3][2][1], cube[3][2][0]
        cube[3][2][2], cube[3][2][1], cube[3][2][0] = cube[2][2][2], cube[2][2][1], cube[2][2][0]
        cube[2][2][2], cube[2][2][1], cube[2][2][0] = tmp


def rotate_face(face):
    cube[face] = [list(arr)[::-1] for arr in zip(*cube[face])]


def rotate(face, d):
    if d == "+":
        cnt = 1
    else:
        cnt = 3

    for _ in range(cnt):
        rotate_face(face)
        rotate_neighbors(face)


tc = int(input())
answer = ""
for _ in range(tc):
    cube = [
        [["w"] * 3 for _ in range(3)],
        [["r"] * 3 for _ in range(3)],
        [["b"] * 3 for _ in range(3)],
        [["o"] * 3 for _ in range(3)],
        [["g"] * 3 for _ in range(3)],
        [["y"] * 3 for _ in range(3)],
    ]

    n = int(input())
    turns = input().split()
    for turn in turns:
        rotate(faces[turn[0]], turn[1])
    for i in range(3):
        answer += "".join(cube[0][i]) + "\n"


print(answer)
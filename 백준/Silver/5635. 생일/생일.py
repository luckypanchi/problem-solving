import sys

input = sys.stdin.readline


n = int(input())
students = []
for _ in range(n):
    a, b, c, d = input().split()
    students.append([a, int(b), int(c), int(d)])
students.sort(key=lambda x: (x[3], x[2], x[1]))

print(students[-1][0])
print(students[0][0])

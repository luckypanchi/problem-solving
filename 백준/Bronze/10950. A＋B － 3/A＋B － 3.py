import sys
input = sys.stdin.readline

def main():
    n = int(input())
    answer = []

    for _ in range(n):
        a, b = map(int, input().split())
        answer.append(a+b)

    for i in answer:
        print(i)

main()
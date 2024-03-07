import sys

input = sys.stdin.readline


def solve(tall, short):
    currTall, currShort = 0, 0
    count = 0
    while currTall < len(tall) and currShort < len(short):
        if tall[currTall] > short[currShort]:
            count += 1
            currTall += 1
            currShort += 1
        else:
            currTall += 1

    return count


n = int(input())
man1 = []  # 나보다 작은 여자를 원함
man2 = []  # 나보다 큰 여자를 원함
woman1 = []  # 나보다 큰 남자를 원함
woman2 = []  # 나보다 작은 남자를 원함

man = list(map(int, input().split()))
woman = list(map(int, input().split()))

for m in man:
    if m > 0:
        man2.append(m)
    else:
        man1.append(-m)

for w in woman:
    if w > 0:
        woman1.append(w)
    else:
        woman2.append(-w)

man1.sort()
man2.sort()
woman1.sort()
woman2.sort()

answer = 0
answer += solve(man1, woman1)
answer += solve(woman2, man2)

print(answer)
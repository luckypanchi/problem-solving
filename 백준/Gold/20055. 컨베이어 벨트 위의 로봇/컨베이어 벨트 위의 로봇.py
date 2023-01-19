import sys

input = sys.stdin.readline


def main():
    n, k = map(int, input().split())
    belt = [False] * (2 * n)
    durabilities = list(map(int, input().split()))

    def check(durabilities, k):
        cnt = durabilities.count(0)
        if cnt < k:
            return True
        else:
            return False

    cnt = 0
    head = 0
    robots = []

    while check(durabilities, k):
        cnt += 1
        head = (head - 1) % (2 * n)
        dest = (head + n - 1) % (2 * n)

        tmp = []
        for r in robots:
            if r != dest:
                nr = (r + 1) % (2 * n)
                if durabilities[nr] != 0 and belt[nr] is False:
                    belt[r] = False
                    durabilities[nr] -= 1
                    belt[nr] = True
                    if nr != dest:
                        tmp.append(nr)
                    else:
                        belt[nr] = False
                else:
                    tmp.append(r)
            else:
                belt[r] = False

        robots = tmp

        if durabilities[head] != 0:
            durabilities[head] -= 1
            belt[head] = True
            robots.append(head)

    print(cnt)


main()

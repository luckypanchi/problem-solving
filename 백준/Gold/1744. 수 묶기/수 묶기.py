import sys

def main():
    n = int(sys.stdin.readline())

    pli = []
    nli = []
    answer = 0

    for _ in range(n):
        tmp = int(sys.stdin.readline())
        if tmp > 1: pli.append(tmp)
        elif tmp == 1: answer += 1
        else: nli.append(tmp)

    pli.sort(reverse=True)
    nli.sort()
    
    if len(pli)%2:
        for i in range(0, len(pli)-2, 2):
            answer += pli[i]*pli[i+1]
        answer += pli[-1]
    else:
        for i in range(0, len(pli)-1, 2):
            answer += pli[i]*pli[i+1]

    if len(nli)%2:
        for i in range(0, len(nli)-2, 2):
            answer += nli[i]*nli[i+1]
        answer += nli[-1]
    else:
        for i in range(0, len(nli)-1, 2):
            answer += nli[i]*nli[i+1]
    
    print(answer)


if __name__ == "__main__":
    main()
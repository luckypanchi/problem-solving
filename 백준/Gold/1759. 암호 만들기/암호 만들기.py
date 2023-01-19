import sys
input = sys.stdin.readline

def main():
    l, c = map(int, input().split())
    matrix = list(input().split())

    matrix.sort()

    tmp = []
    answer = []
    check = [0]*c

    def makeChoice(cnt, idx):
        nonlocal tmp

        if cnt == l: 
            vowels, consonants = 0, 0
            for letter in tmp:
                if letter in ['a', 'e', 'i', 'o', 'u']: vowels += 1
                else: consonants += 1
            if vowels >= 1 and consonants >= 2: 
                answer.append(''.join(tmp))
            return

        for i in range(idx, c-(l-cnt)+1):
            if check[i] == 0:
                check[i] = 1
                tmp.append(matrix[i])
                makeChoice(cnt+1, i+1)
                del tmp[-1]
                check[i] = 0
    
    makeChoice(0, 0)

    for letter in answer:
        print(letter, end="\n")

if __name__ == "__main__":
    main()
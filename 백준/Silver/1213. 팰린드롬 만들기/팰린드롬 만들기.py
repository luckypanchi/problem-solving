import sys

input = sys.stdin.readline


name = input().strip()
alphabets = [0] * 26
for n in name:
    alphabets[ord(n) - ord("A")] += 1

odd_cnt = 0
odd_alpha = ""
string = ""

for i in range(26):
    if alphabets[i] % 2 == 1:
        odd_cnt += 1
        odd_alpha = chr(i + ord("A"))
    string += chr(i + ord("A")) * (alphabets[i] // 2)

if odd_cnt > 1:
    print("I'm Sorry Hansoo")
else:
    print(string + odd_alpha + string[::-1])

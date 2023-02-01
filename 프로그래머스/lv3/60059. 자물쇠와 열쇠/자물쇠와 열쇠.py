def rotate(key):
    m = len(key)
    new_key = [[0] * m for _ in range(m)]
    for i in range(m):
        for j in range(m):
            new_key[j][m - 1 - i] = key[i][j]
    return new_key
    

def check(key, board, i, j):
    m, r = len(key), len(board)
    n = r - 2 * m
    
    for y in range(m):
        for x in range(m):
            board[i + y][j + x] += key[y][x]
    
    result = True
    for y in range(m, m + n):
        for x in range(m, m + n):
            if board[y][x] != 1:
                result = False
                break
        if not result:
            break
            
    for y in range(m):
        for x in range(m):
            board[i + y][j + x] -= key[y][x]
            
    return result


def solution(key, lock):
    m, n = len(key), len(lock)
    r = 2 * m + n
    board = [[0] * r for _ in range(r)]
    for i in range(n):
        for j in range(n):
            board[m + i][m + j] = lock[i][j]
    
    for _ in range(4):
        for i in range(n + m):
            for j in range(n + m):
                if check(key, board, i, j):
                    return True
        key = rotate(key)
    
    return False
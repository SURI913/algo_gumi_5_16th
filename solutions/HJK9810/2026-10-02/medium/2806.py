def isPrime(boards, row):
    for idx in range(row): # 이전 열 까지의 비교
        if boards[row] == boards[idx] or abs(boards[row] - boards[idx]) == row - idx:
            return False
    return True

def traking(boards, row):
    if row == len(boards): return 1

    count = 0
    for idx in range(len(boards)):
        boards[row] = idx
        if isPrime(boards, row):
            count += traking(boards, row + 1)
            boards[row] = 0

    return count

def algorithm():
    N = int(input())
    boards = [0] * N

    return traking(boards, 0)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")

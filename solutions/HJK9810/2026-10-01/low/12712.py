CROSS = ((-1, -1), (1, 1), (-1, 1), (1, -1))
DIR = ((1, 0), (-1, 0), (0, 1), (0, -1))

def calc_kiler(boards, row, col, N, M, BASE):
    total = 0

    for count in range(1, M):
        for (dr, dc) in BASE:
            nr, nc = dr * count + row, dc * count + col
            if 0 <= nr < N and 0 <= nc < N:
                total += boards[nr][nc]

    return total + boards[row][col]

def algorithm():
    N, M = map(int, input().split())
    boards = [list(map(int, input().split())) for _ in range(N)]

    max_total = 0
    for row in range(N):
        for col in range(N):
            plus = calc_kiler(boards, row, col, N, M, DIR)
            cross = calc_kiler(boards, row, col, N, M, CROSS)
            max_total = max((plus, cross, max_total))

    return max_total

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")

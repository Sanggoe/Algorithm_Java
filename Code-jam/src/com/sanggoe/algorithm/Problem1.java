package com.sanggoe.algorithm;

/*Problem
Someone just won the Code Jam lottery, and we owe them N jamcoins!
However, when we tried to print out an oversized check, we encountered a problem.
The value of N, which is an integer, includes at least one digit that is a 4...
and the 4 key on the keyboard of our oversized check printer is broken.

Fortunately, we have a workaround:
we will send our winner two checks for positive integer amounts A and B,
such that neither A nor B contains any digit that is a 4, and A + B = N.
Please help us find any pair of values A and B that satisfy these conditions.
// 양의 정수 A와 B의 경우 A와 B가 4인 숫자를 포함하지 않으며 A + B = N입니다.

Input
The first line of the input gives the number of test cases, T.
T test cases follow; each consists of one line with an integer N.
// T. 첫 줄 입력은 테스트 사례 수를 나타냅니다. 테스트 사례는 각각 정수 N 한 줄로 구성됩니다.

Output
For each test case, output one line containing Case #x: A B, where x is the test case number
(starting from 1), and A and B are positive integers as described above.
// 각 테스트 사례에 대해, 한 줄에 Case #x: A B 를 출력합니다.
x는 1부터 시작하며, 몇 번째 테스트 사례인지 입니다. A와 B는 모두 위에서 설명한 양의 정수 입니다.

It is guaranteed that at least one solution exists.
If there are multiple solutions, you may output any one of them.
(See "What if a test case has multiple correct solutions?" in the Competing section of the FAQ.
This information about multiple solutions will not be explicitly stated in the remainder of the 2019 contest.)

Limits
1 ≤ T ≤ 100.
Time limit: 10 seconds per test set.
Memory limit: 1GB.
At least one of the digits of N is a 4.

Test set 1 (Visible)
1 < N < 10^5.

Test set 2 (Visible)
1 < N < 10^9.

Solving the first two test sets for this problem should get you a long way toward advancing.
The third test set is worth only 1 extra point, for extra fun and bragging rights!:i

Test set 3 (Hidden)
1 < N < 10^100.

<Sample>
Input   Output
3
4        Case #1: 2 2
940     Case #2: 852 88
4444    Case #3: 667 3777
*/

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
//        boolean run = true;
        int T, N, A, B;
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        if (T >= 1 && T <= 100) {

            for (int i = 0; i < T; i++) {
                N = sc.nextInt();

                if (1 < N && N < 100000 && isExistFour(N)) {
                    for (A = 1; A <= 100000; A++) {
                        B=N-A;
                        if (!isExistFour(A) && !isExistFour(B)) {
                            showCase(A, B, i);
                            break;
                        }
                    }
                } else {
                    System.out.println("4 없음, 다시");
                }
            }
        }
    }

    // N에 4 자리수가 들어가는지 검사하는 함수
    static boolean isExistFour(int n) {
        while (n > 0) {
            if (n % 10 == 4) {
                System.out.println("4 있음");
                return true;
            }
            n /= 10;
        }
        return false;
    }

    // 각 Case를 출력하는 메소드
    static void showCase(int A, int B, int i) {
        System.out.println("case #" + i + ": " + A + " " + B);
    }
}

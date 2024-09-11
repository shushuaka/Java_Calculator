package 필수_계산기_Lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { //무한 반복을 담당하는 구조
            // 1-1. 정수 입력받기
            /*Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
            정수는 각각 하나씩 전달 받습니다.
            정수는 int 타입으로 선언한 변수에 저장합니다.*/
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 1-2. 사칙연산 기호 입력받기
            /*Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)*/
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            // 1-3. 입력받은 값과 연산자를 사용하여 연산 진행
            int result = 0; // 결과를 저장할 변수 선언 및 0으로 초기화
            switch (operator) { //연산자를 처리하는 조건문
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모에 0을 입력할 수 없습니다.");
                        continue; // 오류 발생 시 다시 입력 받기
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다.");
                    continue; // 잘못된 입력일 경우 다시 시작
            }

            // 결과 출력
            System.out.println("결과: " + result);

            // 1-4. 반복문을 사용하여 계산을 계속 진행할지 묻기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitInput = sc.next();
            if (exitInput.equalsIgnoreCase("exit")) {
                break; // exit 입력 시 종료
            } //그 외 입력 시 while 반복문이 계속 진행
        }

        sc.close();
    }
}

package 필수_계산기_Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //2-2. Calculator 클래스 인스턴스 생성
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        // 변수 선언을 반복문 밖에서 수행
        int num1 = 0, num2 = 0;  // 두 정수를 저장할 변수 선언
        boolean validInput;  // 변수를 선언만 함, 초기화는 생략

        while (true) {  // 무한 반복을 담당하는 구조

        // 첫 번째 숫자 입력 (예외 처리 추가)
            validInput = false;  // 첫 번째 숫자 입력을 위한 초기화
            while (!validInput) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                sc.next(); // 잘못된 입력을 건너뛰고 다시 입력받기
            }
        }

        validInput = false;  // 두 번째 입력을 위해 validInput을 다시 false로 설정

            // 두 번째 숫자 입력 (예외 처리 추가)
            while (!validInput) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                sc.next(); // 잘못된 입력을 건너뛰고 다시 입력받기
                }
            }

            // 1-2. 사칙연산 기호 입력받기
            /*Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)*/

            char operator = ' ';
            boolean validOperator = false;  // 올바른 연산 기호가 입력될 때까지 반복

            while (!validOperator) {
                System.out.print("사칙연산 기호를 입력하세요. (+, -, *, /): ");
                operator = sc.next().charAt(0);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    validOperator = true;  // 올바른 연산 기호가 입력되면 루프 종료
                } else {
                    System.out.println("잘못된 연산 기호입니다. 다시 입력해주세요.");
                }
            }

            // 2-2. App 클래스의 main 메서드에 Calculator 클래스 활용하기
            try { // Calculator 클래스의 calculate 메서드를 사용하여 연산 수행
                int result = calculator.calculate(num1, num2, operator); //Calculator 클래스의 calculate 메서드를 호출
                System.out.println("결과: " + result);
            } catch (Exception e) { // 예외 발생 시 메시지 출력
                System.out.println(e.getMessage());
            }

            // 2-4. 저장된 결과 삭제 여부 확인
            System.out.print("가장 먼저 저장된 결과를 삭제하시겠습니까? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                calculator.removeFirstResult();
            }

            // 1-4. 반복문을 사용하여 계산을 계속 진행할지 묻기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitInput = sc.next();
            if (exitInput.equalsIgnoreCase("exit")) { //exit 입력 시 종료
                break; //그 외 입력 시 while 반복문이 계속 진행
            }
        }

        sc.close();
    }
}

package 도전_계산기;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>(); // 제네릭으로 Double 타입 사용
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 양의 실수 두 개 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();

            // 사칙연산 기호 입력받기
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operatorSymbol = sc.next().charAt(0);

            try {
                OperatorType operator = OperatorType.fromSymbol(operatorSymbol);
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 입력한 값보다 큰 결과 필터링
            System.out.print("조회할 기준값을 입력하세요: ");
            double filterValue = sc.nextDouble();
            System.out.println("입력값보다 큰 결과: " + calculator.filterResultsGreaterThan(filterValue));

            // 더 계산할지 물어보기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitInput = sc.next();
            if (exitInput.equalsIgnoreCase("exit")) {
                break;
            }
        }

        sc.close();
    }
}


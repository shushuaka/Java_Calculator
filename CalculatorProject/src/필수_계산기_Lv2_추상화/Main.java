package 필수_계산기_Lv2_추상화;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("연산자를 입력하세요.(+, -, *, /):");
        String operator = scanner.nextLine();

        System.out.println("첫 번째 숫자를 입력하세요:");
        int firstNumber = scanner.nextInt();
        scanner.nextLine();  // 줄 바꿈 문자를 처리

        System.out.println("두 번째 숫자를 입력하세요:");
        int secondNumber = scanner.nextInt();
        scanner.nextLine();  // 줄 바꿈 문자를 처리

        // 연산자와 연산 클래스를 매핑하는 Map
        Map<String, AbstractOperation> operationMap = new HashMap<>();
        operationMap.put("+", new AddOperation());
        operationMap.put("-", new SubtractOperation());
        operationMap.put("*", new MultiplyOperation());
        operationMap.put("/", new DivideOperation());

        // Map에서 사용자가 입력한 연산자에 해당하는 연산 클래스 가져오기
        AbstractOperation operation = operationMap.get(operator);

        if (operation != null) {
            calculator.setOperation(operation);  // 연산 클래스 설정
            System.out.println("결과: " + calculator.calculate(firstNumber, secondNumber));
        } else {
            System.out.println("잘못된 연산자입니다. 연산자는 +, -, *, / 중 하나여야 합니다.");
        }
    }
}
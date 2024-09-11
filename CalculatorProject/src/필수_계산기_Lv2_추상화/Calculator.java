package 필수_계산기_Lv2_추상화;

public class Calculator {
    // AbstractOperation 타입의 필드를 가짐
    private AbstractOperation operation;

    // 연산 클래스를 설정하는 메서드 (Setter 메서드)
    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    // 실제 연산을 수행하는 메서드
    public double calculate(int firstNumber, int secondNumber) {
        if (operation == null) {
            System.out.println("연산이 설정되지 않았습니다. 결과는 0입니다.");
            return 0;
        }
        return operation.operate(firstNumber, secondNumber);
    }
}

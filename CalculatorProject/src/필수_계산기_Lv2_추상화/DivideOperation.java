package 필수_계산기_Lv2_추상화;

public class DivideOperation extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        }
    }
}
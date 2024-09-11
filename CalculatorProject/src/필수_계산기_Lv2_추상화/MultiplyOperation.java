package 필수_계산기_Lv2_추상화;

public class MultiplyOperation extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}

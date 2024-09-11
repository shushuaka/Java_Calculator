package 필수_계산기_Lv2_추상화;

public class SubtractOperation extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}

package 도전_계산기;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    // 연산 결과를 저장하는 컬렉션
    private List<T> results;

    public ArithmeticCalculator() {
        this.results = new ArrayList<>();
    }

    // 제네릭을 활용한 사칙연산 메서드
    public T calculate(T num1, T num2, OperatorType operator) {
        double result;
        switch (operator) {
            case ADD:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case SUBTRACT:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("나눗셈에서 분모는 0이 될 수 없습니다.");
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }

        @SuppressWarnings("unchecked")
        T typedResult = (T) Double.valueOf(result); // 결과를 T 타입으로 변환
        results.add(typedResult); // 결과 저장
        return typedResult;
    }

    // 입력받은 값보다 큰 결과 필터링 및 출력
    public List<T> filterResultsGreaterThan(double value) {
        return results.stream()
                .filter(result -> result.doubleValue() > value)
                .collect(Collectors.toList());
    }

    // 결과 리스트 반환
    public List<T> getResults() {
        return new ArrayList<>(results); // 방어적 복사
    }
}


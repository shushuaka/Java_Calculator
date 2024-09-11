package 필수_계산기_Lv2;
//2-1. Calculator 클래스 생성 및 메서드 구현
        /*사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
        연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
        1) 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+, -, *, /) 기능을 수행한 후
        2) 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.*/
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /*인터페이스(List)와 구현체(ArrayList)를 분리
     List를 선언하고, ArrayList로 초기화*/
    // 2-3. 연산 결과 컬렉션에 직접 접근하지 못하도록 캡슐화 적용
    private List<Integer> results; // 연산 결과를 저장하는 컬렉션 List // private로 선언하여 외부 접근 차단(캡슐화)

    public Calculator() {
        this.results = new ArrayList<>();
    }

    // 사칙연산을 수행하고 결과를 반환하는 메서드
    public int calculate(int num1, int num2, char operator) {
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
                    throw new ArithmeticException("나눗셈에서 분모는 0이 될 수 없습니다.");
                } //산술 오류가 발생했을 때(0으로 나눌 시) 직접 ArithmeticException 예외를 발생
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산 기호입니다."); // 사칙연산 기호가 +, -, *, / 중 하나가 아닌 경우, IllegalArgumentException 예외를 발생
        }
        // 연산 결과 저장
        results.add(result);
        return result;
    }
    //2-3. 캡슐화 (Getter, Setter)
    // 연산 결과 results를 외부에서 읽을 수 있는 (Getter)
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 외부에서 수정하지 못하도록 새로운 리스트(복사본) 반환
    }

    // 외부에서 리스트를 수정할 수 있는 (Setter) 필요 없다고 판단!>> 삭제
    /*public void setResults(List<Integer> results) {
        this.results = new ArrayList<>(results); // 새로운 리스트로 설정
    }*/

    // 2-4. 가장 먼저 저장된 결과 삭제
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
        } else {
            System.out.println("저장된 결과가 없습니다.");
        }
    }
}


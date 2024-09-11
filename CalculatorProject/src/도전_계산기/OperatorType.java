package 도전_계산기;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    // Enum 생성자
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    // 각 연산자의 기호를 반환하는 메서드
    public char getSymbol() {
        return symbol;
    }

    // 기호에 맞는 연산자 타입을 반환하는 메서드
    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType type : values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다.");
    }
}


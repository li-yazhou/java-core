package javabase.jdk8.lambda;

/**
 * 枚举实现接口，为接口创建几个常用的实例
 *
 * @author liyazhou1
 * @date 2018/7/28
 */
public enum MathOperationEnum implements MathOperation {
    ADDITION() {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACTION() {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICATION() {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    },
    DIVISION() {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    }

}

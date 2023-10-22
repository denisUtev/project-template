package edu.hw2;

public final class Task1 {

    private Task1() {

    }

    public sealed interface Expr {
        double evaluate();

        public record Constant(double num) implements Expr {
            @Override
            public double evaluate() {
                return num;
            }
        }

        public record Negate(Expr expr) implements Expr {
            @Override
            public double evaluate() {
                return -expr.evaluate();
            }
        }

        public record Exponent(Expr expr1, int num) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(expr1.evaluate(), num);
            }
        }

        public record Addition(Expr expr1, Expr epxr2) implements Expr {
            @Override
            public double evaluate() {
                return expr1.evaluate() + epxr2.evaluate();
            }
        }

        public record Multiplication(Expr expr1, Expr epxr2) implements Expr {
            @Override
            public double evaluate() {
                return expr1.evaluate() * epxr2.evaluate();
            }
        }
    }

}

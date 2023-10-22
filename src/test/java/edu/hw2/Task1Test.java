package edu.hw2;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Тест первого задания hw2")
    void task1Test() {

        var two = new Task1.Expr.Constant(2);
        var four = new Task1.Expr.Constant(4);
        var negOne = new Task1.Expr.Negate(new Task1.Expr.Constant(1));
        assertThat(negOne.evaluate()).isEqualTo(-1);

        var sumTwoFour = new Task1.Expr.Addition(two, four);
        assertThat(sumTwoFour.evaluate()).isEqualTo(6);

        var mult = new Task1.Expr.Multiplication(sumTwoFour, negOne);
        assertThat(mult.evaluate()).isEqualTo(-6);

        var exp = new Task1.Expr.Exponent(mult, 2);
        assertThat(exp.evaluate()).isEqualTo(36);

        var res = new Task1.Expr.Addition(exp, new Task1.Expr.Constant(1));
        assertThat(res.evaluate()).isEqualTo(37);
    }
}

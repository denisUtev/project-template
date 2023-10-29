package edu.hw2;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw2.Task1.Expr.*;

public class Task1Test {

    @Test
    @DisplayName("Тест первого задания hw2")
    void task1Test() {

        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        assertThat(negOne.evaluate()).isEqualTo(-1);

        var sumTwoFour = new Addition(two, four);
        assertThat(sumTwoFour.evaluate()).isEqualTo(6);

        var mult = new Multiplication(sumTwoFour, negOne);
        assertThat(mult.evaluate()).isEqualTo(-6);

        var exp = new Exponent(mult, 2);
        assertThat(exp.evaluate()).isEqualTo(36);

        var res = new Addition(exp, new Constant(1));
        assertThat(res.evaluate()).isEqualTo(37);
    }
}

package paleo.lib.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import paleo.lib.parser.Parser;
import paleo.lib.token.DoubleOperandToken;
import paleo.lib.token.IntegerOperandToken;

/**
 * Unit test for {@link Interpreter}.
 */
public class InterpreterTest {

    @Test
    public void withOnlyOneIntegerOperand() {
        assertEquals(
            new IntegerOperandToken(3),
            new Interpreter(new Parser("3").parse()).evaluate()
        );
    }

    @Test
    public void simpleIntegerSum() {
        assertEquals(
            new IntegerOperandToken(8),
            new Interpreter(new Parser("3 + 5").parse()).evaluate()
        );
    }

    @Test
    public void simpleIntegerSub() {
        assertEquals(
            new IntegerOperandToken(-2),
            new Interpreter(new Parser("3 - 5").parse()).evaluate()
        );
    }

    @Test
    public void simpleIntegerDiv() {
        assertEquals(
            new IntegerOperandToken(0),
            new Interpreter(new Parser("3 / 5").parse()).evaluate()
        );
    }

    @Test
    public void simpleIntegerMult() {
        assertEquals(
            new IntegerOperandToken(15),
            new Interpreter(new Parser("3 * 5").parse()).evaluate()
        );
    }

    @Test
    public void simpleParenIntegerExpression() {
        assertEquals(
            new IntegerOperandToken(16),
            new Interpreter(new Parser("2 * (3 + 5)").parse()).evaluate()
        );
    }

    @Test
    public void multipleParenIntegerExpression() {
        assertEquals(
            new IntegerOperandToken(35),
            new Interpreter(new Parser("7 * ((8 + 3) / 2)").parse()).evaluate()
        );
    }

    @Test
    public void testOperationPriority() {
        assertEquals(
            new IntegerOperandToken(-24),
            new Interpreter(new Parser("2 + 4 - 6 * 5").parse()).evaluate()
        );
    }

    @Test
    public void multipleParenIntegerExpressionWithOperationPriority() {
        assertEquals(
            new IntegerOperandToken(-33),
            new Interpreter(new Parser("(2 - 3 * 4 + (2 + 4 - 6 * 5)) + 1").parse())
                                                                           .evaluate()
        );
    }

    @Test
    public void simpleDoubleSum() {
        assertEquals(
            new DoubleOperandToken(8.8),
            new Interpreter(new Parser("3.4 + 5.4").parse()).evaluate()
        );
    }

    @Test
    public void simpleParenDoubleExpression() {
        assertEquals(
            new DoubleOperandToken(17.6),
            new Interpreter(new Parser("2.0 * (3.4 + 5.4)").parse()).evaluate()
        );
    }

    @Test
    public void integerTimesDouble() {
        assertEquals(
            new DoubleOperandToken(9.0),
            new Interpreter(new Parser("2 * 4.5").parse()).evaluate()
        );
    }

    @Test
    public void multipleParenIntegerDoubleExpression() {
        assertEquals(
            new DoubleOperandToken(5.0),
            new Interpreter(new Parser("(2 - 4.5) * (4 - 6)").parse()).evaluate()
        );
    }

    @Test
    public void divideByZeroShouldThrowAnException() {
        try {
            new Interpreter(new Parser("3 / 0").parse()).evaluate();
            assertTrue(false);
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}

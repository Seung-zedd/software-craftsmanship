package ch2_tdd.stack;

import ch2_tdd.Stack;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private final Stack stack = new Stack();

    @Test
    void nothing() {
    }

    @Test
    void canCreateStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterOnePush_isNotEmpty() {
        stack.push(0);
        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void afterOnePUshAndOnePop_isEmpty() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterTwoPushes_sizeIsTwo() {
        stack.push(0);
        stack.push(0);
        assertThat(stack.getSize()).isEqualTo(2);
    }

    @Test
    void afterOnePushAndOnePop_isEmpty() {
        stack.push(0);
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void poppingEmptyStack_throwsUnderflow() {
        assertThrows(Stack.Underflow.class, stack::pop);
    }

    @Test
    void afterPushingX_willPopX() {
        stack.push(99);
        assertThat(stack.pop()).isEqualTo(99);
        stack.push(88);
        assertThat(stack.pop()).isEqualTo(88);
    }
}

package ru.otus.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void push() {
        assertEquals(10, stack.push(10));
        assertFalse(stack.empty());
    }

    @Test
    void pop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    @DisplayName("Method pop should throw exception on empty stack")
    void pop_exception() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void empty() {
        assertTrue(stack.empty());
        stack.push(10);
        assertFalse(stack.empty());
    }
}

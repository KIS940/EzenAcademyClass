package org.example.springBootDeveloper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {
    @BeforeEach
    public void beforeEach(){
        System.out.println("Hello!");
    }
    @AfterAll
    public static void afterEach(){
        System.out.println("Goodbye!");
    }
    @Test
    public void test(){
        System.out.println("This is first test");
    }
    @Test
    public void test2(){
        System.out.println("This is second test");
    }
}

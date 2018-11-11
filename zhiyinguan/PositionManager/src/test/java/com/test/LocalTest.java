package com.test;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/6/14
 */
public class LocalTest {

    @Test
    public void demo(){
        System.err.println(LocalDate.now());
        System.err.println(LocalTime.now());
        System.err.println(LocalDateTime.now());
    }
}

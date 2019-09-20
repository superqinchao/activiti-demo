package com.example.lambda;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @ClassName ForkJoinTaskTest
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/26 14:32
 */
public class ForkJoinTaskTest {
    public static void main(String[] args) {
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L,1000000000L)
                .parallel()
                .reduce(0L,Long::sum);
        Instant end = Instant.now();
        System.out.println(sum);
        System.out.println("耗时："+ Duration.between(start,end).toMillis());//1683-1740
    }
}

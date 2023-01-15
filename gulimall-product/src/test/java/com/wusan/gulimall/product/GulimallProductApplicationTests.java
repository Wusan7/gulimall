package com.wusan.gulimall.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SpringBootTest
class GulimallProductApplicationTests {

    @Test
    void contextLoads() {

        testConsumer(500.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });

    }

    @Test
    void test1(){
        testConsumer(600.0, money-> System.out.println("买水花了${}块钱"+ money));
    }


    public void testConsumer(Double d, Consumer<Double> doubleConsumer){
        doubleConsumer.accept(d);
    }

    public void filString(List<String> list, Predicate<String> predicate){

    }

}

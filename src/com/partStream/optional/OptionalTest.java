package com.partStream.optional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

/**
 * Author: Sean
 * Date: Created In 10:30 2019/4/2
 * Title: 测试optinal
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class OptionalTest {
    public static void main(String[] args){
        Optional<String> stringOptional = Optional.empty();
        String result = stringOptional.orElse("N/A");
        System.out.println("result: " + result);
        result = stringOptional.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);
        try{
            result = stringOptional.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result );
        }
        catch (IllegalStateException e){
            System.out.println("caught exception");
        }

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2 = Optional.of(4.0)
                .flatMap(OptionalTest::inverse)
                .flatMap(OptionalTest::squareRoot);
        System.out.println(result2);
    }

    public static Optional<Double> inverse(Double x){
        return x== 0?Optional.empty():Optional.of(1/x);
    }
    public static Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty():Optional.of(Math.sqrt(x));
    }
}

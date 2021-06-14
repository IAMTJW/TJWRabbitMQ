package com.tianjunwei.lambda;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListLearn {


    public static void main(String[] args) {

        List<String> dataList = Arrays.asList("1", "2", "3", "410", "5", "", "6", "7", "8", "9", "10");

        dataList.stream().forEach( a -> {
            System.out.println(a);
        });

        List<String> b = dataList.stream().filter( a -> {return a.length() > 0;}).sorted((a, c) -> {
            return a.length() - c.length();
        }).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(b));

        Map<Integer, String> c = dataList.stream().filter( a -> {return a.length() > 0;}).collect(Collectors.toMap( a->Integer.parseInt(a) ,a -> a));

        System.out.println(JSON.toJSONString(c));
    }

}

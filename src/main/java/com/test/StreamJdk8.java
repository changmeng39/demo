package com.test;

import com.entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamJdk8 {

    public static void main(String[] args) {
        streamTest();
    }

    public static void streamTest(){
        User user1 = new User(1l,"a");
        User user2 = new User(2l,"b");
        User user3 = new User(3l,"c");
        User user4 = new User(4l,"d");
        User user5 = new User(5l,"e");
        User user6 = new User(6l,"f");
        User user7 = new User(7l,"g");

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.stream()
                .filter(user -> user.getName().equals("e") || user.getName().equals("a"))
                .forEach(user -> System.out.println(user.getId() +"------------" + user.getName()));
        // 处理单个bean
        // Optional<User> user1 = Optional.ofNullable(user).filter(u -> u.getName().length()<6);
        // 静态工厂方法
        // of
        // of方法，其生成的Stream是有限长度的，Stream的长度为其内的元素个数。
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<String> stringStream = Stream.of("A");
        integerStream.filter(i -> i>=2).forEach(i -> System.out.println(i));
        // generator方法，返回一个无限长度的Stream,其元素由Supplier接口的提供。
        // 在Supplier是一个函数接口，只封装了一个get()方法，其用来返回任何泛型的值，
        // 该结果在不同的时间内，返回的可能相同也可能不相同，没有特殊的要求。
        // 这种情形通常用于随机数、常量的 Stream，或者需要前后元素间维持着某种状态信息的 Stream。
        // 把 Supplier 实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）但无序的（相对 ordered 而言）。

        Stream<Double> generateA = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return java.lang.Math.random();
            }
        });

        Stream<Double> generateB = Stream.generate(()-> java.lang.Math.random());
        Stream<Double> generateC = Stream.generate(java.lang.Math::random);

        // iterate
        // iterate方法，其返回的也是一个无限长度的Stream，
        // 与generate方法不同的是，其是通过函数f迭代对给指定的元素种子而产生无限连续有序Stream，
        // 其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环。
        Stream.iterate(1, item -> item + 1)
                .limit(10)
                .forEach(System.out::println);
        // 打印结果：1，2，3，4，5，6，7，8，9，10
        Stream.iterate(1, item -> item + 1)
                .limit(list.size())
                .forEach(System.out::println);
        list.stream().forEach(user -> System.out.println(user));
        //处理数组
        int ids[] = new int[]{1, 2, 3, 4};
        Arrays.stream(ids).filter(i -> i > 2)
                .forEach(System.out::println);
        // concat
        // concat方法将两个Stream连接在一起，合成一个Stream。若两个输入的Stream都时排序的，
        // 则新Stream也是排序的；若输入的Stream中任何一个是并行的，则新的Stream也是并行的；若关闭新的Stream时，
        // 原两个输入的Stream都将执行关闭处理。
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5))
                .forEach(integer -> System.out.print(integer + "  "));
        // 打印结果
        // 1  2  3  4  5
        //distinct
        //distinct方法以达到去除掉原Stream中重复的元素，生成的新Stream中没有没有重复的元素。
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.add(3);

        Stream<Integer> distinct = intList.stream().distinct();
        System.out.println("去掉重复");
        distinct.forEach(System.out::println);

        Stream.of(1,2,3,1,2,3)
                .distinct()
                .forEach(u->intList.add(u)); // 打印结果：1，2，3
        for(Integer i : intList){
            System.out.println("循环" + i);
        }

        distinct.filter(u->u>2);
    }
}

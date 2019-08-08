package com.test;

import com.entity.User;

import java.util.*;

public class Jdk8 {

    public static void main(String[] args) throws Exception {

        //aaa();

        // 创建null对象
        User user = new User();
        Optional<User> optStr = Optional.empty();
        System.out.println(optStr.empty().isPresent());

        // 明确对象不为null用of()
        user.setId(1l);
        user.setName("aaa");
        Optional<User> opt = Optional.of(user);
        System.out.println(opt.isPresent());
        System.out.println(opt.get().getId());

        user = new User();
        Optional<User> opt1 = Optional.ofNullable(user);
        System.out.println("ofNullable```````````````" + opt1.get().getId());

        // orElse(T other)，orElseGet(Supplier<? extends T> other)和orElseThrow(Supplier<? extends X> exceptionSupplier)
        // 这三个函数放一组进行记忆，都是在构造函数传入的value值为null时，进行调用的。
        // orElse和orElseGet的用法如下所示，相当于value值为null时，给予一个默认值:
        // 这两个函数的区别：当user值不为null时，orElse函数依然会执行createUser()方法，而orElseGet函数并不会执行createUser()
        user = Optional.ofNullable(user).orElse(createUser());

        user = Optional.ofNullable(user).orElse(new User(1l,"aaa"));

        user = Optional.ofNullable(user).orElseGet(() ->createUser());

        user = Optional.ofNullable(user).orElseGet(() ->new User(1l,"aaa"));

        // orElseThrow，就是value值为null时,直接抛一个异常出去，用法如下所示
        //user = null;
        Optional.ofNullable(user).orElseThrow(()->new Exception("用户不存在"));

        // map(Function<? super T, ? extends U> mapper)和flatMap(Function<? super T, Optional<U>> mapper)
        // 这两个函数放在一组记忆，这两个函数做的是转换值的操作。
        //这时候取name的写法如下所示
        user = new User(1l,"ccc");
        String name = Optional.ofNullable(user).map(u-> u.getName()).get();
        System.out.println("map获取name" + name);
        // isPresent()和ifPresent(Consumer<? super T> consumer)
        // 这两个函数放在一起记忆，isPresent即判断value值是否为空，而ifPresent就是在value值不为空时，做一些操作。这两个函数的源码如下
        // 不用把
        // if (user != null){
        //   // TODO: do something
        // }
        // 写成
        // User user = Optional.ofNullable(user);
        // if (Optional.isPresent()){
        //  // TODO: do something
        // }
        user = null;
        //user = new User();
        Optional.ofNullable(user)
                .ifPresent(u->{
                    //如果user不为null
                    System.out.println("ifPresent用法" + u.getId() + "_" + u.getName());
                    //dosomething(u);
                });
        // filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，
        // 如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty。
        user = new User();
        //Optional<User> user1 = Optional.ofNullable(user).filter(u -> u.getName().length()<6);

        Optional.ofNullable(user).ifPresent(u -> {
            System.out.println("看new的时候走不走");
        });
    }

    public static String getName(User user) throws Exception{
        return Optional.ofNullable(user)
                .map(u-> u.getName())
                .orElseThrow(()->new Exception("取指错误"));
    }

    public static User createUser(){
        User user = new User();
        user.setName("bbb");
        return user;
    }

//    public static void aaa(){
//        Map<String, Object> redis = new HashMap<>();
//        List<String> task = new ArrayList<String>();
//        redis.put("vin", task);
//        //存入开空调
//        task.add("开空调");
//        redis.put("vin", task);
//        //放入闹钟
//        task = (List<String>) redis.get("vin");
//        //此时预约任务内只有开空调任务
//        //加入闹钟任务
//        task.add("闹钟任务");
//        redis.put("vin", task);
//
//        task = (List<String>) redis.get("vin");
//
//        task.forEach(System.err::println);
//
//    }

}

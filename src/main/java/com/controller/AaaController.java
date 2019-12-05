package com.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@RestController
public class AaaController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void zSetTest(){

        final String SCORE_RANK = "zset";

        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();

        DefaultTypedTuple<String> tuple2 = new DefaultTypedTuple<>("张三" + 2, 1D + 2);
        tuples.add(tuple2);

        DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<>("张三" + 1, 1D + 1);
        tuples.add(tuple1);

        DefaultTypedTuple<String> tuple3 = new DefaultTypedTuple<>("张三" + 3, 1D + 3);
        tuples.add(tuple3);

        Long zset = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
        System.out.println(zset);

        Set<String> range = redisTemplate.opsForZSet().reverseRange(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行列表:" + JSON.toJSONString(range));

        Set<ZSetOperations.TypedTuple<String>> rangeWithScores = redisTemplate.opsForZSet().reverseRangeWithScores(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行和分数列表:" + JSON.toJSONString(rangeWithScores));

        Long rankNum = redisTemplate.opsForZSet().reverseRank(SCORE_RANK, "张三" + 3);
        System.out.println("张三" + 3 + "的个人排名：" + rankNum);

        Double score = redisTemplate.opsForZSet().score(SCORE_RANK, "张三" + 3);
        System.out.println("张三" + 3 + "的个人分数："  + score);

    }
}

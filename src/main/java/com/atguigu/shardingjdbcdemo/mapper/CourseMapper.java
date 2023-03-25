package com.atguigu.shardingjdbcdemo.mapper;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public interface CourseMapper extends BaseMapper<Course> {

    public static void main(String[] args) throws Exception {
        final Cache<String, String> RULE_CACHE = CacheBuilder.newBuilder().concurrencyLevel(4)
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        String a = RULE_CACHE.get("a", () -> {
            return "b";
        });
        System.out.println(a);
        String c = RULE_CACHE.get("a", () -> {
            return "c";
        });
        System.out.println(c);
        long size = RULE_CACHE.size();
        System.out.println(size);
    }
}

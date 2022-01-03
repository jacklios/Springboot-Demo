package com.matrix.redisdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping("")
    public void Set(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @GetMapping("/{key}")
    public Object GetValue(@PathVariable("key") String key) {
        if(redisTemplate.hasKey(key))
            return redisTemplate.opsForValue().get(key);
        else
            return "abc";
    }
}

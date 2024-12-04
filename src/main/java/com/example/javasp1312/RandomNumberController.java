package com.example.javasp1312;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RandomNumberController
{
    @GetMapping("/api/random")
    public int getRandomNumber(
            @RequestParam(value = "min", defaultValue = "1") int min,
            @RequestParam(value = "max", defaultValue = "100") int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("Min value cannot exceed the max");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
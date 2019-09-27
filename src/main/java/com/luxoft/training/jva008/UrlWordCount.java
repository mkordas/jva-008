package com.luxoft.training.jva008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UrlWordCount {

    private static final Pattern wordPattern = Pattern.compile("\\b[\\p{IsAlphabetic}]+\\b");

    public static void main(String[] args) throws IOException {
        URLConnection urlConnection = new URL("https://onet.pl").openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
            urlConnection.getInputStream(), StandardCharsets.UTF_8));
        Map<String, Long> map = reader.lines().flatMap(line -> {
            Matcher matcher = wordPattern.matcher(line);
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                list.add(matcher.group());
            }
            return list.stream();
        }).collect(groupingBy(identity(), counting()));
        List<Map.Entry<String, Long>> results = map.entrySet().stream()
            .sorted(comparingByValue(reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<String, Long> e : results) {
            System.out.println(e);
        }
        long count = results.stream().filter(e -> e.getValue() == 2).count();
        System.out.println(count);
    }
}

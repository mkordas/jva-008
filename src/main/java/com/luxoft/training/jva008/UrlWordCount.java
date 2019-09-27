package com.luxoft.training.jva008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UrlWordCount {

    private static final Pattern wordPattern = Pattern.compile("\\b[\\p{IsAlphabetic}]{5}\\b");
            //("\\b[A-Za-z]{5}\\b");

    public static void main(String[] args) throws IOException {
        URLConnection urlConnection = new URL("https://onet.pl").openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
        Map<String, Long> map = reader.lines().flatMap(line -> {
            Matcher matcher = wordPattern.matcher(line);
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                list.add(matcher.group());
            }
            return list.stream();
        }).collect(groupingBy(Function.identity(), counting()));
        List<Map.Entry<String, Long>> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<String, Long> e : result) {
            System.out.println(e);
        }
        //System.out.println(result);

        System.out.println(result.stream().filter(e -> e.getValue() == 1).count());

    }
}

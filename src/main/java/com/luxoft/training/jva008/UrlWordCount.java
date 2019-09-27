package com.luxoft.training.jva008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UrlWordCount {

    private static final Pattern wordPattern = Pattern.compile("\\b[\\p{IsAlphabetic}]+");

    public static void main(String[] args) throws IOException {
        URLConnection stronaUrlConn = new URL("https://www.onet.pl").openConnection();
        BufferedReader stronaBuffReader = new BufferedReader(new InputStreamReader(stronaUrlConn.getInputStream()));
        Map<String, Long> map = stronaBuffReader.lines().flatMap(s -> {
            Matcher matcher = wordPattern.matcher(s);
            List<String> strings = new ArrayList<>();
            while (matcher.find()) { strings.add(matcher.group()); }
            return strings.stream();
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<String, Long>> sortedEntries =
                map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<String, Long> entry : sortedEntries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        long countValues1 = sortedEntries.stream().filter(e -> e.getValue() == 1).count();
        long countAllEntries = sortedEntries.stream().count();
        System.out.println("\nIlość wszystkich słów: " + countAllEntries);
        System.out.println("Ilość słów występujących tylko raz: " + countValues1 + " (" + countValues1*100/countAllEntries + "%)");
//        System.out.println(sortedEntries);
//        fix char coding !!
    }
}
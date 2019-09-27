package com.luxoft.training.jva008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UrlWordCount {

    private static final Pattern wordPattern = Pattern.compile("[A-Za-z]+");

    public static void main(String[] args) throws IOException {
        URLConnection stronaUrlConn = new URL("https://www.onet.pl").openConnection();
        BufferedReader stronaBuffReader = new BufferedReader(new InputStreamReader(stronaUrlConn.getInputStream()));
        Map<String, Long> map = stronaBuffReader.lines().flatMap(s -> {
            Matcher matcher = wordPattern.matcher(s);
            List<String> strings = new ArrayList<>();
            while (matcher.find()) { strings.add(matcher.group()); }
            return strings.stream();
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
}
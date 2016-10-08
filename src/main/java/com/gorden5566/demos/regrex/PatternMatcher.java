package com.gorden5566.demos.regrex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    private static final Logger logger = LoggerFactory.getLogger(PatternMatcher.class);

    private String regex;

    private Pattern pattern;

    public PatternMatcher(String regex) {
        this.regex = regex;
    }

    public void compile() {
        if (pattern == null) {
            pattern = Pattern.compile(regex);
        }
    }

    public void matcher(String str) {
        compile();

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            logger.info("matcher.group(): " + matcher.group());

            for (int i = 0; i <= matcher.groupCount(); ++i) {
                logger.info("matcher.group({}): {}", i, matcher.group(i));
            }
        }
    }
}

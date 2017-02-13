package com.ksimeo.givorost.customer.validators;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ksimeo. Created on 22.01.2017 at 16:19 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Component("telValidator")
public class TelValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String TELEFONE_NUMBER_PATTERN = "[0-9]";

    public TelValidator() {
        pattern = Pattern.compile(TELEFONE_NUMBER_PATTERN);
    }

    public boolean valid(final String telNumber) {
        if (telNumber.length() != 9) return false;

        matcher = pattern.matcher(telNumber);
        return matcher.matches();
    }
}

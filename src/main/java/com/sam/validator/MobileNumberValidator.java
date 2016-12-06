package com.sam.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by samchu on 2016/12/6.
 */
@Component
public class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {
    // 不分大小寫
    private static Pattern mobileRegex = Pattern.compile("^1\\d{10}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void initialize(MobileNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return mobileRegex.matcher(value).find();
    }
}

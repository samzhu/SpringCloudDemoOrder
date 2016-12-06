package com.sam.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by samchu on 2016/12/6.
 */

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileNumberValidator.class)
@Documented
public @interface MobileNumber {
    String message() default "電話號碼不正確";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

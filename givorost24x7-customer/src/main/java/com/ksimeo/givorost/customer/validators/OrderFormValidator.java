package com.ksimeo.givorost.customer.validators;

import com.ksimeo.givorost.api.services.OrderService;
import com.ksimeo.givorost.core.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Ksimeo. Created on 21.01.2017 at 15:06 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */

@Component
public class OrderFormValidator implements Validator {

    @Autowired
    OrderService orderService;

    @Autowired
    @Qualifier("telValidator")
    TelValidator telValidator;

    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        OrderDTO order = (OrderDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "NotEmpty.orderForm.tel");

        if (order.getTel() == null || order.getTel().equals("")) {
            errors.rejectValue("tel", "NotEmpty.orderForm.tel");
        } else {
            if (!telValidator.valid(order.getTel())) {
                errors.rejectValue("tel", "Pattern.orderForm.tel");
            }
        }

        if (order.getEmail() != null && !(order.getEmail().equals(""))) {
            if (!emailValidator.valid(order.getEmail())) {
                errors.rejectValue("email", "Pattern.orderForm.email");
            }
        }
    }
}
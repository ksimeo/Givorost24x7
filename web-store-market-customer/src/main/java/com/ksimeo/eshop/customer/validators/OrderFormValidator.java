package com.ksimeo.eshop.customer.validators;

import com.ksimeo.eshop.api.services.OrderService;
import com.ksimeo.eshop.entities.models.Order;
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
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Order order = (Order) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.orderForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telNumber", "NotEmpty.orderForm.telNumber");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prodName", "NotEmpty.orderForm.prodName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty.orderForm.amount");

        if (order.getName() == null || order.getName().equals("")) {
            errors.rejectValue("name", "NotEmpty.orderForm.name");
        }

        if (!telValidator.valid(order.getTelNumber()) || (order.getTelNumber().length() != 12 ^
                order.getTelNumber().contains("+") & order.getTelNumber().length() == 13)) {
            errors.rejectValue("telNumber", "Pattern.orderForm.telNumber");
        }

        if (!emailValidator.valid(order.geteMail())){
            errors.rejectValue("eMail", "Pattern.orderForm.eMail");
        }

        if (order.getProdName() == null || order.getProdName().equals("")) {
            errors.rejectValue("prodName", "NotEmpty.orderForm.prodName");
        }

        if (order.getAmount() == null || order.getAmount() <= 0) {
            errors.rejectValue("amount", "NotEmpty.orderForm.amount");
        }
    }
}
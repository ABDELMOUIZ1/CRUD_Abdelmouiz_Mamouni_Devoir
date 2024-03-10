package com.demo28.validators;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.Locale;
import java.util.ResourceBundle;

public class EmailValidator implements Validator {
    Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", currentLocale);
    private static final int MIN_EMAIL_LENGTH = 5;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
        currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        bundle = ResourceBundle.getBundle("i18n.messages", currentLocale);
        String email = (String) object;
        if(!isValidEmail(email)){
            throw new ValidatorException(new FacesMessage(bundle.getString("error_adress_non_valid")));
        }

        if(email.length() < MIN_EMAIL_LENGTH){
            throw new ValidatorException(new FacesMessage(bundle.getString("error_adress_cont_au_moins") + MIN_EMAIL_LENGTH +"!!!!"));
        }
    }
    private Boolean isValidEmail(String email) {
        return email != null && email.contains("@");
        }
}
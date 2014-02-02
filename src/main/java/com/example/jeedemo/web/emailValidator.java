package com.example.jeedemo.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class emailValidator implements Validator {
	
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public emailValidator(){
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	public boolean validatePattern(final String email){
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		String email = (String) value;
		
		
		if (!validatePattern(email)) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Nieprawidłowy format email");
			message.setSummary("Nieprawidłowy format email");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
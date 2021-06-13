package br.com.protheus.protheus.exceptions;

public class UserNotFoundException extends ResourceNotFoundException {

    private static final String MESSAGE = "User not found with username or email: %s";

    public UserNotFoundException(final String usernameOrEmail) {
        super(String.format(MESSAGE, usernameOrEmail));
    }
}

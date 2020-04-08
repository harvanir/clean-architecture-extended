package org.harvanir.item.core.usecase.create;

/**
 * @author Harvan Irsyadi
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }
}

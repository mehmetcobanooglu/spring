package com.mehmetcobanoglu.exception;

import com.mehmetcobanoglu.response.*;

public class BaseException extends RuntimeException {

    public BaseException() {

    }

    public BaseException(ErrorMessage ErrorMessage) {
        super(ErrorMessage.prepareErrorMessage());
    }

}

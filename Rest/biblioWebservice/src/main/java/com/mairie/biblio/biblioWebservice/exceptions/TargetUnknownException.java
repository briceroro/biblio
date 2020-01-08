package com.mairie.biblio.biblioWebservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TargetUnknownException extends RuntimeException {
	
	public TargetUnknownException(String s) {
        super(s);
    }
}

package com.mairie.biblio.biblioWebservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TargetUnknownException extends RuntimeException {
	
	public TargetUnknownException(String s) {
        super(s);
        log.error(s);
    }
}

package com.mairie.biblio.biblioWebservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)
public class TargetConflictExeption extends RuntimeException{
	
	public TargetConflictExeption(String s) {
        super(s);
    }

}

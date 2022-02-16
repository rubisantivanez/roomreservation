package com.supportmeeting.roomreservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Available room not found")
public class AvailableRoomNotFoundException extends RuntimeException{
}

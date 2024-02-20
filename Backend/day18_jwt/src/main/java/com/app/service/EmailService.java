package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.EmailDto;

public interface EmailService {

	ApiResponse sendSimpleMail(EmailDto details);
}

package com.app.service;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ContentDescDto;
import com.app.dto.ContentGetDto;

public interface ContentService {

	ApiResponse newContentByCId(@NotNull Long courseId, ContentDescDto course);

	ApiResponse uploadImageToFileSystem(MultipartFile file, Long contentId) throws IOException;

	ContentGetDto contentBYId(@NotNull Long contentId);


}

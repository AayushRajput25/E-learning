package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ContentDescDto;
import com.app.dto.ContentGetDto;
import com.app.dto.ResponseIdDto;
import com.app.entities.Content;

public interface ContentService {

	ResponseIdDto newContentByCId(@NotNull Long courseId, ContentDescDto course);

	ApiResponse uploadImageToFileSystem(MultipartFile file, Long contentId) throws IOException;

	ContentGetDto contentBYId(@NotNull Long contentId);

	List<Content> getCoursesById(@NotNull Long courseId);

	ApiResponse deleteByCourseId(@NotNull Long contentId);

	ApiResponse courseNameById(@NotNull Long courseId);

}

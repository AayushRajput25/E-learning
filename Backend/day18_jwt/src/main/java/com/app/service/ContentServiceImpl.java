package com.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ContentDao;
import com.app.dao.CourseDao;
import com.app.dto.ApiResponse;
import com.app.dto.ContentDescDto;
import com.app.dto.ContentGetDto;
import com.app.dto.ResponseIdDto;
import com.app.entities.Content;
import com.app.entities.Courses;

@Service
@Transactional
public class ContentServiceImpl implements ContentService{

	@Autowired
	private CourseDao cDao;
	
	@Autowired
	private ContentDao contentDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ResponseIdDto newContentByCId(@NotNull Long courseId, ContentDescDto content) {
		Courses cou =  cDao.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course Not exist"));
		Content cont = mapper.map(content, Content.class);
//		System.out.println("FINAL DEBUGGING!!! --- "+cont.getDescription());
		cou.addCourse(cont);
		Content c = contentDao.save(cont);	
		return new ResponseIdDto(c.getId());
	}

	
//	private final String FOLDER_PATH="/home/sunbeam/Desktop/files/";
	private final String FOLDER_PATH="/home/sunbeam/Desktop/frontEnd/my-react-app/public/Videos/";

	@Override
	public ApiResponse uploadImageToFileSystem(MultipartFile file, Long contentId) throws IOException {
		Content content = contentDao.findById(contentId).orElseThrow(()-> new ResourceNotFoundException("Course Not exist"));
//		String filePath=FOLDER_PATH+file.getOriginalFilename();
		String filePath=FOLDER_PATH+file.getOriginalFilename();
		String uri = "./Videos/"+file.getOriginalFilename();
//		content.setFilePath(filePath);
		content.setFilePath(uri);
//		content.setTitle(file.getOriginalFilename());
		
		contentDao.save(content);
		file.transferTo(new File(filePath));
		
		if (content.getFilePath() != null) {
            return new ApiResponse("file uploaded successfully : " + filePath);
        }
		
		return new ApiResponse("file upload failed");
	}
	
	@Override
	public ContentGetDto contentBYId(@NotNull Long contentId) {	
		
		Content content = contentDao.findById(contentId).orElseThrow(()-> new ResourceNotFoundException("Course Not exist"));
		System.out.println(content);
		
		ContentGetDto myDto = mapper.map(content,ContentGetDto.class);
		System.out.println(myDto);
		return myDto;
	}

	@Override
	public List<Content> getCoursesById(@NotNull Long courseId) { // getting all the content associated with a courseId
		
		Courses c = cDao.getById(courseId);
		
		return contentDao.findByCid(c);
	}

	@Override
	public ApiResponse deleteByCourseId(@NotNull Long contentId) { // deleting content by contentId, which is not enrolled by any student
		if (contentDao.existsById(contentId)) {
			
			contentDao.deleteById(contentId);
			return new ApiResponse("content have been deleted successfull");
		}
		
		return new ApiResponse("deletion failed");
	}

		
	
}

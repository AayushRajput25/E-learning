package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "content")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    @ManyToOne
	@JoinColumn(name = "course_id",nullable = false)
	private Courses cId;
    
    @Column(name = "title",length = 100)
    private String title;

    @Column(name = "link")
    private String filePath;
    
    @Column(name = "description",columnDefinition="TEXT")
    private String description;


   
}

package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "content")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Content{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    @ManyToOne
	@JoinColumn(name = "course_id",nullable = false)
    @JsonIgnore
	private Courses cid;
    
    @Column(name = "title",length = 100)
    private String title;

    @Column(name = "link")
    private String filePath;
    
    @Column(name = "description",columnDefinition="TEXT")
    private String description;
   
    @OneToMany(mappedBy = "cid",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Enrollment> enrollmentNo;
    
}

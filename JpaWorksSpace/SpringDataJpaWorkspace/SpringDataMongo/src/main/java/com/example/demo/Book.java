package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document 
public class Book {

	@Id 
	private String id;

	@NonNull
	private Integer bookId;
	@NonNull
	private String bookName;
	@NonNull
	private String bookAuthor;
	@NonNull
	private Double bookCost;
}

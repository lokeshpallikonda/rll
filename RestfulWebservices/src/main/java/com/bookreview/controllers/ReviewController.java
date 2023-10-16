package com.bookreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookreview.entity.Review;
import com.bookreview.service.ReviewService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/review")
public class ReviewController {

	@Autowired
	ReviewService reviewservice;




	//this is pritikas part working
	@PostMapping("/add")
	public Review findbyname(@RequestBody Review review)
	{
		return reviewservice.save(review);
		        	
	}


	//working sai's part
	@GetMapping("/list")
	public List<Review> getAll() 
	{
		return reviewservice.getAllreview();
	}
	//testing part by sai
	@Autowired
	public ReviewController(ReviewService reviewService) {
	    this.reviewservice = reviewService;
	}
}

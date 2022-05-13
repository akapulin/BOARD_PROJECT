package com.board.subproject.service.posts;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.board.subproject.domain.posts.PostsRepository;
import com.board.subproject.web.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsService {
	private final PostsRepository postsRepository;
	/*
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity().getId());
	}
	*/
}

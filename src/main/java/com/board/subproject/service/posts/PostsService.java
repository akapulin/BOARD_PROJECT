package com.board.subproject.service.posts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.board.subproject.domain.posts.Posts;
import com.board.subproject.domain.posts.PostsRepository;
import com.board.subproject.web.dto.PostsListResponseDto;
import com.board.subproject.web.dto.PostsResponseDto;
import com.board.subproject.web.dto.PostsSaveRequestDto;
import com.board.subproject.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}
	
	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
		return new PostsResponseDto(entity);

	}
	
	@Transactional(readOnly=true)
	public List<PostsListResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().stream()
				.map(PostsListResponseDto::new)
				.collect(Collectors.toList());
	}
	
}

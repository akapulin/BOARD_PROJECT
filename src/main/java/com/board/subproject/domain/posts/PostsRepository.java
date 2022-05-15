package com.board.subproject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


//Dao역할

public interface PostsRepository extends JpaRepository<Posts,Long> {

}

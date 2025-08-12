package com.likelion.seminar.repository;

import com.likelion.seminar.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<PostEntity, Long> {
}


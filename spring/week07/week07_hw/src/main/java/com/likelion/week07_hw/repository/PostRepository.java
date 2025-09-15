package com.likelion.week07_hw.repository;

import com.likelion.week07_hw.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}

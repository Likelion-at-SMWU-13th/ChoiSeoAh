package com.likelion.week07_hw.repository;

import com.likelion.week07_hw.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}

package com.likelion.seminar.repository;

import com.likelion.seminar.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;


public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}

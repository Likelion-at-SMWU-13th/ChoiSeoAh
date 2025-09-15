package com.likelion.week07_hw.repository;

import com.likelion.week07_hw.entity.WriterEntity;
import org.springframework.data.repository.CrudRepository;

public interface WriterRepository extends CrudRepository<WriterEntity, Long> {
}

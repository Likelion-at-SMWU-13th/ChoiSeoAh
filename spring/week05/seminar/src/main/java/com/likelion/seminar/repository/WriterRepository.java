package com.likelion.seminar.repository;

import com.likelion.seminar.entity.WriterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<WriterEntity, Long> {
}

package com.exmaple.repository;


import com.exmaple.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

// 接口
public interface DemoRepository extends JpaRepository<Demo, Integer> {
}

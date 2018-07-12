package com.exmapl;


import org.springframework.data.jpa.repository.JpaRepository;

// 接口
public interface DemoRepository extends JpaRepository<Demo, Integer> {
}

package com.exmapl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// 事务管理
// 主要用于同时操作多条数据
// 有一条数据不符合要求，全部都不会操作
@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Transactional
    public void insertTwo(){
        Demo demoA = new Demo();
        demoA.setAge(20);
        demoA.setName("z");
        demoRepository.save(demoA);

        Demo demoB = new Demo();
        demoB.setAge(19);
        demoB.setName("xxx");
        demoRepository.save(demoB);



    }
}

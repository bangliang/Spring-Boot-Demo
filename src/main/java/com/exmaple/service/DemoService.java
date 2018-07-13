package com.exmaple.service;

import com.exmaple.domain.Demo;
import com.exmaple.enums.ResultEmum;
import com.exmaple.exception.DemoException;
import com.exmaple.repository.DemoRepository;
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
    public void insertTwo() {
        Demo demoA = new Demo();
        demoA.setAge(20);
        demoA.setName("z");
        demoA.setSexy("男");
        demoRepository.save(demoA);

        Demo demoB = new Demo();
        demoB.setAge(19);
        demoB.setName("nininininini");
        demoB.setSexy("女");
        demoRepository.save(demoB);
    }

    // 通过抛出异常来判断年龄阶段
    // 在service中处理逻辑
    public void getAge(Integer id) throws Exception{

        Demo demo =  demoRepository.findById(id).get();
        Integer age = demo.getAge();
        Integer result = 0;
        if(age < 12)
            throw new DemoException(ResultEmum.PRIMARY);
        else if(age < 15)
            throw new DemoException(ResultEmum.MIDDLE);
        else if(age < 18)
            throw new DemoException(ResultEmum.HIGH);

    }

}

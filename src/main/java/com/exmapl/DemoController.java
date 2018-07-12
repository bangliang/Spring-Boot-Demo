package com.exmapl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 控制器
@RestController
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;

    /**
     * 查询所有demo列表
     * @return
     */
    @GetMapping("/demo/all")
    public List<Demo> demoList(){
        return demoRepository.findAll();
    }

    /**
     * 添加一个demo对象
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/demo/add")
    public Demo demoAdd(@RequestParam("name") String name,
                        @RequestParam("age") Integer age){
        Demo demo = new Demo();
        demo.setAge(age);
        demo.setName(name);

        return demoRepository.save(demo);
    }

    /**
     * 修改demo信息
     * @param name
     * @param age
     * @return
     */
    @PutMapping("/demo/update/{id}")
    public Demo demoUpdate(@RequestParam("name") String name,
                           @RequestParam("age") Integer age,
                           @PathVariable("id") Integer id){
        Demo demo = new Demo();
        demo.setId(id);
        demo.setAge(age);
        demo.setName(name);

        return demoRepository.save(demo);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @GetMapping("/demo/{id}")
    public Demo demoFindById(@PathVariable("id") Integer id){
     return demoRepository.findById(id).get(); // 返回的是一个容器对象 在后面调用get方法就行了
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @GetMapping("/demo/delete/{id}")
    public void demoDelete(@PathVariable("id") Integer id){
//        String a = null;
//        if(demoRepository.existsById(id)) {
            demoRepository.deleteById(id);
//            a = "成功！";
//        }
//        else
//            a = "失败！";
//        return a;
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @PostMapping("/demo/age/{age}")
    public List<Demo> demosFindByAge(@PathVariable("age") Integer age){
        Demo demo = new Demo();
        demo.setAge(age);
        // 使用Example快速实现动态查询
        Example<Demo> example = Example.of(demo);
        // 泛型，返回一个结果集
        List<Demo> result = demoRepository.findAll(example);
        return result;
    }

    /**
     * 插入两个demo
     */
    @PostMapping("/demo/add/two")
    public void addTwo(){
        demoService.insertTwo();
    }
}

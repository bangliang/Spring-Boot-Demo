package com.exmaple.controller;

import org.springframework.web.bind.annotation.*;

// 处理请求也可以用@Controller+@ResponseBody
@RestController
@RequestMapping({"/hello", "hi"})
public class HelloController {

//    @Autowired
//    private  DemoProperties demoProperties;

//    method可以省略，但为了安全起见，需要写请求方式
//    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
// 简化注解
    @GetMapping("/say/{id}")

// 在路径后加?id=
//    public String say(@RequestParam("id") Integer id) {
// @PathVariable用来获取url中的数据
    public String say(@PathVariable("id") Integer id) {
        return "id: " + id;
//        return "hello ! BaiJiWen, my dear!";
//        return "cupSize:" + cupSize + "age:" + age;
//        return demoProperties.getCupSize();
    }
}

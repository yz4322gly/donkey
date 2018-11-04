package xin.tomdonkey.demo.rpc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.tomdonkey.dome.rpc.api.HelloService;

@RestController
public class HelloController
{
    @Reference
    private HelloService helloService;

    @GetMapping("sayHello")
    public String sayHello()
    {
        return helloService.sayHello();
    }

}

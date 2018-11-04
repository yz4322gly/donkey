package xin.tomdonkey.demo.rpc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import xin.tomdonkey.dome.rpc.api.HelloService;

@Service(timeout = 5000)
public class HelloServiceImpl implements HelloService
{
    @Override
    public String sayHello()
    {
        return "hello";
    }
}

package xin.tomdonkey.demo.rpc;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "xin.tomdonkey.demo.rpc.service.impl")
public class DonkeyDemoServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DonkeyDemoServiceApplication.class, args);
    }
}

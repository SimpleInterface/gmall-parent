package com.atguigu.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/*@SpringBootApplication
@EnableDiscoveryClient  服务发现
@EnableCircuitBreaker*/  //开启服务熔断
@SpringCloudApplication //一个顶上面三个
@MapperScan("com.atguigu.gmall.product.mapper")
public class ProductMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class,args);
    }
}

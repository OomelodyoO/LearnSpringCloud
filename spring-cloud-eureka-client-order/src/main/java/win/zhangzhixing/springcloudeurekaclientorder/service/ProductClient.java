package win.zhangzhixing.springcloudeurekaclientorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import win.zhangzhixing.springcloudeurekaclientorder.fallback.ProductClientFallBack;

@FeignClient(name = "product-service", fallback = ProductClientFallBack.class)
public interface ProductClient {
    @GetMapping("/api/v1/product/find")
    String findById(@RequestParam(value = "id") int id);
}

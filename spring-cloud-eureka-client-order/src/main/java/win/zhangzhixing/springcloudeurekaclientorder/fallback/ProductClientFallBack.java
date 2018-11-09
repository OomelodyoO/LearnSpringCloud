package win.zhangzhixing.springcloudeurekaclientorder.fallback;

import org.springframework.stereotype.Component;
import win.zhangzhixing.springcloudeurekaclientorder.service.ProductClient;

@Component
public class ProductClientFallBack implements ProductClient {
    @Override
    public String findById(int id) {
        System.out.println("feign 调用product-service findById异常");
        return null;
    }
}

package win.zhangzhixing.springcloudeurekaclientorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import win.zhangzhixing.springcloudeurekaclientorder.domain.ProductOrder;
import win.zhangzhixing.springcloudeurekaclientorder.service.ProductOrderService;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    // 调用方式一
    @Autowired
    private RestTemplate restTemplate;
    // 调用方式二
    // @Autowired
    // private LoadBalancerClient loadBalancerClient;

    @Override
    public ProductOrder save(int userId, int productId) {
        // 调用方式二
        // ServiceInstance instance = loadBalancerClient.choose("product-service");
        // String url = String.format("http://%s:%s/api/v1/product/find?id=" + productId, instance.getHost(), instance.getPort());
        // RestTemplate restTemplate = new RestTemplate();
        // Map<String, Object> productMap = restTemplate.getForObject(url, Map.class);
        // 调用方式一
        Map<String, Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Map.class);
        System.out.println(productMap);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(productMap.get("name").toString());
        productOrder.setPrice(Integer.parseInt(productMap.get("price").toString()));
        return productOrder;
    }
}

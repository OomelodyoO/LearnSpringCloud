package win.zhangzhixing.springcloudeurekaclientorder.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import win.zhangzhixing.springcloudeurekaclientorder.service.ProductOrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private ProductOrderService productOrderService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(
            @RequestParam("user_id") int userId,
            @RequestParam("product_id") int productId,
            HttpServletRequest request
    ) {
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");

        System.out.println("token:" + token);
        System.out.println("cookie:" + cookie);

        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", productOrderService.save(userId, productId));
        return msg;
    }

    // 注意，方法签名一定要和api方法一直
    private Object saveOrderFail(int userId, int productId, HttpServletRequest request) {
        String saveOrderKey = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderKey);
        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("紧急短信，下单失败");
                redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 5, TimeUnit.SECONDS);
            } else {
                System.out.println("20秒内不重新发送");
            }
        }).start();


        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多");
        return msg;
    }
}

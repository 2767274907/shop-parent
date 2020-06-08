package com.t248.service;

import com.t248.entity.App;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: shop-parent
 * @author: 水向南
 * @create: 2020-05-16 14:32
 **/
@FeignClient(value = "app-mayikt-weixin")
public interface MemberService extends WeiXinService{

}

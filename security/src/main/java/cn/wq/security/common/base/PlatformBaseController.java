package cn.wq.security.common.base;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlatformBaseController {

    @InitBinder
    public void initBinderParam(WebDataBinder binder) {
        binder.setDisallowedFields(new String[]{"admin", "ts"});
    }
    
//    @ExceptionHandler
//    public CommonResult handleException(Exception e) {
//    	log.error(" handle exception ", e);
//    	CommonResult result = CommonResult.ofFail();
//    	result.setMessage("程序异常");
//    	return result;
//    }

}

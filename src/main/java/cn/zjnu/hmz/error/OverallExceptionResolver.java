package cn.zjnu.hmz.error;

/**
 * 系统全局异常处理器
 * @Author Hu mingzhi
 * Created by Lenovo on 2017/7/8.
 */
/*
@Controller
public class OverallExceptionResolver implements HandlerExceptionResolver {
    */
/**
     * 进行全局异常的过滤和处理
     *//*

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler为当前处理器适配器执行的对象
        String message = null;
        //判断是否为系统自定义异常。
        if(ex instanceof CustomException) {
            message = ((CustomException) ex).getMessage();
        }

        else {
            message = "系统出错啦，稍后再试试！";
        }


        ModelAndView modelAndView = new ModelAndView();
        //跳转到相应的处理页面
        modelAndView.addObject("errorMsg", message);
        modelAndView.setViewName("errorPage");

        return modelAndView;
    }


}
*/

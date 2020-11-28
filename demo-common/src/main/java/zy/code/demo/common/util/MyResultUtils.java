package zy.code.demo.common.util;

public class MyResultUtils {
    MyResult result;

    public static <T> MyResult<T> wrapSuccess(T data) {
        MyResult<T> result = new MyResult();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    public static <T> MyResult<T> wrapFailed(T data) {
        MyResult<T> result = new MyResult();
        result.setCode(1);
        result.setMessage("失败");
        result.setData(data);
        return result;
    }
}

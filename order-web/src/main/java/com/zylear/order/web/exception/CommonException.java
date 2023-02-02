

package com.zylear.order.web.exception;

import com.zylear.order.web.bean.base.ResultMsg;
import org.springframework.core.NestedRuntimeException;

/**
 * @author xiezongyu
 */
public class CommonException extends NestedRuntimeException {
    
    private static final long serialVersionUID = 4734860024944705912L;
    
    private int code;

    public int getCode() {
        return code;
    }

    public CommonException(ResultMsg resultMsg) {
        super(resultMsg.getMessage());
        this.code = resultMsg.getCode();
    }
    public CommonException( int code,String msg) {
        super(msg);
        this.code = code;
    }
}
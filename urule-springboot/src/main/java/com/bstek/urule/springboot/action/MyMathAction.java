package com.bstek.urule.springboot.action;

import com.bstek.urule.Utils;
import com.bstek.urule.model.ExposeAction;
import com.bstek.urule.model.library.action.annotation.ActionBean;
import com.bstek.urule.model.library.action.annotation.ActionMethod;
import com.bstek.urule.model.library.action.annotation.ActionMethodParameter;

import java.math.BigDecimal;

/**
 * @author rtao
 * @date 2021/9/2 19:04
 */
@ActionBean(name = "自定义数学函数")
public class MyMathAction {

    @ExposeAction(value = "向上取整", parameters = {"数字"})
    @ActionMethod(name = "向上取整")
    @ActionMethodParameter(names = {"数字"})
    public Number ceil(Object num) {
        BigDecimal bigDecimal = Utils.toBigDecimal(num);
        return (new BigDecimal(Math.ceil(bigDecimal.doubleValue()))).stripTrailingZeros();
    }
}

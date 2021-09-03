package com.bstek.urule.springboot.action;

import com.bstek.urule.model.library.action.annotation.ActionBean;
import com.bstek.urule.model.library.action.annotation.ActionMethod;
import com.bstek.urule.model.library.action.annotation.ActionMethodParameter;

/**
 * @author rtao
 * @date 2021/9/2 14:23
 */
@ActionBean(name = "财务报表")
public class FinancialStatementAction {

    /**
     * 资产负债率 = 负债总额/资产总额 × 100%
     * 满分：7
     * 参照值：≤60%
     * 评分规则：每大1个百分点扣 0.233分，大于 90（包括90）为 0 分
     */
    @ActionMethod(name = "资产负债率")
    @ActionMethodParameter(names = {"资产负债率"})
    public double assetLiabilityRatio(double ratio){
        double result = 0;
        if (ratio <= 60) {
            result = 7;
        } else if (ratio > 60 && ratio <90) {
            result = 7 - 0.233 * (ratio - 60);
        }
        return result;
    }

}

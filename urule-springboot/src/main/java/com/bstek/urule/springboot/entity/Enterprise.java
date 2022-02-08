package com.bstek.urule.springboot.entity;

import com.bstek.urule.model.Label;

/**
 * @author rtao
 * @date 2021/9/18 9:44
 */
public class Enterprise {

    @Label("行业")
    private String business;

    @Label("营业收入")
    private double taking;

    @Label("从业人员")
    private int staff;

    @Label("资产总额")
    private double totalAssets;

    @Label("评级")
    private String level;

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public double getTaking() {
        return taking;
    }

    public void setTaking(double taking) {
        this.taking = taking;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

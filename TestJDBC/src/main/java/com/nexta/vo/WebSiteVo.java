package main.java.com.nexta.vo;

import main.java.com.nexta.model.WebSite;

public class WebSiteVo extends WebSite {

    public WebSiteVo(){}

    public static final int PAGE_SIZE = 2; // 每页记录数

    public static int getPageSize() {
        return PAGE_SIZE;
    }
}

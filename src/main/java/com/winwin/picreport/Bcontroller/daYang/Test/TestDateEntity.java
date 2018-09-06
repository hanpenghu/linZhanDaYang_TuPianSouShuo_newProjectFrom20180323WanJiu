package com.winwin.picreport.Bcontroller.daYang.Test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.winwin.picreport.Futils.hanhan.p;

import java.util.Date;

/**
 * Created by Administrator on 2018/9/5.
 */
public class TestDateEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = p.d16,timezone=p.bjTimezone)
    private Date date1;

    public Date getDate1() {
        return date1;
    }

    public TestDateEntity setDate1(Date date1) {
        this.date1 = date1;
        return this;
    }
}

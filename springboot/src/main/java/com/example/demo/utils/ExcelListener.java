package com.example.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {

    private List<Object> datas = new ArrayList<>();

    /**
     * 逐行解析
     * object : 当前行的数据
     */
    @Override
    public void invoke(Object object, AnalysisContext context) {
        //当前行
        // context.getCurrentRowNum()
        if (object != null) {
            datas.add(object);
        }
    }


    /**
     * 解析完所有数据后会调用该方法
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //解析结束销毁不用的资源
    }
}

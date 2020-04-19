package com.example.demo.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.util.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * excel工具
 */
public class ExcelUtil {

    static Logger log = LogManager.getLogger(ExcelUtil.class);

    private static Sheet initSheet;

    static {
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
        //设置自适应宽度
        initSheet.setAutoWidth(Boolean.TRUE);
    }

    /**
     * 生成excle
     * @param filePath  绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data 数据源
     * @param head 表头
     */
    public static void writeBySimple(String filePath, List<List<Object>> data, List<String> head){
        writeSimpleBySheet(filePath,data,head,null);
    }

    /**
     * 生成excle
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data 数据源
     * @param sheet excle页面样式
     * @param head 表头
     */
    public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<String> head, Sheet sheet){
        sheet = (sheet != null) ? sheet : initSheet;

        if(head != null){
            List<List<String>> list = new ArrayList<>();
            head.forEach(h -> list.add(Collections.singletonList(h)));
            sheet.setHead(list);
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data,sheet);
        } catch (FileNotFoundException e) {
            log.error("找不到文件或文件路径错误, 文件：{}", filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }

            } catch (IOException e) {
                log.error("excel文件导出失败, 失败原因：{}", e);
            }
        }

    }

    /**
     * 生成excle
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data 数据源
     */
    public static void writeWithTemplate(String filePath, List<? extends BaseRowModel> data){
        writeWithTemplateAndSheet(filePath,data,null);
    }

    /**
     * 生成excle
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data 数据源
     * @param sheet excle页面样式
     */
    public static void writeWithTemplateAndSheet(String filePath, List<? extends BaseRowModel> data, Sheet sheet){
        if(CollectionUtils.isEmpty(data)){
            return;
        }

        sheet = (sheet != null) ? sheet : initSheet;
        sheet.setClazz(data.get(0).getClass());

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write(data,sheet);
        } catch (FileNotFoundException e) {
            log.error("找不到文件或文件路径错误, 文件：{}", filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                log.error("excel文件导出失败, 失败原因：{}", e);
            }
        }

    }

    /**
     * 生成多Sheet的excle
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param multipleSheelPropetys
     */
    public static void writeWithMultipleSheel(String filePath,List<MultipleSheelPropety> multipleSheelPropetys){
        if(CollectionUtils.isEmpty(multipleSheelPropetys)){
            return;
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            for (MultipleSheelPropety multipleSheelPropety : multipleSheelPropetys) {
                Sheet sheet = multipleSheelPropety.getSheet() != null ? multipleSheelPropety.getSheet() : initSheet;
                if(!CollectionUtils.isEmpty(multipleSheelPropety.getData())){
                    sheet.setClazz(multipleSheelPropety.getData().get(0).getClass());
                }
                writer.write(multipleSheelPropety.getData(), sheet);
            }

        } catch (FileNotFoundException e) {
            log.error("找不到文件或文件路径错误, 文件：{}", filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                log.error("excel文件导出失败, 失败原因：{}", e);
            }
        }

    }
}

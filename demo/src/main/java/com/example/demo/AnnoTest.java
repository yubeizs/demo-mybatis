package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnnoTest {
    public static void main(String[] args) {
        PageTestVO base = new PageTestVO();
        List<AttachInfoList> attachInfos = new ArrayList<>();

        // 单个--- attachInfo
        AttachInfoList attachInfo = new AttachInfoList();
        AttachVO test111 = new AttachVO("111", "test111");
        List<AttachVO> list1 = new ArrayList<>();
        list1.add(test111);
        attachInfo.setAttachVOList(list1);
        attachInfo.setRefId("test111");
        base.setAttachInfo(attachInfo);

        //多个 ----- attachInfos
        AttachInfoList attachInfo2 = new AttachInfoList();
        AttachVO test222 = new AttachVO("222", "test222");
        List<AttachVO> list2 = new ArrayList<>();
        list2.add(test222);
        attachInfo2.setAttachVOList(list2);

        AttachInfoList attachInfo3 = new AttachInfoList();
        AttachVO test333 = new AttachVO("333", "test333");
        List<AttachVO> list3 = new ArrayList<>();
        list3.add(test333);
        attachInfo3.setAttachVOList(list3);

        List<AttachInfoList> attachInfoLists23 = new ArrayList<>();
        attachInfoLists23.add(attachInfo2);
        attachInfoLists23.add(attachInfo3);
        base.setAttachInfos(attachInfoLists23);

        //注解嵌套 -----paragraphVO
        AttachInfoList attachInfo4 = new AttachInfoList();
        AttachVO test444 = new AttachVO("444", "test444");
        List<AttachVO> list4 = new ArrayList<>();
        list4.add(test444);
        attachInfo4.setAttachVOList(list4);
        ParagraphVO paragraphVO = new ParagraphVO();
        paragraphVO.setAttachInfoLists(attachInfo4);
        base.setParagraphVO(paragraphVO);

        dealAttachInfo(base, attachInfos);

        System.out.println("数据附件提取：" + JSON.toJSON(attachInfos));
    }

    public static <T> void dealAttachInfo(T base, List<AttachInfoList> attachInfos) {
        // 为空不处理
        if (base == null) {
            return;
        }
        // 对象是AttachInfoList，直接处理
        if (base instanceof AttachInfoList) {
            attachInfos.add((AttachInfoList) base);
            return;
        }
        // 集合遍历处理
        if (base instanceof List) {
            Iterator it = ((List) base).iterator();
            while (it.hasNext()) {
                dealAttachInfo(it.next(), attachInfos);
            }
        } else {
            //处理逻辑
            Class<?> baseClass = base.getClass();
            //遍历属性处理
            Field[] fields = baseClass.getDeclaredFields();
            try {
                for (Field field : fields) {
                    String name = field.getName(); //属性名称
                    String getMethodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1); //获取该属性的方法名
                    Method method = baseClass.getMethod(getMethodName);  //获取该属性的方法
                    Object obj = method.invoke(base);   //该属性类型及值
                    //这个属性是AttachInfoList，那么直接封装禁attachInfos
                    if (obj == null) continue;
                    if (obj instanceof AttachInfoList) {
                        attachInfos.add((AttachInfoList) obj);
                    } else if (obj instanceof List && ((List) obj).size() > 0 && ((List) obj).get(0) instanceof AttachInfoList) {
                        attachInfos.addAll((List) obj);
                    } else {
                        //如果不是，继续查找注解，看看是否需要继续下钻
                        AttachAnnotion attachAnnotion = field.getDeclaredAnnotation(AttachAnnotion.class);  //是否有文件注解
                        if (attachAnnotion != null) {
                            if (obj instanceof List) {
                                for (Object ob : (List) obj) {
                                    dealAttachInfo(ob, attachInfos);
                                }
                            } else {
                                dealAttachInfo(obj, attachInfos);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("出现错误：" + e.getMessage() + "   location:" + e.getLocalizedMessage());
            }
        }
    }
}

package com.example.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnnoTest {

    public static void main(String[] args) throws Exception {
        PageTestVO  vo = new PageTestVO();

        AttachVO attachVO = new AttachVO();
        attachVO.setAttachId("123");
        attachVO.setName("test");
        List<AttachVO> list = new ArrayList<>();
        list.add(attachVO);
        vo.setImageVO(list);
        dealAttach(vo);
        dealAttach(list);

    }


    public static <T> void dealAttach(T t) throws Exception {
        if(t instanceof Collection){
            List tList = (ArrayList)t;
            System.out.println(tList.get(0).toString());
        }

        Class<?> tClass = t.getClass();

        Field[] fields = tClass.getDeclaredFields();
      /*  for (Field field :fields) {
            field.setAccessible(true);



            field.getType();

            System.out.println(field.getGenericType() instanceof Collection );
            System.out.println(field.getGenericType() instanceof BaseVO );

            if(field.getAnnotatedType() instanceof Collection ){
//                AttachAnnotion anno= field.getAnnotation(AttachAnnotion.class);
//                if(anno != null){
//                }
                System.out.println("111111111111");
            }

            if(field.getGenericType() instanceof BaseVO){
                System.out.println("22222");
            }


            field.getAnnotation(AttachAnnotion.class);

        }*/

    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AdminDAO.java

package com.test.spring;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

// Referenced classes of package com.test.spring:
//            MenuDTO

public class AdminDAO
{

    public AdminDAO()
    {
    }

    public List sellList()
    {
        return template.selectList("cafe.sellList");
    }

    public int addproductok(MenuDTO dto)
    {
        return template.insert("cafe.addproductok", dto);
    }

    private SqlSessionTemplate template;
}

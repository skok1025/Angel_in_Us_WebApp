// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AdminService.java

package com.test.spring;

import java.util.List;

// Referenced classes of package com.test.spring:
//            IAdminService, AdminDAO, MenuDTO

public class AdminService
    implements IAdminService
{

    public AdminService()
    {
    }

    public List sellList()
    {
        return dao.sellList();
    }

    public int addproductok(MenuDTO dto)
    {
        return dao.addproductok(dto);
    }

    private AdminDAO dao;
}

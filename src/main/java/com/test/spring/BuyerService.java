// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyerService.java

package com.test.spring;

import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.test.spring:
//            IBuyerService, BuyerDAO, MemberDTO, MenuDTO, 
//            OrderDTO

public class BuyerService
    implements IBuyerService
{

    public BuyerService()
    {
    }

    public int loginok(MemberDTO dto)
    {
        return dao.loginok(dto);
    }

    public List menulist(int iscoffee)
    {
        return dao.menulist(iscoffee);
    }

    public MenuDTO getMenu(String menuseq)
    {
        return dao.getMenu(menuseq);
    }

    public List getOptions()
    {
        return dao.getOptions();
    }

    public int gettotal(HashMap map)
    {
        return dao.gettotal(map);
    }

    public int addcart(OrderDTO dto)
    {
        return dao.addcart(dto);
    }

    public String getMemberseq(MemberDTO dto)
    {
        return dao.getMemberseq(dto);
    }

    public String getOrderSeq()
    {
        return dao.getOrderSeq();
    }

    public void addoption(HashMap map)
    {
        dao.addoption(map);
    }

    public List getOrderList(String memberseq)
    {
        return dao.getOrderList(memberseq);
    }

    public List getOptionList()
    {
        return dao.getOptionList();
    }

    public String getTotalPrice(String memberseq)
    {
        return dao.getTotalPrice(memberseq);
    }

    public int pay(String memberseq)
    {
        return dao.pay(memberseq);
    }

    public int delorder(String orderseq)
    {
        return dao.delorder(orderseq);
    }

    private BuyerDAO dao;
}

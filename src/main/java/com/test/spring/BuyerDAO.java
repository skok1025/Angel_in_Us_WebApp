// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyerDAO.java

package com.test.spring;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

// Referenced classes of package com.test.spring:
//            MenuDTO, MemberDTO, OrderDTO

public class BuyerDAO
{

    public BuyerDAO()
    {
    }

    public int loginok(MemberDTO dto)
    {
        return ((Integer)template.selectOne("cafe.loginok", dto)).intValue();
    }

    public List menulist(int iscoffee)
    {
        return template.selectList("cafe.menulist", Integer.valueOf(iscoffee));
    }

    public MenuDTO getMenu(String menuseq)
    {
        return (MenuDTO)template.selectOne("cafe.getMenu", menuseq);
    }

    public List getOptions()
    {
        return template.selectList("cafe.getOptions");
    }

    public int gettotal(HashMap map)
    {
        return ((Integer)template.selectOne("cafe.getsizeprice", map)).intValue();
    }

    public int addcart(OrderDTO dto)
    {
        return template.insert("cafe.addorder", dto);
    }

    public String getMemberseq(MemberDTO dto)
    {
        return (String)template.selectOne("cafe.getMemberseq", dto);
    }

    public String getOrderSeq()
    {
        return (String)template.selectOne("cafe.getOrderSeq");
    }

    public void addoption(HashMap map)
    {
        template.insert("cafe.addoption", map);
    }

    public List getOrderList(String memberseq)
    {
        return template.selectList("cafe.orderlist", memberseq);
    }

    public List getOptionList()
    {
        return template.selectList("cafe.getOptionList");
    }

    public String getTotalPrice(String memberseq)
    {
        return (String)template.selectOne("cafe.totalprice", memberseq);
    }

    public int pay(String memberseq)
    {
        return template.update("cafe.pay", memberseq);
    }

    public int delorder(String orderseq)
    {
        template.delete("cafe.delorderoption", orderseq);
        return template.delete("cafe.delorder", orderseq);
    }

    private SqlSessionTemplate template;
}

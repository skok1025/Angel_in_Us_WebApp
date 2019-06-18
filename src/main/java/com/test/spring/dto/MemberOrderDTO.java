// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MemberOrderDTO.java

package com.test.spring.dto;


public class MemberOrderDTO
{

    public MemberOrderDTO()
    {
    }

    public String getOrderseq()
    {
        return orderseq;
    }

    public void setOrderseq(String orderseq)
    {
        this.orderseq = orderseq;
    }

    public String getMemberid()
    {
        return memberid;
    }

    public void setMemberid(String memberid)
    {
        this.memberid = memberid;
    }

    public String getMenu()
    {
        return menu;
    }

    public void setMenu(String menu)
    {
        this.menu = menu;
    }

    public String getCount()
    {
        return count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public String getPayment()
    {
        return payment;
    }

    public void setPayment(String payment)
    {
        this.payment = payment;
    }

    public String getIspay()
    {
        return ispay;
    }

    public void setIspay(String ispay)
    {
        this.ispay = ispay;
    }

    private String orderseq;
    private String memberid;
    private String menu;
    private String count;
    private String payment;
    private String ispay;
}

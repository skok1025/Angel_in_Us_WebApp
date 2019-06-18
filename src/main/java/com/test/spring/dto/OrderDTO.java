// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrderDTO.java

package com.test.spring.dto;


public class OrderDTO
{

    public OrderDTO()
    {
    }

    public String getMenu()
    {
        return menu;
    }

    public void setMenu(String menu)
    {
        this.menu = menu;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getMenusize()
    {
        return menusize;
    }

    public void setMenusize(String menusize)
    {
        this.menusize = menusize;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

 

    public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getSeq()
    {
        return seq;
    }

    public void setSeq(String seq)
    {
        this.seq = seq;
    }

    public String getMemberseq()
    {
        return memberseq;
    }

    public void setMemberseq(String memberseq)
    {
        this.memberseq = memberseq;
    }

    public String getMenuseq()
    {
        return menuseq;
    }

    public void setMenuseq(String menuseq)
    {
        this.menuseq = menuseq;
    }

    public String getIspay()
    {
        return ispay;
    }

    public void setIspay(String ispay)
    {
        this.ispay = ispay;
    }

    public String getOrderdate()
    {
        return orderdate;
    }

    public void setOrderdate(String orderdate)
    {
        this.orderdate = orderdate;
    }

    public String getPaydate()
    {
        return paydate;
    }

    public void setPaydate(String paydate)
    {
        this.paydate = paydate;
    }

    public String toString()
    {
        return (new StringBuilder("OrderDTO [seq=")).append(seq).append(", memberseq=").append(memberseq).append(", menuseq=").append(menuseq).append(", ispay=").append(ispay).append(", orderdate=").append(orderdate).append(", paydate=").append(paydate).append("]").toString();
    }

    private String seq;
    private String memberseq;
    private String menuseq;
    private String ispay;
    private String orderdate;
    private String paydate;
    private String menusize;
    private int count;
    private String payment;
    private String menu;
    private String image;
}

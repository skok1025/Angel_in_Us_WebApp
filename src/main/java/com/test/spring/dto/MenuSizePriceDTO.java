// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MenuSizePriceDTO.java

package com.test.spring.dto;


public class MenuSizePriceDTO
{

    public MenuSizePriceDTO()
    {
    }

    public String getSeq()
    {
        return seq;
    }

    public void setSeq(String seq)
    {
        this.seq = seq;
    }

    public String getMenuseq()
    {
        return menuseq;
    }

    public void setMenuseq(String menuseq)
    {
        this.menuseq = menuseq;
    }

    public String getMenusize()
    {
        return menusize;
    }

    public void setMenusize(String menusize)
    {
        this.menusize = menusize;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    private String seq;
    private String menuseq;
    private String menusize;
    private int price;
}

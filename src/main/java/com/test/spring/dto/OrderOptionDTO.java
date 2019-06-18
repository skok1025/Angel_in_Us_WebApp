// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrderOptionDTO.java

package com.test.spring.dto;


public class OrderOptionDTO
{

    public OrderOptionDTO()
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

    public String getOrderseq()
    {
        return orderseq;
    }

    public void setOrderseq(String orderseq)
    {
        this.orderseq = orderseq;
    }

    public String getOptionseq()
    {
        return optionseq;
    }

    public void setOptionseq(String optionseq)
    {
        this.optionseq = optionseq;
    }

    public String toString()
    {
        return (new StringBuilder("OrderOptionDTO [seq=")).append(seq).append(", orderseq=").append(orderseq).append(", optionseq=").append(optionseq).append("]").toString();
    }

    private String seq;
    private String orderseq;
    private String optionseq;
}

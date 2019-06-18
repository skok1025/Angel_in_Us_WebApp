// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OptionDTO.java

package com.test.spring.dto;


public class OptionDTO
{

    public OptionDTO()
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

    public String getSeq()
    {
        return seq;
    }

    public void setSeq(String seq)
    {
        this.seq = seq;
    }

    public String getOptionname()
    {
        return optionname;
    }

    public void setOptionname(String optionname)
    {
        this.optionname = optionname;
    }

    public String toString()
    {
        return (new StringBuilder("OptionDTO [seq=")).append(seq).append(", optionname=").append(optionname).append("]").toString();
    }

    private String seq;
    private String orderseq;
    private String optionname;
}

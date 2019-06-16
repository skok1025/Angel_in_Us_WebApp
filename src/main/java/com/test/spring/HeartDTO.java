// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HeartDTO.java

package com.test.spring;


public class HeartDTO
{

    public HeartDTO()
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

    public String toString()
    {
        return (new StringBuilder("HeartDTO [seq=")).append(seq).append(", memberseq=").append(memberseq).append(", menuseq=").append(menuseq).append("]").toString();
    }

    private String seq;
    private String memberseq;
    private String menuseq;
}

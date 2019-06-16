// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MemberDTO.java

package com.test.spring;


public class MemberDTO
{

    public MemberDTO()
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPw()
    {
        return pw;
    }

    public void setPw(String pw)
    {
        this.pw = pw;
    }

    public String toString()
    {
        return (new StringBuilder("MemberDTO [seq=")).append(seq).append(", id=").append(id).append(", pw=").append(pw).append("]").toString();
    }

    private String seq;
    private String id;
    private String pw;
}

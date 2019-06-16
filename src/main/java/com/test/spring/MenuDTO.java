// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MenuDTO.java

package com.test.spring;


public class MenuDTO
{

    public MenuDTO()
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

    public String getIsCoffee()
    {
        return isCoffee;
    }

    public void setIsCoffee(String isCoffee)
    {
        this.isCoffee = isCoffee;
    }

    private String seq;
    private String menu;
    private String image;
    private String isCoffee;
}

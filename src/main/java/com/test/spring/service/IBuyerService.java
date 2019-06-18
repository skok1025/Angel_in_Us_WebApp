package com.test.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.spring.dto.MemberDTO;
import com.test.spring.dto.MenuDTO;
import com.test.spring.dto.OptionDTO;
import com.test.spring.dto.OrderDTO;

public interface IBuyerService
{
  public int loginok(MemberDTO paramMemberDTO);

  public List<MenuDTO> menulist(int paramInt);

  public MenuDTO getMenu(String paramString);

  public List<OptionDTO> getOptions();

  public int gettotal(Map<String, String> paramHashMap);

  public int addcart(OrderDTO paramOrderDTO);

  public String getMemberseq(MemberDTO paramMemberDTO);

  public String getOrderSeq();

  public void addoption(Map<String, String> paramHashMap);

  public List<OrderDTO> getOrderList(String paramString);

  public List<OptionDTO> getOptionList();

  public  String getTotalPrice(String paramString);

  public int pay(String paramString);

  public int delorder(String paramString);
}
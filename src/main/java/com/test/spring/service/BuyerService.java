package com.test.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.dao.BuyerDAO;
import com.test.spring.dto.MemberDTO;
import com.test.spring.dto.MenuDTO;
import com.test.spring.dto.OptionDTO;
import com.test.spring.dto.OrderDTO;

@Service
public class BuyerService implements IBuyerService
{

  @Autowired
  private BuyerDAO dao;

  public int loginok(MemberDTO dto)
  {
    return this.dao.loginok(dto);
  }

  public List<MenuDTO> menulist(int iscoffee)
  {
    return this.dao.menulist(iscoffee);
  }

  public MenuDTO getMenu(String menuseq)
  {
    return this.dao.getMenu(menuseq);
  }

  public List<OptionDTO> getOptions()
  {
    return this.dao.getOptions();
  }

  public int gettotal(HashMap<String, String> map)
  {
    return this.dao.gettotal(map);
  }

  public int addcart(OrderDTO dto)
  {
    return this.dao.addcart(dto);
  }

  public String getMemberseq(MemberDTO dto)
  {
    return this.dao.getMemberseq(dto);
  }

  public String getOrderSeq()
  {
    return this.dao.getOrderSeq();
  }

  public void addoption(HashMap<String, String> map)
  {
    this.dao.addoption(map);
  }

  public List<OrderDTO> getOrderList(String memberseq)
  {
    return this.dao.getOrderList(memberseq);
  }

  public List<OptionDTO> getOptionList()
  {
    return this.dao.getOptionList();
  }

  public String getTotalPrice(String memberseq)
  {
    return this.dao.getTotalPrice(memberseq);
  }

  public int pay(String memberseq)
  {
    return this.dao.pay(memberseq);
  }

  public int delorder(String orderseq)
  {
    return this.dao.delorder(orderseq);
  }

@Override
public int gettotal(Map<String, String> map) {
	return this.dao.gettotal(map);
}

@Override
public void addoption(Map<String, String> map) {
	this.dao.addoption(map);
}
}
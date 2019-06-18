package com.test.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.spring.dto.MemberDTO;
import com.test.spring.dto.MenuDTO;
import com.test.spring.dto.OptionDTO;
import com.test.spring.dto.OrderDTO;

@Repository
public class BuyerDAO
{

  @Autowired
  private SqlSessionTemplate template;

  public int loginok(MemberDTO dto)
  {
    return ((Integer)this.template.selectOne("cafe.loginok", dto)).intValue();
  }

  public List<MenuDTO> menulist(int iscoffee) {
    return this.template.selectList("cafe.menulist", Integer.valueOf(iscoffee));
  }

  public MenuDTO getMenu(String menuseq) {
    return (MenuDTO)this.template.selectOne("cafe.getMenu", menuseq);
  }

  public List<OptionDTO> getOptions() {
    return this.template.selectList("cafe.getOptions");
  }

  public int gettotal(Map<String, String> map) {
    return ((Integer)this.template.selectOne("cafe.getsizeprice", map)).intValue();
  }

  public int addcart(OrderDTO dto) {
    return this.template.insert("cafe.addorder", dto);
  }

  public String getMemberseq(MemberDTO dto) {
    return (String)this.template.selectOne("cafe.getMemberseq", dto);
  }

  public String getOrderSeq() {
    return (String)this.template.selectOne("cafe.getOrderSeq");
  }

  public void addoption(Map<String, String> map) {
    this.template.insert("cafe.addoption", map);
  }

  public List<OrderDTO> getOrderList(String memberseq) {
    return this.template.selectList("cafe.orderlist", memberseq);
  }

  public List<OptionDTO> getOptionList() {
    return this.template.selectList("cafe.getOptionList");
  }

  public String getTotalPrice(String memberseq) {
    return (String)this.template.selectOne("cafe.totalprice", memberseq);
  }

  public int pay(String memberseq) {
    return this.template.update("cafe.pay", memberseq);
  }

  public int delorder(String orderseq) {
    this.template.delete("cafe.delorderoption", orderseq);
    return this.template.delete("cafe.delorder", orderseq);
  }
}
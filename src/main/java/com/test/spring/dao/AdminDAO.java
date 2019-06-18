package com.test.spring.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.spring.dto.MemberOrderDTO;
import com.test.spring.dto.MenuDTO;

@Repository
public class AdminDAO
{

  @Autowired
  private SqlSessionTemplate template;

  public List<MemberOrderDTO> sellList()
  {
    return this.template.selectList("cafe.sellList");
  }

  public int addproductok(MenuDTO dto) {
    return this.template.insert("cafe.addproductok", dto);
  }
}
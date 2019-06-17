package com.test.spring;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
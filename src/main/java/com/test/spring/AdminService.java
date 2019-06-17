package com.test.spring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService
  implements IAdminService
{

  @Autowired
  private AdminDAO dao;

  public List<MemberOrderDTO> sellList()
  {
    return this.dao.sellList();
  }

  public int addproductok(MenuDTO dto)
  {
    return this.dao.addproductok(dto);
  }
}
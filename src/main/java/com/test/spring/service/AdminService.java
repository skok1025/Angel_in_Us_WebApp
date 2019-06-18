package com.test.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.dao.AdminDAO;
import com.test.spring.dto.MemberOrderDTO;
import com.test.spring.dto.MenuDTO;

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
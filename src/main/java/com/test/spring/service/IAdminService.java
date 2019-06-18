package com.test.spring.service;

import java.util.List;

import com.test.spring.dto.MenuDTO;

public interface IAdminService {

	List sellList();

	int addproductok(MenuDTO dto);

}

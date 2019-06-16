package com.test.spring;

import java.util.HashMap;
import java.util.List;

public interface IBuyerService {

	List getOrderList(String string);

	
	String getTotalPrice(String string);

	int delorder(String orderseq);

	Object getMemberseq(MemberDTO dto);

	int loginok(MemberDTO dto);

	List menulist(int i);

	MenuDTO getMenu(String menuseq);

	int gettotal(HashMap map);

	int addcart(OrderDTO dto);

	String getOrderSeq();

	void addoption(HashMap map);

	int pay(String string);

	List getOptionList();

}

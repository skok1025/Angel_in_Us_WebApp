package com.test.spring;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BuyerController
{

  @Autowired
  private IBuyerService service;

  @Autowired
  private IAdminService adservice;

  @RequestMapping(value={"/login.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String login(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
  {
    System.out.println(req.getRealPath("/files"));
    return "login";
  }

  @RequestMapping(value={"/logincheck.action"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public int logincheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session, MemberDTO dto) {
    session.setAttribute("memberseq", this.service.getMemberseq(dto));

    return this.service.loginok(dto);
  }

  @RequestMapping(value={"/index.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
  {
    List list = this.service.menulist(1);

    req.setAttribute("list", list);
    return "index";
  }
  @RequestMapping(value={"/getmenulist.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public List<MenuDTO> getmenulist(HttpServletRequest req, HttpServletResponse resp, HttpSession session, int iscoffee) {
    return this.service.menulist(iscoffee);
  }

  @RequestMapping(value={"/view.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String menuseq) {
    MenuDTO dto = this.service.getMenu(menuseq);
    List options = this.service.getOptions();

    req.setAttribute("dto", dto);
    req.setAttribute("options", options);
    return "view";
  }
  @RequestMapping(value={"/gettotal.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public int gettotal(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String menusize, int count, String menuseq) {
    Map<String, String> map = new HashMap<String,String>();
    map.put("menusize", menusize);
    map.put("menuseq", menuseq);
    return count * service.gettotal(map);
  }
  @RequestMapping(value={"/addcart.action"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public int addcart(HttpServletRequest req, HttpServletResponse resp, HttpSession session, OrderDTO dto) { String[] optionArr = req.getParameterValues("option");
  	System.out.println("payment:"+dto.getPayment());
    System.out.println(session.getAttribute("memberseq").toString());
    dto.setMemberseq(session.getAttribute("memberseq").toString());
    int result = this.service.addcart(dto);

    String orderseq = this.service.getOrderSeq();

    Map<String,String> map = new HashMap<String,String>();

    for (String optionseq : optionArr) {
      map.put("orderseq", orderseq);
      map.put("optionseq", optionseq);
      this.service.addoption(map);
    }

    return result;
  }

  @RequestMapping(value={"/cart.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String cart(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
  {
    List orderlist = this.service.getOrderList(session.getAttribute("memberseq").toString());
    List optionlist = this.service.getOptionList();

    String totalprice = this.service.getTotalPrice(session.getAttribute("memberseq").toString());
    req.setAttribute("orderlist", orderlist);
    req.setAttribute("optionlist", optionlist);
    req.setAttribute("totalprice", totalprice);
    return "cart";
  }
  @RequestMapping(value={"/pay.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public int pay(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
    int result = this.service.pay(session.getAttribute("memberseq").toString());
    return result;
  }
  @RequestMapping(value={"/delorder.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public int delorder(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String orderseq) {
    return this.service.delorder(orderseq);
  }

  @RequestMapping(value={"/admin.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String admin(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
  {
    return "admin";
  }

  @RequestMapping(value={"/sellList.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String sellList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
    List list = this.adservice.sellList();
    req.setAttribute("list", list);
    return "sellList";
  }

  @RequestMapping(value={"/addproduct.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String addproduct(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
  {
    return "addproduct";
  }
  @RequestMapping(value={"/addproductok.action"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public int addproductok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, MenuDTO dto) {
    MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
    MultipartFile attach = multi.getFile("attach");
    String filename = getFileName(req.getRealPath("/files"), attach.getOriginalFilename());
    File filepath = new File(req.getRealPath("/files") + "\\" + filename);
    try
    {
      attach.transferTo(filepath);
    } catch (Exception e) {
      e.printStackTrace();
    }

    dto.setImage(filename);

    int result = this.adservice.addproductok(dto);

    return result;
  }
  private String getFileName(String path, String filename) {
    int n = 1;
    int index = filename.indexOf(".");
    String tempfilename = filename.substring(0, index);
    String tempExt = filename.substring(index);
    File file;
    while (true) { file = new File(path + "\\" + filename);

      if (!file.exists()) break;
      filename = tempfilename + "(" + n + ")" + tempExt;
    }
    return file.getName();
  }
}
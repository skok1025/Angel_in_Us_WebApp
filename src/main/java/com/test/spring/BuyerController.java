// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyerController.java

package com.test.spring;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

// Referenced classes of package com.test.spring:
//            IBuyerService, OrderDTO, IAdminService, MenuDTO, 
//            MemberDTO

@Controller
public class BuyerController
{

    public BuyerController()
    {
    }
    @RequestMapping("/login.action")
    public String login(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        System.out.println(req.getRealPath("/files"));
        return "login";
    }

    public int logincheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session, MemberDTO dto)
    {
        session.setAttribute("memberseq", service.getMemberseq(dto));
        return service.loginok(dto);
    }

    public String index(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        List list = service.menulist(1);
        req.setAttribute("list", list);
        return "index";
    }

    public List getmenulist(HttpServletRequest req, HttpServletResponse resp, HttpSession session, int iscoffee)
    {
        return service.menulist(iscoffee);
    }

    public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String menuseq)
    {
        MenuDTO dto = service.getMenu(menuseq);
        List options = service.getOptionList();
        req.setAttribute("dto", dto);
        req.setAttribute("options", options);
        return "view";
    }

    public int gettotal(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String menusize, int count, String menuseq)
    {
        HashMap map = new HashMap();
        map.put("menusize", menusize);
        map.put("menuseq", menuseq);
        return count * service.gettotal(map);
    }

    public int addcart(HttpServletRequest req, HttpServletResponse resp, HttpSession session, OrderDTO dto)
    {
        String optionArr[] = req.getParameterValues("option");
        System.out.println(session.getAttribute("memberseq").toString());
        dto.setMemberseq(session.getAttribute("memberseq").toString());
        int result = service.addcart(dto);
        String orderseq = service.getOrderSeq();
        HashMap map = new HashMap();
        String as[];
        int j = (as = optionArr).length;
        for(int i = 0; i < j; i++)
        {
            String optionseq = as[i];
            map.put("orderseq", orderseq);
            map.put("optionseq", optionseq);
            service.addoption(map);
        }

        return result;
    }

    public String cart(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        List orderlist = service.getOrderList(session.getAttribute("memberseq").toString());
        List optionlist = service.getOptionList();
        String totalprice = service.getTotalPrice(session.getAttribute("memberseq").toString());
        req.setAttribute("orderlist", orderlist);
        req.setAttribute("optionlist", optionlist);
        req.setAttribute("totalprice", totalprice);
        return "cart";
    }

    public int pay(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        int result = service.pay(session.getAttribute("memberseq").toString());
        return result;
    }

    public int delorder(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String orderseq)
    {
        return service.delorder(orderseq);
    }

    public String admin(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        return "admin";
    }

    public String sellList(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        List list = adservice.sellList();
        req.setAttribute("list", list);
        return "sellList";
    }

    public String addproduct(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
    {
        return "addproduct";
    }

    public int addproductok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, MenuDTO dto)
    {
        MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
        MultipartFile attach = multi.getFile("attach");
        String filename = getFileName(req.getRealPath("/files"), attach.getOriginalFilename());
        File filepath = new File((new StringBuilder(String.valueOf(req.getRealPath("/files")))).append("\\").append(filename).toString());
        try
        {
            attach.transferTo(filepath);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        dto.setImage(filename);
        int result = adservice.addproductok(dto);
        return result;
    }

    private String getFileName(String path, String filename)
    {
        int n = 1;
        int index = filename.indexOf(".");
        String tempfilename = filename.substring(0, index);
        String tempExt = filename.substring(index);
        do
        {
            File file = new File((new StringBuilder(String.valueOf(path))).append("\\").append(filename).toString());
            if(file.exists())
                filename = (new StringBuilder(String.valueOf(tempfilename))).append("(").append(n).append(")").append(tempExt).toString();
            else
                return file.getName();
        } while(true);
    }

    private IBuyerService service;
    private IAdminService adservice;
}

package com.hans.shilipiaoxiang.applet.service;
import java.util.List;
import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;

public interface backGroundService {
    CAdmin login(String username);

    List<CGoods> showGoods();
}

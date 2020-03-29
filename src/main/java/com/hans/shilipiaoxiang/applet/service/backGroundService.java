package com.hans.shilipiaoxiang.applet.service;
import java.util.List;

import com.hans.shilipiaoxiang.applet.Select.AmountResult;
import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.COrder;
import com.hans.shilipiaoxiang.applet.Select.SelectParams;

public interface backGroundService {
    CAdmin login(String username);

    List<CGoods> showGoods();

    List<AmountResult> showAmout(SelectParams selectParams);

    List<CGoods> showGoodsName(int typeId);
}

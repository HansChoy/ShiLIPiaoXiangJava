package com.hans.shilipiaoxiang.applet.service;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoodsTypes;

import java.util.List;

public interface GoodsService {

    List<CGoodsTypes> getGoods();

    CGoodsTypes getSaleGoods();

    CGoods getGoodDetail(int id);
}

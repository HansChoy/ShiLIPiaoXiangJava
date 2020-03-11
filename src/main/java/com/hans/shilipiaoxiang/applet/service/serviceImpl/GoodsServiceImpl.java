package com.hans.shilipiaoxiang.applet.service.serviceImpl;

import com.hans.shilipiaoxiang.applet.mapper.CGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.CGoodsTypesMapper;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoodsTypes;
import com.hans.shilipiaoxiang.applet.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private CGoodsTypesMapper goodsTypesMapper;
    @Autowired
    private CGoodsMapper goodsMapper;
    @Override
    public List<CGoodsTypes> getGoods() {
        List<CGoodsTypes> cGoodsTypes =goodsTypesMapper.showGoods();
        return cGoodsTypes;
    }

    @Override
    public CGoodsTypes getSaleGoods() {
        CGoodsTypes cGoodsTypes =goodsTypesMapper.showSaleGoods();
        return cGoodsTypes;
    }

    @Override
    public CGoods getGoodDetail(int id) {
        CGoods cGoods=goodsMapper.selectByPrimaryKey(id);
        return cGoods;
    }

    @Override
    public List<CGoods> getRecommentGoods() {
        List<CGoods> cGoodsList=goodsMapper.showRecommendGoods();
        return cGoodsList;
    }
}

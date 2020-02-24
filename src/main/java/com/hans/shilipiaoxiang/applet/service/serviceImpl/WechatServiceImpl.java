package com.hans.shilipiaoxiang.applet.service.serviceImpl;

import com.hans.shilipiaoxiang.applet.mapper.CShoppingCartMapper;
import com.hans.shilipiaoxiang.applet.mapper.CUserMapper;
import com.hans.shilipiaoxiang.applet.pojo.CShoppingCart;
import com.hans.shilipiaoxiang.applet.pojo.CUser;
import com.hans.shilipiaoxiang.publicservice.mapper.IStaffMapper;
import com.hans.shilipiaoxiang.publicservice.mapper.IUserMapper;
import com.hans.shilipiaoxiang.publicservice.mapper.IWeixinMapper;
import com.hans.shilipiaoxiang.publicservice.pojo.*;
import com.hans.shilipiaoxiang.applet.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WechatServiceImpl implements WechatService {
    @Autowired
    private IWeixinMapper iWeixinMapper;
    @Autowired
    private IUserMapper iUserMapper;
    @Autowired
    private IStaffMapper iStaffMapper;
    @Autowired
    private CUserMapper cUserMapper;
    @Autowired
    private CShoppingCartMapper cShoppingCartMapper;

    @Override
    public IStaff selectbyopenid(String openid) {
        IWeixinExample example=new IWeixinExample();
        IWeixinExample.Criteria criteria=example.createCriteria();
        criteria.andOpenIdEqualTo(openid);
        List<IWeixin> iWeixinList=iWeixinMapper.selectByExample(example);
        int id=iWeixinList.get(0).getId();

        IStaffExample example1=new IStaffExample();
        IStaffExample.Criteria criteria1=example1.createCriteria();
        criteria1.andWechatIdEqualTo(id);

        List<IStaff> userList=iStaffMapper.selectByExample(example1);
        return userList.get(0);

    }

    @Override
    public IUser selectuser(int userid) {
        return iUserMapper.selectByPrimaryKey(userid);
    }

    @Override
    public Boolean addusernews(int userid, String name, int gender, String country, String language, String province, String city) {
        IUser user=iUserMapper.getuser(userid);
        user.setCity(city);
        user.setCountry(country);;
        user.setGender(gender);
        user.setLanguage(language);
        user.setProvince(province);
        user.setName(name);
        iUserMapper.updateByPrimaryKeySelective(user);
        return true;
    }

    @Override
    public List<Integer> wechatLogin(String openId,CUser cUser) {
        System.out.println("2222222"+openId);
        CUser cUser1 = cUserMapper.selectByOpenId(openId);

        if (cUser1==null) {
            System.out.println("没有该用户");
            CUser cUser2=new CUser();
            cUser2.setWeixinId(openId);
            cUser2.setPhone(cUser.getPhone());
            cUser2.setName(cUser.getName());
            cUser2.setGender(cUser.getGender());
            cUser2.setCountry(cUser.getCountry());
            cUser2.setLanguage(cUser.getLanguage());
            cUser2.setProvince(cUser.getProvince());
            cUser2.setCity(cUser.getCountry());
            cUserMapper.insert(cUser2);
            int userId=cUser2.getId();
            CShoppingCart cShoppingCart=new CShoppingCart();
            cShoppingCart.setWxId(openId);
            cShoppingCart.setPrice(0.00);
            cShoppingCart.setTotal(0);
            cShoppingCartMapper.insert(cShoppingCart);
            int cartId=cShoppingCart.getId();
            List<Integer> list=new ArrayList<>();
            list.add(userId);
            list.add(cartId);
            return list;
        }
        else {
            System.out.println("已存在");
            int userId = cUser1.getId();
            List<Integer> list=new ArrayList<>();
            list.add(userId);
            CShoppingCart cart=cShoppingCartMapper.selectByOpenId(openId);
            list.add(cart.getId());
            return list;
        }
    }

    @Override
    public int userid(String openid) {
        IWeixinExample example=new IWeixinExample();
        IWeixinExample.Criteria criteria=example.createCriteria();
        criteria.andOpenIdEqualTo(openid);
        List<IWeixin> iWeixinList=iWeixinMapper.selectByExample(example);
        int id=iWeixinList.get(0).getId();

        IUserExample example1=new IUserExample();
        IUserExample.Criteria criteria1=example1.createCriteria();
        criteria1.andWeixinIdEqualTo(id);

        List<IUser> userList=iUserMapper.selectByExample(example1);
        int userid=userList.get(0).getId();
        return userid;


    }

    @Override
    public String havaphone(int userid) {

        System.out.println("用户id"+userid);
        IUser user=iUserMapper.getuser(userid);



        System.out.println("用户电话为:"+user.getPhone());
        if("".equals(user.getPhone())||user.getPhone()==null){
            System.out.println("电话为空！！");
            return "false";
        }else{
            System.out.println("电话不为空");
            return "true";
        }
    }


    @Override
    public Boolean addphone(int userid, String phone) {
        IUser user=iUserMapper.selectByPrimaryKey(userid);
        user.setPhone(phone);
        iUserMapper.updateByPrimaryKeySelective(user);
        return true;
    }
}

package edu.hebeu.steam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hebeu.steam.common.page.ColumnFilter;
import edu.hebeu.steam.common.page.PageRequest;
import edu.hebeu.steam.common.page.PageResult;
import edu.hebeu.steam.mapper.UserMapper;
import edu.hebeu.steam.pojo.Sys.SysUser;
import edu.hebeu.steam.service.UserService;
import edu.hebeu.steam.util.baseutil.DESUtil;
import edu.hebeu.steam.util.baseutil.MailSenderInfo;
import edu.hebeu.steam.util.baseutil.PasswordUtil;
import edu.hebeu.steam.util.SimpleMailSender;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {


    @Override
    public boolean save(SysUser record) {
        Long id = null;
        if(record.getId() == null || record.getId() == 0) {
            // 新增用户
            super.save(record);
            id = record.getId();
        } else {
            // 更新用户信息
            updateById(record);
        }
        return true;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        PageResult pageResult = null;
        String name = getColumnFilterValue(pageRequest, "name");
        String email = getColumnFilterValue(pageRequest, "email");
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            queryWrapper.eq(SysUser::getName, name);
            if(!StringUtils.isEmpty(email)) {
                queryWrapper.eq(SysUser::getEmail, email);
            }
        }
        IPage<SysUser> result = baseMapper.selectPage(page, queryWrapper);
        pageResult = new PageResult(result);
        return pageResult;
    }

    @Override
    public SysUser findById(Long userId) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getId, userId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public SysUser findByName(String userName) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getName, userName);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public void updateLoginTime(SysUser user) {
        user.setLastUpdateTime(new Date());
        updateById(user);
    }

    /**
     * 获取过滤字段的值
     * @param filterName
     * @return
     */
    public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
        String value = null;
        ColumnFilter columnFilter = pageRequest.getColumnFilters().get(filterName);
        if(columnFilter != null) {
            value = columnFilter.getValue();
        }
        return value;
    }

    @Override
    public void createUser(SysUser user) {
        user.setCreateTime(new Date());
        PasswordUtil.encryptPassword(user);
        save(user);
    }




    @Override
    public int delete(List<SysUser> users) {
        for (SysUser user : users) {
            removeById(user.getId());
        }
        return 1;
    }

    @Override
    public boolean beginPasswdReset(String useremail, String newpass) throws Exception {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getEmail, useremail);
        SysUser userBean = baseMapper.selectOne(wrapper);
        if(userBean == null)
        {
            return false;
        }
        //二次加密密码
        userBean.setPassword(newpass);
        PasswordUtil.encryptPassword(userBean);
        this.save(userBean);
        return true;
    }



    @Override
    public boolean sendPasswdReset(String userEmail) throws Exception {
        //获取当前时间并转换
        Date now = new Date();
        String currentTime = "" + now.getTime();
        //拼凑成找回密码的链接
        String plainText = currentTime + "$" + userEmail; // 当前时间加上用户邮箱 使用$进行连接二者，在大多数情况下不会产生歧义
        String desKey = "CONSTRUCTIONCOMPLETE"; // des算法中的密钥
        String link = DESUtil.encrypt(desKey, plainText);//加密后的链接
        //调用发送请求进行发送
        try
        {
            MailSenderInfo mailInfo = new MailSenderInfo();
            mailInfo.setMailServerHost("smtp.163.com");
            mailInfo.setMailServerPort("25");
            mailInfo.setValidate(true);
            mailInfo.setUserName("firehomework@163.com");
            mailInfo.setPassword("DHVTIYMUHSVDCKOX");//您的邮箱密码
            mailInfo.setFromAddress("firehomework@163.com");
            mailInfo.setToAddress(userEmail);
            mailInfo.setSubject("找回密码");
            mailInfo.setContent("您好！请在两小时内，填写该验证码，进行密码重置" + "\n" + link );
            SimpleMailSender sms = new SimpleMailSender();
            SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public String checkCodeValid(String code)
    {
        //获取传入参数
        long checktime = 7200000;
        //验证验证码是否过期（设置一个开关让它可以100%的失败）
        try
        {
            Date now = new Date();
            String p = DESUtil.decrypt("CONSTRUCTIONCOMPLETE", code);
            System.out.println("-----------解密后的key参数---------------------");
            System.out.println(p);
            String[] checklist = p.split("\\$");
            long time = Long.parseLong(checklist[0]);
            if(now.getTime() - time > checktime)
            {
                //时间超出推算
                System.out.println("已经过期");
                return null;
            }
            return checklist[1];
        }
        catch (Exception e){
            return null;
        }
    }




}

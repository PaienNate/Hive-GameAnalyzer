package edu.hebeu.steam.util.satoken;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import edu.hebeu.steam.pojo.Login.LoginBean;
import edu.hebeu.steam.pojo.Sys.SysUser;
import edu.hebeu.steam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.dev33.satoken.stp.StpInterface;

/**
 * 自定义权限认证接口扩展，Sa-Token 将从此实现类获取每个账号拥有的权限码
 *
 * @author kong
 * @since 2022-10-13
 */
@Component	// 打开此注解，保证此类被springboot扫描，即可完成sa-token的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    UserService userService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        //由于我们知道loginId就是LoginBean所以可以根据这个获取信息
        LoginBean loginBean = (LoginBean) JSON.toJavaObject((JSON)JSON.parse((String)loginId),LoginBean.class);
        String name = loginBean.getName();
        SysUser user = userService.findByName(name);
        List<String> list = new ArrayList<>();
        //管理员的权限十分的大（确信）
        if("admin".equals(user.getName()))
        {
            list.add("*");
            return list;
        }
        else
        {
            if(user.getStatus() == 1)
            {
                list.add("user.vip");
                return list;
            }
        }
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 没用到，不写了，大家都是管理员捏
        List<String> list = new ArrayList<String>();
        list.add("admin");
        return list;
    }

}

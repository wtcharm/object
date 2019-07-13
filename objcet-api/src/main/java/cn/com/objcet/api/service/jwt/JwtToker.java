package cn.com.objcet.api.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import cn.com.objcet.api.service.config.User;
/**
 * jwt操作类
 * @author Administrator
 *
 */
public class JwtToker {

	/**
	 * 进行token的生成
	 * @param user
	 * @return
	 */
	public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
	
	/**
	 * 获取userId
	 * @param token
	 * @return
	 */
	public String  getUserId(String token) {
		String userId = JWT.decode(token).getAudience().get(0);
		return userId;
	}
}

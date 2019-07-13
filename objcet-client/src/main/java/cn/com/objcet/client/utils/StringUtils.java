package cn.com.objcet.client.utils;


import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 类型处理工具
 *
 * @author qi_grui
 */
public class StringUtils {


    /**
     * 判断对象空
     *
     * @param obj
     * @return
     */
  
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
        if(obj instanceof List){
            return isListEmpty((List) obj);
        }
        return obj == null || "".equals(obj) || "null".equals(obj);
    }

    /**
     * 判断对象非空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判读list集合空
     *
     * @param list
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static boolean isListEmpty(List list){
        return list == null || list.isEmpty();
    }

    /**
     * 手机号正则验证
     *
     * @param phone
     * @return boolean
     */
    public static boolean checkPhone(String phone) {
        return Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$").matcher(phone).matches();
    }

    /**
     * email验证
     *
     * @param email
     * @return boolean
     */
    public static boolean checkEmail(String email) {
        return Pattern.compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}").matcher(email).matches();
    }

    /**
     * 中文校验
     *
     * @param value
     * @return boolean
     */
    public static boolean checkChinese(String value) {
        return Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(value).matches();
    }

    /**
     * 数字校验
     *
     * @param number
     * @return boolean
     */
    public static boolean checkNumber(String number) {
        if(isEmpty(number)){
            return false;
        }
        return Pattern.compile("^\\d+(\\.\\d+)?$").matcher(number).matches();
    }

    /**
     * 身份证校验
     *
     * @param idcard
     * @return boolean
     */
    public static boolean checkIdCard(String idcard) {
        return Pattern.compile("^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$").matcher(idcard).matches();
    }

    /**
     * 判断BigDecimal类型值是否不同
     *
     * @param expected
     * @param actual
     * @return
     */
    public static boolean bigDecimalIsDifferent(BigDecimal expected , BigDecimal actual){
        return expected.compareTo(actual) == 0;
    }

    /**
     * 判读字符串的最大长度
     *
     * @param str
     * @param length
     * @return
     */
    public static boolean StringMax(String str, int length) {
        if (isEmpty(str) || str.length() > length) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 设置json中null的字段为空串
     *
     * @param json
     * @param keys
     * @return
     */
    public static JSONObject setJsonNullToEmpty(JSONObject json, String[] keys) {
        for (String key : keys) {
            if (StringUtils.isEmpty(json.get(key))) {
                json.put(key, "");
            }
        }
        return json;
    }

    /**
     * 使用zip进行压缩
     * @param str 压缩前的文本
     * @return 返回压缩后的文本
     */
    @SuppressWarnings("restriction")
	public static final String zip(String str) {
        if (str == null)
            return null;
        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        String compressedStr = null;
        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
            compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);
        } catch (IOException e) {
            compressed = null;
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return compressedStr;
    }

    /**
     * 使用zip进行解压缩
     * @param compressedStr 压缩后的文本
     * @return 解压后的字符串
     */
    public static final String unzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed = null;
        try {
            @SuppressWarnings("restriction")
			byte[] compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            decompressed = null;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }

    /**
     *  匿名手机号
     *
     * @param phone
     * @return
     */
    public static String getAnonymousPhone(String phone){
        if (isEmpty(phone)) {
            return "";
        }
        if (!checkPhone(phone)) {
            return phone;
        }
        phone = phone.substring(0,3) + "****" + phone.substring(7);
        return phone;

    }


    public static List<String> getListByStringSplit(String strings,String split){
        if (strings != null && !"".equals(strings)) {
            String[] sp = strings.split(split);
            List<String> list = new ArrayList<>();
            for (String s : sp) {
                list.add(s);
            }
            return list;
        } else {
            return null;
        }
    }
    public static List<Integer> getListIntByStringSplit(String strings,String split){
        if (strings != null && !"".equals(strings)) {
            String[] sp = strings.split(split);
            List<Integer> list = new ArrayList<Integer>();
            for (String s : sp) {
                list.add(Integer.parseInt(s));
            }
            return list;
        } else {
            return null;
        }
    }

    public static String getAnonymousName(String name) {
        if (isEmpty(name)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(name.substring(0,1));
        sb.append("**");
        return sb.toString();
    }

    /**
     *  获取请求参数的map
     * @return
     */
    public static Map<String, String> getRequestParams(String params){
        Map<String, String> map = new HashMap<>();
        if (isEmpty(params)) {
            return null;
        }
        String[] arr = params.split("&");
        for (String param : arr) {
            String[] str = param.split("=");
            map.put(str[0], str[1]);
        }
        return map;
    }

}

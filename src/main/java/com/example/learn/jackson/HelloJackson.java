package com.example.learn.jackson;

import com.example.learn.jackson.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * 本类功能:
 *
 * @author chenchong
 * @date 2020/12/2 19:44
 */
public class HelloJackson {
    /**
     * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
     * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
     * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
     * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
     * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
     * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
     */
    /**
     * 将实体类转换成json字符串  - 序列化
     * @param user
     * @return
     * @throws JsonProcessingException
     */
    public static String entityToJson(User user) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }

    /**
     * 将集合转换为json字符串
     * @param userList
     * @return
     * @throws JsonProcessingException
     */
    public static String listToJson(List<User> userList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonList = mapper.writeValueAsString(userList);
        return jsonList;
    }

    /**
     * 将json字符串转换为实体类  -  json的反序列化
     * @param json
     * @return
     * @throws JsonProcessingException
     */
    public static User jsonToEntity(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, User.class);
    }

    // json数组 -> 对象数组
//    TwitterEntry[] twitterEntryArray = mapper.readValue(jsonArrayStr, TwitterEntry[].class);
//        logger.info("json数组反序列化成对象数组：{}", Arrays.toString(twitterEntryArray));

    // json数组 -> 对象集合
//    List<TwitterEntry> twitterEntryList = mapper.readValue(jsonArrayStr, new TypeReference<List<TwitterEntry>>() {});
//        logger.info("json数组反序列化成对象集合：{}", twitterEntryList);





}

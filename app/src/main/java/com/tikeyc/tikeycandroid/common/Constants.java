package com.tikeyc.tikeycandroid.common;

/**
 * Created by public1 on 2017/1/10.
 */

public class Constants {


    /**
     * 视频json数据接口
     *
     * 映客直播列表：http://116.211.167.106/api/live/aggregation?uid=133825214&interest=1
     */
    public static final String VIDEO_NET_URL = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    /**
     * 视频直播json数据接口
     *
     * 映客直播列表：http://116.211.167.106/api/live/aggregation?uid=133825214&interest=1
     */
    public static final String YINGKE_VIDEO_NET_URL = "http://116.211.167.106/api/live/aggregation?uid=133825214&interest=1";


    /**
     * 视频直播json数据接口
     *
     */
    public static final String LIVE_VIDEO_NET_URL = "http://appdemo.download.ks-cdn.com:8882/api/GetLiveUrl/2017-01-01?Option=1";

    /**
     * 来自百思不得姐
     *
     * */
    public static final String AUDIO_NET_URL = "http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.2.8/0-20.json?market=baidu&udid=86342502659959&appname=baisibudejie&os=4.2.2&client=android&visiting=&mac=98%3Ac%3Af5%3A4b%3A72%3A6d&ver=6.2.2";


    /**
     * 美女福利
     * http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
     */
    public static final String PIC_SEX = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    /**
     * @param number 一页请求的个数
     * @param page 请求第几页
     * @return
     */
    public static String getPIC_SEX(int number, int page) {
        return PIC_SEX + number + "/" + page;
    }
}

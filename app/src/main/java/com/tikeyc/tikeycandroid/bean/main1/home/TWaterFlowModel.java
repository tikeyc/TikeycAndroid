package com.tikeyc.tikeycandroid.bean.main1.home;

import java.util.List;

/**
 * Created by tikeyc on 2017/10/30.
 * GitHub：https://github.com/tikeyc
 */

public class TWaterFlowModel {


    /**
     * error : false
     * results : [{"_id":"59f2aabb421aa90fef2034d5","createdAt":"2017-10-27T11:40:43.793Z","desc":"10-27","publishedAt":"2017-10-27T12:02:30.376Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171027114026_v8VFwP_joanne_722_27_10_2017_11_40_17_370.jpeg","used":true,"who":"daimajia"},{"_id":"59f0054a421aa90fe2f02bf4","createdAt":"2017-10-25T11:30:18.697Z","desc":"2017-10-25","publishedAt":"2017-10-25T11:39:10.950Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg","used":true,"who":"代码家"},{"_id":"59ee8adf421aa90fe50c019b","createdAt":"2017-10-24T08:35:43.61Z","desc":"10-24","publishedAt":"2017-10-24T11:50:49.1Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171024083526_Hq4gO6_bluenamchu_24_10_2017_8_34_28_246.jpeg","used":true,"who":"代码家"},{"_id":"59ed70a4421aa90fef2034bc","createdAt":"2017-10-23T12:31:32.639Z","desc":"10-23","publishedAt":"2017-10-23T12:44:23.660Z","source":"chrome","type":"福利","url":"https://img.gank.io/anri.kumaki_23_10_2017_12_27_30_151.jpg","used":true,"who":"代码家"},{"_id":"59e6aadf421aa90fef2034a0","createdAt":"2017-10-18T09:14:07.966Z","desc":"10-18","publishedAt":"2017-10-20T10:26:24.673Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171018091347_Z81Beh_nini.nicky_18_10_2017_9_13_35_727.jpeg","used":true,"who":"代码家"},{"_id":"59deaa0c421aa90fe7253583","createdAt":"2017-10-12T07:32:28.644Z","desc":"10-13","publishedAt":"2017-10-17T13:10:43.731Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171012073213_p4H630_joycechu_syc_12_10_2017_7_32_7_433.jpeg","used":true,"who":"daimajia"},{"_id":"59dea9cf421aa90fef203477","createdAt":"2017-10-12T07:31:27.363Z","desc":"10-12","publishedAt":"2017-10-16T12:19:20.311Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171012073108_0y12KR_anri.kumaki_12_10_2017_7_30_58_141.jpeg","used":true,"who":"daimajia"},{"_id":"59dd6a91421aa90fef20346c","createdAt":"2017-10-11T08:49:21.485Z","desc":"10-11","publishedAt":"2017-10-11T12:40:42.545Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20171011084856_0YQ0jN_joanne_722_11_10_2017_8_39_5_505.jpeg","used":true,"who":"代码家"},{"_id":"59dc4ec1421aa94e04c2adca","createdAt":"2017-10-10T12:38:25.180Z","desc":"1","publishedAt":"2017-10-10T12:41:34.882Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-10-10-sakura.gun_10_10_2017_12_33_34_751.jpg","used":true,"who":"daimajia"},{"_id":"59caf6bb421aa972845f2099","createdAt":"2017-09-27T08:54:19.73Z","desc":"9-27","publishedAt":"2017-10-09T13:07:56.458Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fjxu5qqdjoj20qo0xc0wk.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59f2aabb421aa90fef2034d5
         * createdAt : 2017-10-27T11:40:43.793Z
         * desc : 10-27
         * publishedAt : 2017-10-27T12:02:30.376Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/20171027114026_v8VFwP_joanne_722_27_10_2017_11_40_17_370.jpeg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}

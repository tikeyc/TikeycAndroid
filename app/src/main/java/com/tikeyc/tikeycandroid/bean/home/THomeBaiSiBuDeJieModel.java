package com.tikeyc.tikeycandroid.bean.home;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by public1 on 2017/6/14.
 */

public class THomeBaiSiBuDeJieModel {


    private InfoBean info;
    private List<ListBean> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }


    public static class InfoBean {
        /**
         * count : 4497
         * np : 1508970301
         */

        private int count;
        private int np;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getNp() {
            return np;
        }

        public void setNp(int np) {
            this.np = np;
        }
    }

    public static class ListBean implements MultiItemEntity {

        public static final int TYPE_VIDEO = 0;
        public static final int TYPE_IMAGE = 1;
        public static final int TYPE_GIF = 2;
        public static final int TYPE_TEXT = 3;
        public static final int TYPE_AD = 4;

        private int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        /**
         * status : 4
         * comment : 23
         * tags : [{"post_number":49750,"image_list":"http://img.spriteapp.cn/ugc/2017/08/cf0389c28c6111e7b08e842b2b4c75ab.png","forum_sort":0,"forum_status":2,"id":473,"info":"槽点满满的社会事件 ","name":"社会新闻","colum_set":1,"tail":"名小记者","sub_number":114625,"display_level":0}]
         * bookmark : 21
         * text : 风水有用吗？？啥是风水宝地？？
         * up : 207
         * share_url : http://a.f.budejie.com/share/26676541.html?wx.qq.com
         * down : 6
         * forward : 46
         * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/11/30/583ea6a451bf8_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/11/30/583ea6a451bf8_mini.jpg"],"uid":"19764726","is_vip":false,"is_v":false,"room_url":"","room_name":"","room_role":"","room_icon":"","name":"xuezuoren"}
         * passtime : 2017-10-26 09:57:01
         * video : {"playfcount":366,"height":450,"width":800,"video":["http://wvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.mp4","http://bvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.mp4"],"download":["http://wvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpdm.mp4","http://bvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpdm.mp4","http://dvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpdm.mp4"],"duration":131,"playcount":3019,"thumbnail":["http://wimg.spriteapp.cn/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg","http://dimg.spriteapp.cn/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg"],"thumbnail_small":["http://wimg.spriteapp.cn/crop/150x150/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg","http://dimg.spriteapp.cn/crop/150x150/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg"]}
         * type : video
         * id : 26676541
         * top_comments : [{"voicetime":0,"status":0,"hate_count":0,"cmt_type":"text","precid":0,"content":"哦，斜特，法克！","like_count":34,"u":{"header":["http://wimg.spriteapp.cn/profile/large/2016/10/15/5801bafb90462_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/10/15/5801bafb90462_mini.jpg"],"uid":"7790971","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"你开奔驰我挖鼻屎"},"preuid":0,"passtime":"2017-10-25 11:59:43","voiceuri":"","id":92217103},{"voicetime":0,"status":0,"hate_count":0,"cmt_type":"text","precid":0,"content":"兄弟，你还健在吗？","like_count":14,"u":{"header":["http://wimg.spriteapp.cn/profile/large/2017/01/04/586cf7b0c788b_mini.jpg","http://dimg.spriteapp.cn/profile/large/2017/01/04/586cf7b0c788b_mini.jpg"],"uid":"19992952","is_vip":false,"room_url":"","sex":"f","room_name":"","room_role":"","room_icon":"","name":"淑女的太子奶"},"preuid":0,"passtime":"2017-10-25 12:07:15","voiceuri":"","id":92217428},{"voicetime":0,"status":0,"hate_count":0,"cmt_type":"text","precid":0,"content":"撒币啊，为毛不丢女兵澡堂?","like_count":5,"u":{"header":["http://wimg.spriteapp.cn/profile/large/2017/06/15/594246e18e059_mini.jpg","http://dimg.spriteapp.cn/profile/large/2017/06/15/594246e18e059_mini.jpg"],"uid":"19534278","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"采菇凉的小魔骨"},"preuid":0,"passtime":"2017-10-25 17:25:42","voiceuri":"","id":92230840}]
         * gif : {"images":["http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5.gif","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5.gif"],"width":188,"gif_thumbnail":["http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg"],"download_url":["http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_d.jpg","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_d.jpg","http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg"],"height":307}
         * image : {"medium":[],"big":["http://wimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_1.jpg"],"download_url":["http://wimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_d.jpg","http://dimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_d.jpg","http://wimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a.jpg","http://dimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a.jpg"],"height":33706,"width":1080,"small":[],"thumbnail_small":["http://wimg.spriteapp.cn/crop/150x150/ugc/2017/10/18/59e6c0775452a.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2017/10/18/59e6c0775452a.jpg"]}
         */

        private int status;
        private String comment;
        private String bookmark;
        private String text;
        private String up;
        private String share_url;
        private int down;
        private int forward;
        private UBean u;
        private String passtime;
        private VideoBean video;
        private String type;
        private String id;
        private GifBean gif;
        private ImageBean image;
        private List<TagsBean> tags;
        private List<TopCommentsBean> top_comments;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public int getForward() {
            return forward;
        }

        public void setForward(int forward) {
            this.forward = forward;
        }

        public UBean getU() {
            return u;
        }

        public void setU(UBean u) {
            this.u = u;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public GifBean getGif() {
            return gif;
        }

        public void setGif(GifBean gif) {
            this.gif = gif;
        }

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<TopCommentsBean> getTop_comments() {
            return top_comments;
        }

        public void setTop_comments(List<TopCommentsBean> top_comments) {
            this.top_comments = top_comments;
        }

        public static class UBean {
            /**
             * header : ["http://wimg.spriteapp.cn/profile/large/2016/11/30/583ea6a451bf8_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/11/30/583ea6a451bf8_mini.jpg"]
             * uid : 19764726
             * is_vip : false
             * is_v : false
             * room_url :
             * room_name :
             * room_role :
             * room_icon :
             * name : xuezuoren
             */

            private String uid;
            private boolean is_vip;
            private boolean is_v;
            private String room_url;
            private String room_name;
            private String room_role;
            private String room_icon;
            private String name;
            private List<String> header;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public boolean isIs_v() {
                return is_v;
            }

            public void setIs_v(boolean is_v) {
                this.is_v = is_v;
            }

            public String getRoom_url() {
                return room_url;
            }

            public void setRoom_url(String room_url) {
                this.room_url = room_url;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getRoom_role() {
                return room_role;
            }

            public void setRoom_role(String room_role) {
                this.room_role = room_role;
            }

            public String getRoom_icon() {
                return room_icon;
            }

            public void setRoom_icon(String room_icon) {
                this.room_icon = room_icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getHeader() {
                return header;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }
        }

        public static class VideoBean {
            /**
             * playfcount : 366
             * height : 450
             * width : 800
             * video : ["http://wvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.mp4","http://bvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.mp4"]
             * download : ["http://wvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpdm.mp4","http://bvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpdm.mp4","http://dvideo.spriteapp.cn/video/2017/1025/59f04bb66b0d5cutblackcutblack_wpdm.mp4"]
             * duration : 131
             * playcount : 3019
             * thumbnail : ["http://wimg.spriteapp.cn/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg","http://dimg.spriteapp.cn/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg"]
             * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg","http://dimg.spriteapp.cn/crop/150x150/picture/2017/1025/59f04bb66b0d5cutblackcutblack_wpd.jpg"]
             */

            private int playfcount;
            private int height;
            private int width;
            private int duration;
            private int playcount;
            private List<String> video;
            private List<String> download;
            private List<String> thumbnail;
            private List<String> thumbnail_small;

            public int getPlayfcount() {
                return playfcount;
            }

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public List<String> getVideo() {
                return video;
            }

            public void setVideo(List<String> video) {
                this.video = video;
            }

            public List<String> getDownload() {
                return download;
            }

            public void setDownload(List<String> download) {
                this.download = download;
            }

            public List<String> getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(List<String> thumbnail) {
                this.thumbnail = thumbnail;
            }

            public List<String> getThumbnail_small() {
                return thumbnail_small;
            }

            public void setThumbnail_small(List<String> thumbnail_small) {
                this.thumbnail_small = thumbnail_small;
            }
        }

        public static class GifBean {
            /**
             * images : ["http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5.gif","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5.gif"]
             * width : 188
             * gif_thumbnail : ["http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg"]
             * download_url : ["http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_d.jpg","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_d.jpg","http://wimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/10/25/59efeaf4d6fe5_a_1.jpg"]
             * height : 307
             */

            private int width;
            private int height;
            private List<String> images;
            private List<String> gif_thumbnail;
            private List<String> download_url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public List<String> getGif_thumbnail() {
                return gif_thumbnail;
            }

            public void setGif_thumbnail(List<String> gif_thumbnail) {
                this.gif_thumbnail = gif_thumbnail;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }
        }

        public static class ImageBean {
            /**
             * medium : []
             * big : ["http://wimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_1.jpg"]
             * download_url : ["http://wimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_d.jpg","http://dimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a_d.jpg","http://wimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a.jpg","http://dimg.spriteapp.cn/ugc/2017/10/18/59e6c0775452a.jpg"]
             * height : 33706
             * width : 1080
             * small : []
             * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/ugc/2017/10/18/59e6c0775452a.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2017/10/18/59e6c0775452a.jpg"]
             */

            private int height;
            private int width;
            private List<?> medium;
            private List<String> big;
            private List<String> download_url;
            private List<?> small;
            private List<String> thumbnail_small;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<?> getMedium() {
                return medium;
            }

            public void setMedium(List<?> medium) {
                this.medium = medium;
            }

            public List<String> getBig() {
                return big;
            }

            public void setBig(List<String> big) {
                this.big = big;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

            public List<?> getSmall() {
                return small;
            }

            public void setSmall(List<?> small) {
                this.small = small;
            }

            public List<String> getThumbnail_small() {
                return thumbnail_small;
            }

            public void setThumbnail_small(List<String> thumbnail_small) {
                this.thumbnail_small = thumbnail_small;
            }
        }

        public static class TagsBean {
            /**
             * post_number : 49750
             * image_list : http://img.spriteapp.cn/ugc/2017/08/cf0389c28c6111e7b08e842b2b4c75ab.png
             * forum_sort : 0
             * forum_status : 2
             * id : 473
             * info : 槽点满满的社会事件
             * name : 社会新闻
             * colum_set : 1
             * tail : 名小记者
             * sub_number : 114625
             * display_level : 0
             */

            private int post_number;
            private String image_list;
            private int forum_sort;
            private int forum_status;
            private int id;
            private String info;
            private String name;
            private int colum_set;
            private String tail;
            private int sub_number;
            private int display_level;

            public int getPost_number() {
                return post_number;
            }

            public void setPost_number(int post_number) {
                this.post_number = post_number;
            }

            public String getImage_list() {
                return image_list;
            }

            public void setImage_list(String image_list) {
                this.image_list = image_list;
            }

            public int getForum_sort() {
                return forum_sort;
            }

            public void setForum_sort(int forum_sort) {
                this.forum_sort = forum_sort;
            }

            public int getForum_status() {
                return forum_status;
            }

            public void setForum_status(int forum_status) {
                this.forum_status = forum_status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getColum_set() {
                return colum_set;
            }

            public void setColum_set(int colum_set) {
                this.colum_set = colum_set;
            }

            public String getTail() {
                return tail;
            }

            public void setTail(String tail) {
                this.tail = tail;
            }

            public int getSub_number() {
                return sub_number;
            }

            public void setSub_number(int sub_number) {
                this.sub_number = sub_number;
            }

            public int getDisplay_level() {
                return display_level;
            }

            public void setDisplay_level(int display_level) {
                this.display_level = display_level;
            }
        }

        public static class TopCommentsBean {
            /**
             * voicetime : 0
             * status : 0
             * hate_count : 0
             * cmt_type : text
             * precid : 0
             * content : 哦，斜特，法克！
             * like_count : 34
             * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/10/15/5801bafb90462_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/10/15/5801bafb90462_mini.jpg"],"uid":"7790971","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"你开奔驰我挖鼻屎"}
             * preuid : 0
             * passtime : 2017-10-25 11:59:43
             * voiceuri :
             * id : 92217103
             */

            private int voicetime;
            private int status;
            private int hate_count;
            private String cmt_type;
            private int precid;
            private String content;
            private int like_count;
            private UBeanX u;
            private int preuid;
            private String passtime;
            private String voiceuri;
            private int id;

            public int getVoicetime() {
                return voicetime;
            }

            public void setVoicetime(int voicetime) {
                this.voicetime = voicetime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getHate_count() {
                return hate_count;
            }

            public void setHate_count(int hate_count) {
                this.hate_count = hate_count;
            }

            public String getCmt_type() {
                return cmt_type;
            }

            public void setCmt_type(String cmt_type) {
                this.cmt_type = cmt_type;
            }

            public int getPrecid() {
                return precid;
            }

            public void setPrecid(int precid) {
                this.precid = precid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public UBeanX getU() {
                return u;
            }

            public void setU(UBeanX u) {
                this.u = u;
            }

            public int getPreuid() {
                return preuid;
            }

            public void setPreuid(int preuid) {
                this.preuid = preuid;
            }

            public String getPasstime() {
                return passtime;
            }

            public void setPasstime(String passtime) {
                this.passtime = passtime;
            }

            public String getVoiceuri() {
                return voiceuri;
            }

            public void setVoiceuri(String voiceuri) {
                this.voiceuri = voiceuri;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public static class UBeanX {
                /**
                 * header : ["http://wimg.spriteapp.cn/profile/large/2016/10/15/5801bafb90462_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/10/15/5801bafb90462_mini.jpg"]
                 * uid : 7790971
                 * is_vip : false
                 * room_url :
                 * sex : m
                 * room_name :
                 * room_role :
                 * room_icon :
                 * name : 你开奔驰我挖鼻屎
                 */

                private String uid;
                private boolean is_vip;
                private String room_url;
                private String sex;
                private String room_name;
                private String room_role;
                private String room_icon;
                private String name;
                private List<String> header;

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public boolean isIs_vip() {
                    return is_vip;
                }

                public void setIs_vip(boolean is_vip) {
                    this.is_vip = is_vip;
                }

                public String getRoom_url() {
                    return room_url;
                }

                public void setRoom_url(String room_url) {
                    this.room_url = room_url;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getRoom_name() {
                    return room_name;
                }

                public void setRoom_name(String room_name) {
                    this.room_name = room_name;
                }

                public String getRoom_role() {
                    return room_role;
                }

                public void setRoom_role(String room_role) {
                    this.room_role = room_role;
                }

                public String getRoom_icon() {
                    return room_icon;
                }

                public void setRoom_icon(String room_icon) {
                    this.room_icon = room_icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<String> getHeader() {
                    return header;
                }

                public void setHeader(List<String> header) {
                    this.header = header;
                }
            }
        }
    }
}

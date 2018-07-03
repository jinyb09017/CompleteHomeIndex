package com.abbott.longhomeindex.model;

import java.util.List;

/**
 * @author jyb jyb_96@sina.com on 2018/6/29.
 * @version V1.0
 * @Description: add comment
 * @date 16-4-21 11:21
 * @copyright www.tops001.com
 */

public class HomeBean {

    /**
     *
     * AppTravelIndexDTO {
     headUrl (string, optional): 旅居首页头部图片地址 ,
     appTravelRecommendIndexDTOS (Array[AppTravelRecommendIndexDTO], optional): 首页旅居推荐集合 ,
     appTravelHotTowIndexDTOS (Array[AppTravelHotTowIndexDTO], optional): 首页热门城市2集合 ,
     appTravelHotCityIndexDTOS (Array[AppTravelHotCityIndexDTO], optional): 首页热门城市集合 ,
     appTravelBrokerIndexDTOS (Array[AppletsBrokerDTO], optional): 旅居管家集合 ,
     appTravelHotLineIndexDTOS (Array[HotLineDTO], optional): 首页热门路线集合 ,
     appTravelLectureIndexDTOS (Array[LectureDTO], optional): 在线开讲集合
     }
     AppTravelRecommendIndexDTO {
     contentId (integer, optional): 主键ID ,
     indexUrl (string, optional): 索引图地址 ,
     viewType (integer, optional): 类型，普通详情页（无图片--2，有图片--1），视频详情页--3,跳转到H5--4,不做操作--5 ,
     jumpUrl (string, optional): 链接地址
     }
     AppTravelHotTowIndexDTO {
     cityId (integer, optional): 城市ID ,
     cityName (string, optional): 城市名称 ,
     thumbnailUrl (string, optional): 城市缩略图地址 ,
     viewType (integer, optional): 类型，普通详情页（无图片--2，有图片--1），视频详情页--3,跳转到H5--4,不做操作--5
     }
     AppTravelHotCityIndexDTO {
     cityName (string, optional): 热点城市名称 ,
     summary (string, optional): 热点城市摘要 ,
     detail (string, optional): 热点城市描述 ,
     subList (Array[AppTravelSubHotCityIndexDTO], optional): 城市列表 ,
     viewType (integer, optional): 类型，普通详情页（无图片--2，有图片--1），视频详情页--3,跳转到H5--4,不做操作--5
     }
     AppletsBrokerDTO {
     infoId (integer, optional): 管家主键 ,
     brokerName (string, optional): 管家名称 ,
     brokerTitle (string, optional): 管家标题 ,
     shortTitle (string, optional): 管家短标题 ,
     avatarUrl (string, optional): 管家头像
     }
     HotLineDTO {
     contentId (integer, optional): 主键ID ,
     indexUrl (string, optional): 索引图地址 ,
     lineName (string, optional): 路线特点名称 ,
     summary (string, optional): 路线摘要 ,
     detail (string, optional): 路线内容 ,
     price (string, optional): 路线价格 ,
     jumpUrl (string, optional): 路线详情调整地址
     }
     LectureDTO {
     lectureId (integer, optional): 在线课程ID ,
     lectureTitle (string, optional): 在线课程标题 ,
     thumbnailUrl (string, optional): 在线课程缩略图
     }
     AppTravelSubHotCityIndexDTO {
     contentId (integer, optional): 主键ID ,
     indexUrl (string, optional): 索引图地址 ,
     viewType (integer, optional): 类型，普通详情页（无图片--2，有图片--1），视频详情页--3,跳转到H5--4,不做操作--5 ,
     jumpUrl (string, optional): 链接地址 ,
     keywords (string, optional): 城市摘要
     }
     *
     *
     */


    /**
     * headUrl : string
     * appTravelRecommendIndexDTOS : [{"contentId":0,"indexUrl":"string","viewType":0,"jumpUrl":"string"}]
     * appTravelHotTowIndexDTOS : [{"cityId":0,"cityName":"string","thumbnailUrl":"string","viewType":0}]
     * appTravelHotCityIndexDTOS : [{"cityName":"string","summary":"string","detail":"string","subList":[{"contentId":0,"indexUrl":"string","viewType":0,"jumpUrl":"string","keywords":"string"}],"viewType":0}]
     * appTravelBrokerIndexDTOS : [{"infoId":0,"brokerName":"string","brokerTitle":"string","shortTitle":"string","avatarUrl":"string"}]
     * appTravelHotLineIndexDTOS : [{"contentId":0,"indexUrl":"string","lineName":"string","summary":"string","detail":"string","price":"string","jumpUrl":"string"}]
     * appTravelLectureIndexDTOS : [{"lectureId":0,"lectureTitle":"string","thumbnailUrl":"string"}]
     */

    private String headUrl;
    /**
     * contentId : 0
     * indexUrl : string
     * viewType : 0
     * jumpUrl : string
     */

    private List<AppTravelRecommendIndexDTOSBean> appTravelRecommendIndexDTOS;
    /**
     * cityId : 0
     * cityName : string
     * thumbnailUrl : string
     * viewType : 0
     */

    private List<AppTravelHotTowIndexDTOSBean> appTravelHotTowIndexDTOS;
    /**
     * cityName : string
     * summary : string
     * detail : string
     * subList : [{"contentId":0,"indexUrl":"string","viewType":0,"jumpUrl":"string","keywords":"string"}]
     * viewType : 0
     */

    private List<AppTravelHotCityIndexDTOSBean> appTravelHotCityIndexDTOS;
    /**
     * infoId : 0
     * brokerName : string
     * brokerTitle : string
     * shortTitle : string
     * avatarUrl : string
     */

    private List<AppTravelBrokerIndexDTOSBean> appTravelBrokerIndexDTOS;
    /**
     * contentId : 0
     * indexUrl : string
     * lineName : string
     * summary : string
     * detail : string
     * price : string
     * jumpUrl : string
     */

    private List<AppTravelHotLineIndexDTOSBean> appTravelHotLineIndexDTOS;
    /**
     * lectureId : 0
     * lectureTitle : string
     * thumbnailUrl : string
     */

    private List<AppTravelLectureIndexDTOSBean> appTravelLectureIndexDTOS;

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public List<AppTravelRecommendIndexDTOSBean> getAppTravelRecommendIndexDTOS() {
        return appTravelRecommendIndexDTOS;
    }

    public void setAppTravelRecommendIndexDTOS(List<AppTravelRecommendIndexDTOSBean> appTravelRecommendIndexDTOS) {
        this.appTravelRecommendIndexDTOS = appTravelRecommendIndexDTOS;
    }

    public List<AppTravelHotTowIndexDTOSBean> getAppTravelHotTowIndexDTOS() {
        return appTravelHotTowIndexDTOS;
    }

    public void setAppTravelHotTowIndexDTOS(List<AppTravelHotTowIndexDTOSBean> appTravelHotTowIndexDTOS) {
        this.appTravelHotTowIndexDTOS = appTravelHotTowIndexDTOS;
    }

    public List<AppTravelHotCityIndexDTOSBean> getAppTravelHotCityIndexDTOS() {
        return appTravelHotCityIndexDTOS;
    }

    public void setAppTravelHotCityIndexDTOS(List<AppTravelHotCityIndexDTOSBean> appTravelHotCityIndexDTOS) {
        this.appTravelHotCityIndexDTOS = appTravelHotCityIndexDTOS;
    }

    public List<AppTravelBrokerIndexDTOSBean> getAppTravelBrokerIndexDTOS() {
        return appTravelBrokerIndexDTOS;
    }

    public void setAppTravelBrokerIndexDTOS(List<AppTravelBrokerIndexDTOSBean> appTravelBrokerIndexDTOS) {
        this.appTravelBrokerIndexDTOS = appTravelBrokerIndexDTOS;
    }

    public List<AppTravelHotLineIndexDTOSBean> getAppTravelHotLineIndexDTOS() {
        return appTravelHotLineIndexDTOS;
    }

    public void setAppTravelHotLineIndexDTOS(List<AppTravelHotLineIndexDTOSBean> appTravelHotLineIndexDTOS) {
        this.appTravelHotLineIndexDTOS = appTravelHotLineIndexDTOS;
    }

    public List<AppTravelLectureIndexDTOSBean> getAppTravelLectureIndexDTOS() {
        return appTravelLectureIndexDTOS;
    }

    public void setAppTravelLectureIndexDTOS(List<AppTravelLectureIndexDTOSBean> appTravelLectureIndexDTOS) {
        this.appTravelLectureIndexDTOS = appTravelLectureIndexDTOS;
    }

    public static class AppTravelRecommendIndexDTOSBean {
        private int contentId;
        private String indexUrl;
        private int viewType;
        private String jumpUrl;

        public int getContentId() {
            return contentId;
        }

        public void setContentId(int contentId) {
            this.contentId = contentId;
        }

        public String getIndexUrl() {
            return indexUrl;
        }

        public void setIndexUrl(String indexUrl) {
            this.indexUrl = indexUrl;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }
    }

    public static class AppTravelHotTowIndexDTOSBean {
        private int cityId;
        private String cityName;
        private String thumbnailUrl;
        private int viewType;

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }
    }

    public static class AppTravelHotCityIndexDTOSBean {
        private String cityName;
        private String summary;
        private String detail;
        private int viewType;
        /**
         * contentId : 0
         * indexUrl : string
         * viewType : 0
         * jumpUrl : string
         * keywords : string
         */

        private List<SubListBean> subList;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }

        public List<SubListBean> getSubList() {
            return subList;
        }

        public void setSubList(List<SubListBean> subList) {
            this.subList = subList;
        }

        public static class SubListBean {
            private int contentId;
            private String indexUrl;
            private int viewType;
            private String jumpUrl;
            private String keywords;

            public int getContentId() {
                return contentId;
            }

            public void setContentId(int contentId) {
                this.contentId = contentId;
            }

            public String getIndexUrl() {
                return indexUrl;
            }

            public void setIndexUrl(String indexUrl) {
                this.indexUrl = indexUrl;
            }

            public int getViewType() {
                return viewType;
            }

            public void setViewType(int viewType) {
                this.viewType = viewType;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }
        }
    }

    public static class AppTravelBrokerIndexDTOSBean {
        private int infoId;
        private String brokerName;
        private String brokerTitle;
        private String shortTitle;
        private String avatarUrl;

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public String getBrokerName() {
            return brokerName;
        }

        public void setBrokerName(String brokerName) {
            this.brokerName = brokerName;
        }

        public String getBrokerTitle() {
            return brokerTitle;
        }

        public void setBrokerTitle(String brokerTitle) {
            this.brokerTitle = brokerTitle;
        }

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }

    public static class AppTravelHotLineIndexDTOSBean {
        private int contentId;
        private String indexUrl;
        private String lineName;
        private String summary;
        private String detail;
        private String price;
        private String jumpUrl;

        public int getContentId() {
            return contentId;
        }

        public void setContentId(int contentId) {
            this.contentId = contentId;
        }

        public String getIndexUrl() {
            return indexUrl;
        }

        public void setIndexUrl(String indexUrl) {
            this.indexUrl = indexUrl;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }
    }

    public static class AppTravelLectureIndexDTOSBean {
        private int lectureId;
        private String lectureTitle;
        private String thumbnailUrl;

        public int getLectureId() {
            return lectureId;
        }

        public void setLectureId(int lectureId) {
            this.lectureId = lectureId;
        }

        public String getLectureTitle() {
            return lectureTitle;
        }

        public void setLectureTitle(String lectureTitle) {
            this.lectureTitle = lectureTitle;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }
    }
}

import ac.cn.lz233.dslson.element.json
import ac.cn.lz233.dslson.utils.ReformatJsonUtil

fun main(args: Array<String>) {
    val json = json {
        element {
            int("result", 0)
            array("feedList") {
                element {
                    string("coverUrl", "https://tx-free-imgs.acfun.cn/o_1f4mqn7kl1son1abrbjo37t1jib0.jpeg?imageslim")
                    string("caption", "【官方双语】听没听说过这三种接头？ #电子速谈")
                    string("videoId", "24106930")
                    int("videoSizeType", 1)
                    string("playDuration", "04:14")
                    boolean("disableThrowBanana", false)
                    element("coverImgInfo") {
                        int("width", 0)
                        int("height", 0)
                        int("size", 0)
                        int("type", 0)
                        element("thumbnailImage") {
                            array("cdnUrls") {
                                element {
                                    string("url", "https://tx-free-imgs.acfun.cn/o_1f4mqn7kl1son1abrbjo37t1jib0.jpeg?imageslim")
                                    boolean("freeTrafficCdn", false)
                                }
                            }
                        }
                    }
                    element("channel") {
                        int("parentId", 70)
                        string("parentName", "科技")
                        string("name", "数码")
                        int("id", 91)
                    }
                    int("shareCount", 0)
                    int("stowCount", 18)
                    int("bananaCount",11)
                    int("viewCount",986)
                    int("commentCount",0)
                    string("shareUrl","https://m.acfun.cn/v/?ac=28431903")
                    element("user"){
                        string("userHead","https://tx-free-imgs.acfun.cn/style/image/201907/bSGlA8GDc9mmD6Hkhluu79i5s3c9d6H9.jpg?imageslim")
                        boolean("isFollowing",true)
                    }
                }
            }
        }
    }
    println(ReformatJsonUtil.stringToJson(json))
}
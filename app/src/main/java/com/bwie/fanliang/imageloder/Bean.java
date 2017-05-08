package com.bwie.fanliang.imageloder;

import java.util.List;

/**
 * Created by fanliang on 2017/4/20.
 */

public class Bean {


    /**
     * ret_code : 200
     * ret_msg : ok
     * list : [{"date":"5小时前","id":1,"pic":"http://img1.imgtn.bdimg.com/it/u=1794894692,1423685501&fm=23&gp=0.jpg","title":" \n军改后军级阵容首次曝光，六位将军特别亮相","type":1},{"date":"2小时前","id":2,"pic":"http://img2.imgtn.bdimg.com/it/u=819201812,3553302270&fm=214&gp=0.jpg","title":"明星和岳父的合影曝光：吴奇隆刘强东真尴尬，王祖蓝真心不容易~","type":1},{"date":"3小时前","id":5,"pic":"http://pic28.nipic.com/20130424/11588775_115415688157_2.jpg","title":" \n中国女乒惨败，孔令辉向日本低头认输，却遭刘国梁一语打脸","type":1},{"date":"4小时前","id":6,"pic":"http://pic7.nipic.com/20100517/3409334_180613088650_2.jpg|http://pic9.nipic.com/20100820/2531170_182750402288_2.jpg|http://pic1a.nipic.com/2008-10-07/20081079019381_2.jpg","title":" \n北京的你再忙也要加一下这个投资微信！不然后悔！","type":2},{"date":"9分钟前","id":14,"pic":"http://p3.pstatp.com/list/190x124/1bf6000d3aa7569f07e4","title":" \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居\n \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居\n \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居","type":1},{"date":"9分钟前","id":15,"pic":"http://p3.pstatp.com/list/190x124/1c5c000661637502e36b|http://p3.pstatp.com/list/190x124/1c5f0005465e52ee0fe1|http://p1.pstatp.com/list/190x124/1c5f0005465fb4ec1c29","title":"2块钱一个馍，吃一口一生难忘！","type":2},{"date":"1分钟前","id":18,"pic":"http://p3.pstatp.com/list/190x124/e5900054f8a11fc5960","title":"深圳男子被吃脑虫入侵去世，哪些食物最危险含寄生虫?","type":1},{"date":"2小时前","id":19,"pic":"http://p9.pstatp.com/list/190x124/ef7000c2947b313fe05","title":" \n为什么越来越多的人会选择关闭朋友圈？","type":1},{"date":"9小时前","id":20,"pic":"http://p1.pstatp.com/list/190x124/18a10004f6a0fb66f371","title":" \n100万元人民币的现金到底有多重？","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    private List<ListBean> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 5小时前
         * id : 1
         * pic : http://img1.imgtn.bdimg.com/it/u=1794894692,1423685501&fm=23&gp=0.jpg
         * title :
         军改后军级阵容首次曝光，六位将军特别亮相
         * type : 1
         */

        private String date;
        private int id;
        private String pic;
        private String title;
        private int type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}

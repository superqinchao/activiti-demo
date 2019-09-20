package com.example.lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/7/29 14:17
 */
public class LambdaTest {

    @Test
    public void test1() {
//        Instant status = Instant.now();
//        Long sum = LongStream.rangeClosed(0, 100000000000L)
//                .sequential()
//                .reduce(0, Long::sum);
//        Instant end = Instant.now();
//        System.out.println("耗时为：" + Duration.between(status, end).toMillis());
//        Optional.ofNullable(null).isPresent();
//        Callable<Date> date = () -> {
//            return new Date();
//        };

//        DateTimeFormatter lat = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
//        LocalDateTime lo = LocalDateTime.now();
//        String l = lat.format(lo);
//        System.out.println(lat );
//        System.out.println(lo);
//        System.out.println(l);
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);
//        String zoneTime = lat.format(zonedDateTime);
//        System.out.println(zoneTime);

        Map<String, Object> map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key5", 'h');
        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        List<String> list1 = Lists.newArrayList();
        List<Object> list2 = Lists.newArrayList();
        map.forEach((k, v) -> {
            list1.add(k);
            list2.add(v);
        });
        list1.forEach(System.out::println);
        list2.forEach(System.out::println);
    }


    @Test
    public void test2() throws Exception {
        String s = "尊敬的各位领导：\n" +
                "        您们好！\n" +
                "        我自入职公司以来已有一年多的时间了，一直以来我都以认真饱满的热情投入于工作学习中，当然有很多不懂的问题全靠了同事的帮助和亚萍姐、曾总的耐心教导，我很感激！所以我一直尽最大的努力去做好，以便不辜负同事和领导对我的一片厚爱。虽然比起以前来我进步收获很多，但是还是有很多东西值得我去学习。\n" +
                "       从一开始在橙鹰到现在公司平台的一名PM，我非常感激亚萍姐给我的机会，我一直都很珍惜着这里的一切。用我的业绩去报答您们！\n" +
                "       以前总听说外包公司缺少了自研公司的那种归属感，可来汉克之后实实在在的让我感受到工作四年来从未有的家的感觉，从亚萍姐，曾总身上感受的长辈的关爱以及教导，这是漂泊在外工作的一种幸福。我很尊重您们。作为公司大家庭中的一员，我深感荣幸！虽然我不是一个很能干的人，但是我是一个很真诚，踏实的人！无论待人待物我是真诚的，我有信心去做好公司领导交给我的事情，去处理和同事，客户的关系。不辜负领导的一番苦心~这些都是我的内心真实的想法，还有很多没能写出来，但是在我心里一直都怀揣这一颗感恩的心，感谢您们！\n" +
                "       我相信，有要付出、就会有收获。作为公司的一名PM，我一直都是兢兢业业的付出着，在做好我本职工作的情况下，我也很热情的去帮助同事，因为我知道无论是我还是同事，我们都是为了公司服务，只要尽我的一份力量把公司交代的事情完成做好，想想公司领导的厚爱，我觉得自己更加应该努力工作！我是义不容辞，心甘情愿的去努力为公司付出。故此我提出这份加薪申请，原薪资：15K/月，申请先工资为：18K/月.希望公司领导能批准我的请求！\n" +
                "       如果公司领导对我现在的工作内容及质量还未做到更好，我诚恳的希望您能提出宝贵的意见或建议，让我能更好的为公司效力，也让我今后有一个努力的方向和目标，在提升自己能力的同时将工作做的更好，向更高的目标迈进。\n" +
                "       此敬\n" +
                "       敬礼！\n" +
                "                                                                                                                                                                                                申请人：秦超\n" +
                "                                                                                                                                                                                                2019年8月19日";
        System.out.println("字符串的总长度:" + s.length());//显示字符串长度

        System.out.println("字符串中汉字长度：" + getChineseCount(s)); //调用方法显示汉字长度

        System.out.println(getStringInfo(s));                       //调用方法显示其它字母类型的长度

    }

    public static boolean isChineseChar(char c) throws Exception {//判断是否是一个汉字
        return String.valueOf(c).getBytes("GBK").length > 1;//汉字的字节数大于1
    }

    public static int getChineseCount(String s) throws Exception {//获得汉字的长度
        char c;
        int chineseCount = 0;
        if (!"".equals("")) {//判断是否为空
            s = new String(s.getBytes(), "GBK");   //进行统一编码
        }
        for (int i = 0; i < s.length(); i++) {//for循环
            c = s.charAt(i);              //获得字符串中的每个字符
            if (isChineseChar(c)) {//调用方法进行判断是否是汉字
                chineseCount++;                 //等同于chineseCount=chineseCount+1
            }
        }
        return chineseCount;                   //返回汉字个数
    }

    public static String getStringInfo(String s) {//获得字母、数字、空格的个数
        char ch;
        int character = 0, blank = 0, number = 0;
        for (int i = 0; i < s.length(); i++) {    //for循环
            ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))//统计字母
                character++; //等同于character=character+1
            else if (ch == ' ')                         //统计空格
                blank++; //等同于blank=blank+1
            else if (ch >= '0' && ch <= '9')                //统计数字
                number++; //等同于number=number+1;
        }
        return "字符串中共有" + character + "个字母," + blank + "个空格," + number + "个数字";
    }
}

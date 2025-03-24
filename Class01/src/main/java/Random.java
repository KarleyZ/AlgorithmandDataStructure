public class Random {
    public static void main(String[] args) {
        //这次我们来学习一下Math.random()随机数的知识 。
        /*
        * 1.该数返回【0,1)上的随机数，而且是等概率，出现0.3的概率就是0.3
        * 2.Math.random()*K返回[0,K)上的随机数
        * 3.如何返回[0,K)上的数,但得到K的概率是K^2
        * */
        int k =4;
        double ans = Math.max(Math.random() *4,Math.random() *4);

        //从1-5的随机返回1~7的随机
        //1.将1~5转成0/1概率发生器，1,2返回0,3重做，4，5返回1
        //2.此时计算需要3个二进制位返回0~7才能包括0~6上的数
        //3.从新获取0~6上的等概率，到7就重做
        //1~7的概率就是0~6的概率再加1
        //验证打印数组，i出现一次对应位置的下标的数组值+1
        int counts[] = new int[8];
        for (int i = 0; i < 10000; i++) {
            int num = g();
            counts[num]++;
        }
        for (int i = 0; i <8 ; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        //从此a~b的随机数获得等概率的m~n
        //1.将a~b分为0/1等概率器
        //2.计算0~n-m需要x位2进制，多位二进制左移相加
        //3.计算0~2^x的概率，将超过n-m位的进行重新做
        //4.3步得到的概率+m

    }
    //1.将1~5转成0/1概率发生器，1,2返回0,3重做，4，5返回1
    public static int f1(){
        int ans;
        do {
            ans = (int)(Math.random()*5) + 1;//返回[0,4]上的整数 [0~5) ->[0,4]+1 ->[1,5]
        }while (ans == 3);
        return ans;
    }

    public static int f2(){
        return f1() <3 ? 0 :1;
    }
    //2.此时计算需要3个二进制位返回0~7才能包括0~6上的数
    public static int f3(){
        return (f2() << 2) + (f2() << 1) +f2();//返回从000~111个数，每个数发生概率是1/8
    }
    //3.从新获取0~6上的等概率，到7就重做
    public static int f4(){
        int ans;
        do {
            ans = f3();
        }while (ans == 7);
        return ans;
    }
    //1~7的概率就是0~6的概率再加1
    public static int g(){
        return f4() +1;
    }
}

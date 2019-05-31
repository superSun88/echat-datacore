package sun.echat.domain;
public class Const{
    private static String[] nickNames={"莫依琳","苏云漓","夏诗语","云梦瑶","叶璇姬","南宫雪","夜云阑","纳兰樱甯","凤华君"+
    "君辰煜","墨凌君","风黎漠","卫倾云","凰邪天","姬玄昱","莫云南"+
    "聂云儿","朱沉玲","许馨馨","洛冰浔","冷千灵","苏沁","岳霜儿"+
    "叶星枫","百里云天","纳兰侍栾","苏澈","简竹"};

    public static String getRandomNickName(){
        int size = nickNames.length;
        int index = (int)(Math.random()*size);
        return nickNames[index];
    }

    public static void main(String[] args) {
        
       System.out.println( Const.getRandomNickName());
    }
}
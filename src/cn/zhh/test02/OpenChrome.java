package cn.zhh.test02;

/**
 * Debug模式打开浏览器
 *
 * @author z_hh
 */
public class OpenChrome {

    public static void main(String[] args) {
        try{
            Runtime.getRuntime().exec("chrome.exe --remote-debugging-port=9527 --user-data-dir=\"C:/selenum/AutomationProfile\"");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

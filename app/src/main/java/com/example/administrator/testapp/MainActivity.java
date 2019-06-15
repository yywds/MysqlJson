package com.example.administrator.testapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mysql.jdbc.Statement;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

   private Button bt_show;
   private TextView tv_show;
   private ImageView img_show;
   private TextView tv_sqlshow;

   //在主线程中更新UI
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 0x12:
                    String s = (String) msg.obj;
                    tv_sqlshow.setText(s); //显示数据库中的数据
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_show = findViewById(R.id.img_view);
        bt_show = findViewById(R.id.dianji);
        tv_show = findViewById(R.id.tv_text);
        tv_sqlshow =findViewById(R.id.tv_mysqlshow);
        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                   Message message = handler.obtainMessage();
                        try {
                            Class.forName(Constant.FORNAME);
                            java.sql.Connection cn= DriverManager.getConnection(Constant.MYSQLBASE_URL,"root","123456");
                            String sql="select sname from student";
                            Statement st=(Statement)cn.createStatement();
                            ResultSet rs=st.executeQuery(sql);
                            while(rs.next()){
                                String mybook=rs.getString("sname");
                                Log.i("Mainactivity",mybook);
                                message.what = 0x12;
                                message.obj = mybook;
                            }
                            cn.close();
                            st.close();
                            rs.close();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        // 发消息通知主线程更新UI
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });

        getDataFromNet();//联网请求数据

    }

    //联网请求数据
    private void getDataFromNet() {
        RequestParams requestParams = new RequestParams(Constant.INDEX_URL);//请求网络地址
        x.http().get(requestParams, new Callback.CommonCallback<String>() {  //回调
            @Override
            public void onSuccess(String result) {
                Toast.makeText(MainActivity.this,"请求成功",Toast.LENGTH_LONG).show();
//                LogUtil.e("请求成功" + result);
                processData(result);//解析json数据和显示json数据
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(MainActivity.this,"请求失败",Toast.LENGTH_LONG).show();
//                LogUtil.e("请求失败" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_LONG).show();
//                LogUtil.e("取消" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Toast.makeText(MainActivity.this,"完成",Toast.LENGTH_LONG).show();
//                LogUtil.e("完成");
            }
        });
    }

    //解析json数据和显示json数据
    private void processData(String json) {
        NetDataBean bean = parsedJson(json);
       String name = bean.getProInfo().getName();
       String img = bean.getProInfo().getUrl();
       tv_show.setText(name); //显示产品名称
        Glide.with(this).load(img).into(img_show);//使用Glide框架显示图片
    }

    //使用Gson解析Json数据
    private NetDataBean parsedJson(String json) {
        Gson gson = new Gson();
        NetDataBean bean = gson.fromJson(json, NetDataBean.class);
        return bean;
    }
}

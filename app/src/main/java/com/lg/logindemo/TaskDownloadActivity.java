package com.lg.logindemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.lg.logindemo.taskDownload.CheckPermissionsActivity;
import com.lg.logindemo.taskDownload.DownLoadManager;
import com.lg.logindemo.taskDownload.DownLoadService;
import com.lg.logindemo.taskDownload.adapter.ListAdapter;

/**
 * Created by sunyi on 2017/8/21.
 */

public class TaskDownloadActivity extends CheckPermissionsActivity {
    private Button addbutton;
    private Button userbutton;
    private ListView listview;
    private EditText nameText;
    private EditText urlText;
    private ListAdapter adapter;

    /*使用DownLoadManager时只能通过DownLoadService.getDownLoadManager()的方式来获取下载管理器，不能通过new DownLoadManager()的方式创建下载管理器*/
    private DownLoadManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.download_activity_main);

        //下载管理器需要启动一个Service,在刚启动应用的时候需要等Service启动起来后才能获取下载管理器，所以稍微延时获取下载管理器
        handler.sendEmptyMessageDelayed(1, 50);

        listview = (ListView) this.findViewById(R.id.listView);

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            /*获取下载管理器*/
            manager = DownLoadService.getDownLoadManager();
            Log.i("TaskDownload", "11111handleMessage: " + (manager == null));
            /*设置用户ID，客户端切换用户时可以显示相应用户的下载任务*/
            manager.changeUser("luffy");
            /*断点续传需要服务器的支持，设置该项时要先确保服务器支持断点续传功能*/
            manager.setSupportBreakpoint(true);
            adapter = new ListAdapter(TaskDownloadActivity.this, manager);
            listview.setAdapter(adapter);
            userbutton.setText("用户 : " + manager.getUserID());
        }
    };
}

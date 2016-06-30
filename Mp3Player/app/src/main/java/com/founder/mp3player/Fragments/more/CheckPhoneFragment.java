package com.founder.mp3player.Fragments.more;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.founder.mp3player.R;
import com.founder.mp3player.event.ShowFragmentEvent;
import com.founder.mp3player.event.ToastShowEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by xieyanbin on 15/7/24.
 */
public class  CheckPhoneFragment extends ContentFragment implements View.OnClickListener{
    View root;
    EditText phoneNum;
    EditText vertifivationCode;
    EditText recommandPerson;
    TextView sendVertificationcode;
    TextView next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_more_checkphone,container,false);
        initView(root);
        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateTitle(R.string.title_validate);
    }

    private void initView(View root) {
        phoneNum=(EditText)root.findViewById(R.id.et_phoneNum);
        vertifivationCode=(EditText)root.findViewById(R.id.et_vertifivationCode);
        recommandPerson=(EditText)root.findViewById(R.id.et_recommandPerson);
        sendVertificationcode=(TextView)root.findViewById(R.id.tv_sendVertificationcode);
        next=(TextView)root.findViewById(R.id.tv_next);
        sendVertificationcode.setOnClickListener(this);//发送验证码事件
        next.setOnClickListener(this);
        initSubtitle(root,R.id.tv_checkPhone);//设置当前的开户进程
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_next:next();break;//显示下一个Fragment
            case R.id.tv_sendVertificationcode:send();break;//发送短信到输入的号码
            default:break;
        }
    }

    private void send() {
        //发送短信到指定号码
        String number=this.phoneNum.getText().toString();
        if(number.isEmpty()){
            EventBus.getDefault().post(new ToastShowEvent("请输入手机号码"));
        }else {
            String content="123";
            SmsManager manager=SmsManager.getDefault();
            ArrayList<String> texts=manager.divideMessage(content);
            for (String text:texts){
                manager.sendTextMessage(number,null,text,null,null);
            }
            //发布短信发送事件
            //订阅短信接受事件
            //本地应用接受短信
        }
    }

    public void next() {
        EventBus.getDefault().post(new ShowFragmentEvent(new SelectDepartmentFragment()));
    }

}
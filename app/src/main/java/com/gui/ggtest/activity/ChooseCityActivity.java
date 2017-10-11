package com.gui.ggtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gui.ggtest.R;
import com.gui.ggtest.adapter.CityChooseRecyclerAdapter;
import com.gui.ggtest.view.SideBar;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by GGG on 2017/10/11.
 */

public class ChooseCityActivity extends Activity{
    //样例数据
    public String data = "{\"datas\":{\"A\":[{\"id\":\"21012\",\"name\":\"安阳市\"},{\"id\":\"21308\",\"name\":\"安庆市\"},{\"id\":\"21623\",\"name\":\"阿坝\"},{\"id\":\"21803\",\"name\":\"鞍山市\"},{\"id\":\"21913\",\"name\":\"阿拉善盟\"},{\"id\":\"22013\",\"name\":\"安康市\"},{\"id\":\"22304\",\"name\":\"安顺市\"},{\"id\":\"22907\",\"name\":\"阿勒泰\"},{\"id\":\"22911\",\"name\":\"阿克苏\"},{\"id\":\"23002\",\"name\":\"阿里地区\"}],\"B\":[{\"id\":\"20311\",\"name\":\"宝山区\"},{\"id\":\"20833\",\"name\":\"滨州市\"},{\"id\":\"20909\",\"name\":\"保定市\"},{\"id\":\"21305\",\"name\":\"蚌埠市\"},{\"id\":\"21616\",\"name\":\"巴中市\"},{\"id\":\"21812\",\"name\":\"本溪市\"},{\"id\":\"21903\",\"name\":\"包头市\"},{\"id\":\"21916\",\"name\":\"巴彦淖尔\"},{\"id\":\"22004\",\"name\":\"宝鸡市\"},{\"id\":\"22105\",\"name\":\"保山市\"},{\"id\":\"22204\",\"name\":\"北海市\"},{\"id\":\"22212\",\"name\":\"百色市\"},{\"id\":\"22308\",\"name\":\"毕节地区\"},{\"id\":\"22507\",\"name\":\"白山市\"},{\"id\":\"22513\",\"name\":\"白城市\"},{\"id\":\"22607\",\"name\":\"白银市\"},{\"id\":\"22710\",\"name\":\"白沙\"},{\"id\":\"22714\",\"name\":\"保亭\"},{\"id\":\"22909\",\"name\":\"博尔塔拉\"},{\"id\":\"22910\",\"name\":\"巴音郭楞\"}],\"C\":[{\"id\":\"10400\",\"name\":\"重庆市\"},{\"id\":\"20103\",\"name\":\"崇文区\"},{\"id\":\"20105\",\"name\":\"朝阳区\"},{\"id\":\"20113\",\"name\":\"昌平区\"},{\"id\":\"20304\",\"name\":\"长宁区\"},{\"id\":\"20319\",\"name\":\"崇明县\"},{\"id\":\"20513\",\"name\":\"潮州市\"},{\"id\":\"20613\",\"name\":\"常州市\"},{\"id\":\"20905\",\"name\":\"承德市\"},{\"id\":\"20914\",\"name\":\"沧州市\"},{\"id\":\"21201\",\"name\":\"长沙市\"},{\"id\":\"21210\",\"name\":\"常德市\"},{\"id\":\"21213\",\"name\":\"郴州市\"},{\"id\":\"21309\",\"name\":\"池州市\"},{\"id\":\"21316\",\"name\":\"滁州市\"},{\"id\":\"21601\",\"name\":\"成都市\"},{\"id\":\"21706\",\"name\":\"长治市\"},{\"id\":\"21816\",\"name\":\"朝阳市\"},{\"id\":\"21904\",\"name\":\"赤峰市\"},{\"id\":\"22110\",\"name\":\"楚雄\"},{\"id\":\"22215\",\"name\":\"崇左市\"},{\"id\":\"22501\",\"name\":\"长春市\"},{\"id\":\"22708\",\"name\":\"澄迈县\"},{\"id\":\"22711\",\"name\":\"昌江\"},{\"id\":\"22908\",\"name\":\"昌吉\"},{\"id\":\"23004\",\"name\":\"昌都地区\"}],\"D\":[{\"id\":\"20101\",\"name\":\"东城区\"},{\"id\":\"20114\",\"name\":\"大兴区\"},{\"id\":\"20504\",\"name\":\"东莞市\"},{\"id\":\"20810\",\"name\":\"东营市\"},{\"id\":\"20812\",\"name\":\"德州市\"},{\"id\":\"21029\",\"name\":\"邓州市\"},{\"id\":\"21609\",\"name\":\"德阳市\"},{\"id\":\"21621\",\"name\":\"达州市\"},{\"id\":\"21703\",\"name\":\"大同市\"},{\"id\":\"21802\",\"name\":\"大连市\"},{\"id\":\"21808\",\"name\":\"丹东市\"},{\"id\":\"22102\",\"name\":\"迪庆\"},{\"id\":\"22114\",\"name\":\"大理\"},{\"id\":\"22115\",\"name\":\"德宏\"},{\"id\":\"22402\",\"name\":\"大庆市\"},{\"id\":\"22414\",\"name\":\"大兴安岭\"},{\"id\":\"22609\",\"name\":\"定西市\"},{\"id\":\"22705\",\"name\":\"东方市\"},{\"id\":\"22706\",\"name\":\"定安县\"},{\"id\":\"22725\",\"name\":\"儋州市\"}],\"E\":[{\"id\":\"21105\",\"name\":\"鄂州市\"},{\"id\":\"21114\",\"name\":\"恩施\"},{\"id\":\"21902\",\"name\":\"鄂尔多斯\"}],\"F\":[{\"id\":\"20106\",\"name\":\"丰台区\"},{\"id\":\"20110\",\"name\":\"房山区\"},{\"id\":\"20318\",\"name\":\"奉贤区\"},{\"id\":\"20503\",\"name\":\"佛山市\"},{\"id\":\"21306\",\"name\":\"阜阳市\"},{\"id\":\"21401\",\"name\":\"福州市\"},{\"id\":\"21508\",\"name\":\"抚州市\"},{\"id\":\"21813\",\"name\":\"抚顺市\"},{\"id\":\"21815\",\"name\":\"阜新市\"},{\"id\":\"22206\",\"name\":\"防城港\"}],\"G\":[{\"id\":\"20501\",\"name\":\"广州市\"},{\"id\":\"21502\",\"name\":\"赣州市\"},{\"id\":\"21619\",\"name\":\"广元市\"}]}}";
    ImageView back;
    RecyclerView recycler_citys;
    CityChooseRecyclerAdapter cityChooseRecyclerAdapter;
    TextView tv_index;
    SideBar sidebar_index;
    Map<String, Object> datas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citychoose);
        initView();
        initData();
        addListener();
    }

    private void addListener() {
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ChooseCityActivity.this.finish();
            }
        });
    }

    private void initData() {
        //实际项目中数据从网络获取，这边写死数据
        Gson gson = new Gson();
        Type type =  new TypeToken<Map<String, Object>>()
        {
        }.getType();
        Map<String, Object> citysMap = gson.fromJson(data,type);
        datas = (Map<String, Object>) citysMap.get("datas");
        //初始化recyclerview
        initRecyclerView();
        //初始化sidebar
        initSideBar();
    }

    private void initRecyclerView() {
        cityChooseRecyclerAdapter= new CityChooseRecyclerAdapter(ChooseCityActivity.this,datas);
        //定义布局管理
        final GridLayoutManager linearLayoutManager = new GridLayoutManager(ChooseCityActivity.this,3);
        //布局分类的关键方法
        linearLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int result = cityChooseRecyclerAdapter.getItemViewType(position)== CityChooseRecyclerAdapter.ITEM_HEAD? 3 : 1;
                return result;
            }
        });
        recycler_citys.setLayoutManager(linearLayoutManager);
        recycler_citys.setAdapter(cityChooseRecyclerAdapter);
    }

    private void initSideBar() {
        //根据数据里的列表控制右侧导航栏
        final List<String> indexList = new ArrayList(datas.keySet());
        String[] strings = new String[indexList.size()];
        sidebar_index.INDEX_STRING = indexList.toArray(strings);
        sidebar_index.refresh();
        sidebar_index.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //滑动结束监听
//                recycler_citys.smoothScrollToPosition(index);
            }
            @Override
            public void onTouchingLetterChanging(String s) {
                //滑动过程中监听
                int index = cityChooseRecyclerAdapter.getIndexPosition(s);
                recycler_citys.scrollToPosition(index);
            }
        });
    }

    private void initView() {
        sidebar_index = (SideBar) findViewById(R.id.sidebar_index);
        tv_index = (TextView) findViewById(R.id.tv_index);
        recycler_citys = (RecyclerView) findViewById(R.id.recycler_citys);
        sidebar_index.setTextView(tv_index);
        back = (ImageView) findViewById(R.id.imageView_back);
    }

    public void selectCity(String cityId, String cityName) {
        if (!TextUtils.isEmpty(cityName)&&!TextUtils.isEmpty(cityId)){
            Toast.makeText(ChooseCityActivity.this,"cityId="+cityId+"--cityName="+cityName,Toast.LENGTH_SHORT).show();
        }
    }
}

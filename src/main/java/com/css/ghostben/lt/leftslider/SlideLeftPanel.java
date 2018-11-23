package com.css.ghostben.lt.leftslider;

import com.css.ghostben.lt.leftslider.data.DummyDataGen;
import com.css.ghostben.lt.leftslider.data.Inhabitants;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.vaadin.sliderpanel.SliderPanel;
import org.vaadin.sliderpanel.SliderPanelBuilder;
import org.vaadin.sliderpanel.SliderPanelStyles;
import org.vaadin.sliderpanel.client.SliderMode;
import org.vaadin.sliderpanel.client.SliderTabPosition;

/**
 * @program: SlideLeftPanel
 * @description: 页面左侧拉窗，用于封装部门树，功能树
 * @author: ben.zhang.b.q
 * @create: 2018-11-23 09:25
 **/
public class SlideLeftPanel extends VerticalLayout {

    public SlideLeftPanel() {
        /*
         * @author ben.zhang.b.q
         * @date 2018/11/23 16:10
         * 设置一个垂直布局的界面,做Application主界面
         **/
        final VerticalLayout contentLayout = new VerticalLayout();
        //显示的类型名
        //设置一个布局的三个基本元素
        contentLayout.setSizeFull();
        contentLayout.setMargin(false);
        contentLayout.setSpacing(true);

        //页面的水平布局，用来放置在界面中左右两边的滑动窗口
        HorizontalLayout componentLayout = new HorizontalLayout();
        //设置基本属性
        componentLayout.setSizeFull();
        componentLayout.setMargin(false);


        // 添加在Grid中的组件
        VerticalLayout gridLayout = new VerticalLayout();
        gridLayout.addComponent(new Label("周生生集团部门分布"));
        gridLayout.addComponent(genGrid());
        gridLayout.setWidth(600, Unit.PIXELS);

        //开始制作一个左边栏滑动窗口
        SliderPanel leftSlider =
                new SliderPanelBuilder(gridLayout, "部门人员树")
                        .mode(SliderMode.LEFT)
                        .autoCollapseSlider(true)
                        .tabPosition(SliderTabPosition.BEGINNING)
                        .style(SliderPanelStyles.COLOR_GRAY)
                        .flowInContent(true)
                        .build();
        //在内容显示页面添加左侧栏滑动组件
        componentLayout.addComponent(leftSlider);

        //主内容显示
        VerticalLayout calendarLabel =  new VerticalLayout(genGrid());
        //设置内容显示Label的大小边界
        calendarLabel.setMargin(true);
        calendarLabel.setSpacing(true);
        calendarLabel.setSizeFull();

        // 把内容组件添加到我们的页面内容显示组件上面
        componentLayout.addComponent(calendarLabel);
        //设置显示的位置
        componentLayout.setComponentAlignment(calendarLabel, Alignment.MIDDLE_CENTER);
        //设置显示的扩展
        componentLayout.setExpandRatio(calendarLabel, 1);

        // fit full screen
        //在主页面中添加显示的布局管理器
        contentLayout.addComponent(componentLayout);

        addComponent(componentLayout);
    }

    private VerticalLayout dummyContent(final String title, final int length) {
        String text = "虚拟使用页面内容";
        Label htmlDummy = new Label(String.format("<h3>%s</h3>%s", title, text.trim()), ContentMode.HTML);
        VerticalLayout component = new VerticalLayout(htmlDummy);
//        component.setExpandRatio(htmlDummy, 1);
        component.addComponent(new Button(title, (Button.ClickListener)
                event -> Notification.show("clicked: " + title, Notification.Type.HUMANIZED_MESSAGE)));
        component.setMargin(true);
        component.setSpacing(true);
        return component;
    }

    private Grid genGrid() {
        // init Grid
        final Grid<Inhabitants> grid = new Grid<>(Inhabitants.class);
        grid.setSizeFull();

        // init Container
        grid.setItems(DummyDataGen.genInhabitants(5));
        grid.setColumnOrder("id", "gender", "name", "bodySize", "birthday", "onFacebook");

        return grid;
    }

}

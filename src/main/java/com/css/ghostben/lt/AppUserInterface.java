package com.css.ghostben.lt;

import com.css.ghostben.lt.leftslider.SlideLeftPanel;
import com.css.ghostben.lt.leftslider.data.DummyDataGen;
import com.css.ghostben.lt.leftslider.data.Inhabitants;
import com.css.ghostben.lt.topmenu.design.TopMenu;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.sliderpanel.SliderPanel;
import org.vaadin.sliderpanel.SliderPanelBuilder;
import org.vaadin.sliderpanel.SliderPanelStyles;
import org.vaadin.sliderpanel.client.SliderMode;
import org.vaadin.sliderpanel.client.SliderTabPosition;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Title("柠檬茶")
public class AppUserInterface extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TopMenu topMenu = new TopMenu();

        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponent(topMenu);
        topMenu.setHeight(50, Unit.PIXELS);
        mainLayout.setExpandRatio(topMenu, 1);
        //设置一个布局的三个基本元素
        mainLayout.setSizeFull();
        mainLayout.setMargin(false);
        mainLayout.setSpacing(false);

        //页面的水平布局，用来放置在界面中左右两边的滑动窗口
        HorizontalLayout contentLayout = new HorizontalLayout();
        //设置基本属性
        contentLayout.setSpacing(false);
        contentLayout.setSizeFull();
        Grid grid = genGrid();
        VerticalLayout topLeftSliderContent = new VerticalLayout(new Label("集团部门分布"), grid);
        topLeftSliderContent.setMargin(true);
        topLeftSliderContent.setSpacing(true);
        topLeftSliderContent.setExpandRatio(grid, 1);
        topLeftSliderContent.setWidth(930, Unit.PIXELS);

        //开始制作一个左边栏滑动窗口
        SliderPanel leftSlider =
                new SliderPanelBuilder(topLeftSliderContent, "部门人员树")
                        .mode(SliderMode.LEFT)
                        .tabPosition(SliderTabPosition.BEGINNING)
                        .style(SliderPanelStyles.COLOR_GRAY)
                        .autoCollapseSlider(true)
                        .flowInContent(true)
                        .build();

        //主内容显示
        VerticalLayout contentLabel = new VerticalLayout(genGrid() );
        //设置内容显示Label的大小边界
        contentLabel.setMargin(true);
        contentLabel.setSizeFull();

        //在内容显示页面添加左侧栏滑动组件
        contentLayout.addComponent(leftSlider);
        //把内容组件添加到我们的页面内容显示组件上面
        contentLayout.addComponent(contentLabel);

        //设置显示的位置
        contentLayout.setComponentAlignment(contentLabel, Alignment.MIDDLE_CENTER);
        //设置显示的扩展
        contentLayout.setExpandRatio(contentLabel, 2);

        // fit full screen
        //在主页面中添加显示的布局管理器
        mainLayout.addComponent(contentLayout);
        //设置布局管理器的扩展显示
        mainLayout.setExpandRatio(contentLayout, 18);

        setContent(mainLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = AppUserInterface.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private Grid genGrid() {
        // init Grid
        final Grid<Inhabitants> grid = new Grid<>(Inhabitants.class);
        grid.setSizeFull();

        // init Container
        grid.setItems(DummyDataGen.genInhabitants(10));
        grid.setColumnOrder("id", "gender", "name", "bodySize", "birthday", "onFacebook");

        return grid;
    }
}

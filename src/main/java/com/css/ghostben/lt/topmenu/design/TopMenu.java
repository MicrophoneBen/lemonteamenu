package com.css.ghostben.lt.topmenu.design;

import com.css.ghostben.lt.leftslider.SlideLeftPanel;
import com.vaadin.server.ThemeResource;

/**
 * @program: TopMenu
 * @description: 页面顶部菜单栏
 * @author: ben.zhang.b.q
 * @create: 2018-11-23 10:40
 **/
public class TopMenu extends AbstractTopMenu{

    public TopMenu(){
        ThemeResource themeResource = new ThemeResource("img/logo.png");
        getCssLogo().setSource(themeResource);
    }
}

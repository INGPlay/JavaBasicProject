package notebook.oldMenus.util;

import notebook.oldMenus.model.TitleContent;

public class Submit {
    public static TitleContent submitTitleContent(String title, String content){
        TitleContent titleContent = new TitleContent();

        titleContent.setTitle(title);
        titleContent.setContent(content);

        return titleContent;
    }

    public static TitleContent submitTitleOnly(String title){
        TitleContent titleContent = new TitleContent();

        titleContent.setContent(title);

        return titleContent;
    }
}

package hu.carparking.managedbeans.request;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by bmbal on 2016.10.31..
 */
@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {

    @ManagedProperty(value="#{param.pageId}")
    private String pageId;

    public String showPage(){
        if(pageId == null){
            return "home";
        }
        if(pageId.equals("1")){
            return "page1";
        }else if(pageId.equals("2")){
            return "page2";
        }else{
            return "home";
        }
    }
}

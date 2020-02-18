package cn.itheima.web.action;

import cn.itheima.domain.BaseDict;
import cn.itheima.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class BaseDictAction extends ActionSupport {
    private String dict_type_code;
    private BaseDictService bs;
    @Override
    public String execute() throws Exception {
        //调用service方法查询数据字典
        List<BaseDict> list = bs.getListByDicyTypeCode(dict_type_code);
        //将数据字典返回的结果转化成json格式的字符串
        String json = JSONArray.fromObject(list).toString();
        //将json字符串返回到浏览器
        ServletActionContext.getResponse().setContentType("application/json;charset=utf8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;//告诉struts不进行结果处理
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }

    public void setBs(BaseDictService bs) {
        this.bs = bs;
    }
}

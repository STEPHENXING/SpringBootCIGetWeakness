package com.yy.springboot_find_weakness;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("entry")
    @CrossOrigin
    public String entry(@RequestParam Map<String, Object> map) {
        String result = "";
        for (Map.Entry<String, Object> ele: map.entrySet()) {
            System.out.println(ele.getKey() + "=" + ele.getValue());
            result += ele.getKey() + "=";
            result += ele.getValue() + ";";
        }

        Object[] retValue = getWeakestModule(map);

        // String result = String.format("in entry module_1 is %s, module_1 is %s", demo.module_1, demo.mark_1);
        System.out.println(result);
        return  String.format("{\"weak\":\"%s\", \"weak_mark\":\"%f\"}", retValue[0], retValue[1]);
    }


    public Object[] getWeakestModule(Map<String, Object> map) {
        Object[] retValue = {null, null};

        String[] modules = {"", "", "", "", ""};
        Float[]  marks =   {-1f, -1f, -1f, -1f, -1f};
        for (Map.Entry<String, Object> ele: map.entrySet()) {
            String param_key = ele.getKey();
            param_key = param_key.trim();
            String param_val = ele.getValue().toString();
            param_val = param_val.trim();

            if (param_key.indexOf("module_") >= 0) {
                String lastChar = param_key.substring(param_key.length()-1);
                int index = Integer.parseInt(lastChar);
                modules[index-1] = param_val;
            } else if (param_key.indexOf("mark_") >= 0) {
                String lastChar = param_key.substring(param_key.length()-1);
                int index = Integer.parseInt(lastChar);
                float val = -1f;

                try {
                    val = Float.parseFloat(param_val);
                    marks[index-1] = val;
                } catch (NumberFormatException e) {
                    System.out.println("Date format error, skip it");
                }
            }
        }

        int minIndex = -1;
        float minVal = marks[0];
        for (int i = 0; i < marks.length; i ++) {
            if (marks[i] <= minVal && marks[i] >= 0) {
                minVal = marks[i];
                minIndex = i;
            }
        }

        retValue[0] = modules[minIndex];
        retValue[1] = marks[minIndex];
        return retValue;
    }


    /**
     * 使用静态内部类,简单定义一个入参实体类
     * http://127.0.0.1:8888/?module_1=a&mark_1=1&module_2=b&mark_2=2&module_3=c&mark_3=3&module_4=e&mark_4=4&module_5=ed&mark_5=5
     */
    public static class ParamDemo {
        private String module_1;
        private String module_2;
        private String module_3;
        private String module_4;
        private String module_5;
        private String mark_1;
        private String mark_2;
        private String mark_3;
        private String mark_4;
        private String mark_5;

        public String getModule_1() {
            return module_1;
        }

        public void setModule_1(String module_1) {
            this.module_1 = module_1;
        }

        public String getModule_2() {
            return module_2;
        }

        public void setModule_2(String module_2) {
            this.module_2 = module_2;
        }

        public String getModule_3() {
            return module_3;
        }

        public void setModule_3(String module_3) {
            this.module_3 = module_3;
        }

        public String getModule_4() {
            return module_4;
        }

        public void setModule_4(String module_4) {
            this.module_4 = module_4;
        }

        public String getModule_5() {
            return module_5;
        }

        public void setModule_5(String module_5) {
            this.module_5 = module_5;
        }

        public String getMark_1() {
            return mark_1;
        }

        public void setMark_1(String mark_1) {
            this.mark_1 = mark_1;
        }

        public String getMark_2() {
            return mark_2;
        }

        public void setMark_2(String mark_2) {
            this.mark_2 = mark_2;
        }

        public String getMark_3() {
            return mark_3;
        }

        public void setMark_3(String mark_3) {
            this.mark_3 = mark_3;
        }

        public String getMark_4() {
            return mark_4;
        }

        public void setMark_4(String mark_4) {
            this.mark_4 = mark_4;
        }

        public String getMark_5() {
            return mark_5;
        }

        public void setMark_5(String mark_5) {
            this.mark_5 = mark_5;
        }
    }

}

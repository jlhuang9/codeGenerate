package com.jlhuang.gen.genHandle;

import com.jlhuang.gen.util.VelocityUtil;
import com.jlhuang.gen.filer.Filer;
import com.jlhuang.gen.message.Message;
import com.jlhuang.gen.moudel.Column;
import com.jlhuang.gen.moudel.Table;
import org.apache.velocity.VelocityContext;

import java.math.BigDecimal;
import java.util.List;

public class PojoGenerate implements Generate {

    @Override
    public void proess(String modelPath, Filer filer, VelocityContext context, Table table) {
        modelPath = Message.POJO_VM_PATH;
        System.out.println("start made pojo");
        String entry_package = (String) context.get("entry_package");
        String base_path = (String)context.get("base_path");

        String model = table.getCamelTableName();
        String outPath = base_path + "/src/main/java/" + entry_package.replace(".", "/") + "/" + model + "Pojo.java";
        List<Column> columns = table.getColumns();
        //过滤
        List<Column> columns1 = filer.columnFiler(columns);
        context.put("columns",columns1);
        proess(context, columns);
        try {
            VelocityUtil.generate(modelPath,outPath,context);
        } catch (Exception e) {
             e.printStackTrace();
        }
        System.out.println("end");
    }

    private void proess(VelocityContext context, List<Column> columns) {
        boolean useBigDecimal = false;
        boolean useDate = false;
        for (Column column : columns) {
            if (column.getDataType().equals("decimal")) {
                useBigDecimal = true;
                break;
            }
        }
        for (Column column : columns) {
            if (!column.getColumnName().equals("create_time")&&!column.getColumnName().equals("update_time")&&column.getDataType().equals("datetime")) {
                useDate = true;
                break;
            }
        }

        if (useDate) {
            context.put("useDate", true);
        }else {
            context.put("useDate", false);
        }

        if (useBigDecimal) {
            context.put("userDecimal", true);
        }else {
            context.put("userDecimal", false);
        }
    }


}

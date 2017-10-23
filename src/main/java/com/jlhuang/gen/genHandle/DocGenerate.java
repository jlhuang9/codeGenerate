package com.jlhuang.gen.genHandle;

import com.jlhuang.gen.filer.Filer;
import com.jlhuang.gen.message.Message;
import com.jlhuang.gen.moudel.Column;
import com.jlhuang.gen.moudel.Table;
import com.jlhuang.gen.util.VelocityUtil;
import org.apache.velocity.VelocityContext;

import java.util.List;

public class DocGenerate implements Generate{



    @Override
    public void proess(String modelPath, Filer filer, VelocityContext context, Table table) {
        modelPath = Message.DOC_VM_PATH;
        System.out.println("start made doc");
        String mapper_package = (String) context.get("mapper_package");
        String base_path = (String)context.get("base_path");

        String model = table.getCamelTableName();
        String outPath = base_path + "/src/main/java/" + mapper_package.replace(".", "/") + "/" + model + "Doc.text";
        List<Column> columns = table.getColumns();
        //过滤
        List<Column> columns1 = filer.columnFiler(columns);
        context.put("columns",columns1);

        try {
            VelocityUtil.generate(modelPath,outPath,context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end made doc");
    }
}
